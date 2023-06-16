package com.zaher.APIRegioes.service;

import com.zaher.APIRegioes.domain.RegiaoConverter;
import com.zaher.APIRegioes.domain.RegiaoDto;
import com.zaher.APIRegioes.model.Cidade;
import com.zaher.APIRegioes.model.Regiao;
import com.zaher.APIRegioes.repository.RegiaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class RegiaoService{

    @Autowired
    private RegiaoRepository regiaoRepository;

    public RegiaoDto insertRegiao(RegiaoDto dto){
        Optional<Regiao> regiao = regiaoRepository.findByNomeRegiao(dto.getNomeRegiao());
        if(regiao.isPresent()){
            throw new IllegalArgumentException("Regiao existente");
        }else{
            Regiao regiao1 = RegiaoConverter.toEntity(Optional.of(dto));
            return RegiaoConverter.toDto(Optional.of(regiaoRepository.save(regiao1)));
        }
    }

    public RegiaoDto update(Integer id, RegiaoDto regiaoDto ) {
        Regiao regiaoId = regiaoRepository.getReferenceById(id);
        Regiao regiao = RegiaoConverter.toEntity(Optional.of(regiaoDto));
        BeanUtils.copyProperties(regiao, regiaoId, "regiaoId");
        return RegiaoConverter.toDto(Optional.of(regiaoRepository.save(regiaoId)));
    }

    public List<RegiaoDto> getAllRegiao(){
        return regiaoRepository.findAll().stream().map(item -> RegiaoConverter.toDto(Optional.of(item))).toList();
    }
}

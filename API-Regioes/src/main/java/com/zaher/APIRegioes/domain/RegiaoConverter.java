package com.zaher.APIRegioes.domain;

import com.zaher.APIRegioes.model.Regiao;

import java.util.Optional;

public class RegiaoConverter {

    public RegiaoConverter() {
    }

    public static Regiao toEntity(Optional<RegiaoDto> dto){
        if (dto.isPresent()){
            return new Regiao(dto.get().getRegiaoId(), dto.get().getNomeRegiao(), dto.get().getAtivo(), dto.get().getCidades());
        }else{
            throw new IllegalArgumentException("User Cannot be null");
        }
    }

    //converter de entidade para dto
    public static RegiaoDto toDto(Optional<Regiao> regiao){
        if (regiao.isPresent()){
            return new RegiaoDto(regiao.get().getRegiaoId(), regiao.get().getNomeRegiao(), regiao.get().getAtivo(), regiao.get().getCidades());
        }else{
            throw new IllegalArgumentException("User Cannot be null");
        }
    }
}

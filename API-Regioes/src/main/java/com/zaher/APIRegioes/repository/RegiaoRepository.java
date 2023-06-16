package com.zaher.APIRegioes.repository;

import com.zaher.APIRegioes.domain.RegiaoDto;
import com.zaher.APIRegioes.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Integer> {

    Optional<Regiao> findByNomeRegiao(String regiao);
}

package com.zaher.APIRegioes.domain;

import com.zaher.APIRegioes.model.Cidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegiaoDto {

    private Integer regiaoId;
    private String nomeRegiao;
    private Boolean ativo;
    private List<Cidade> cidades;

}

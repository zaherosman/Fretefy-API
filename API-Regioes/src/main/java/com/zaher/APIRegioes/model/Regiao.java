package com.zaher.APIRegioes.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "regiao")
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer regiaoId;
    @Column(name = "nomeRegiao")
    private String nomeRegiao;
    @Column(name = "ativo")
    private Boolean ativo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Regiao")
    private List<Cidade> cidades;
}

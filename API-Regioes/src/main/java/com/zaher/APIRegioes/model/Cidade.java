package com.zaher.APIRegioes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cidadeId;
    @Column(name = "nomeCidade")
    private String nomeCidade;
    @Column(name = "uf")
    private String uf;
}

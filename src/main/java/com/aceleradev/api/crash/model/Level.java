package com.aceleradev.api.crash.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LEVEL")
@Data
@NoArgsConstructor
public class Level implements Serializable {

    private static final long serialVersionUID = 5102556846031766232L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEV_ID")
    private Long id;

    @Column(name = "LEV_DESCRICAO")
    private String descricao;

}

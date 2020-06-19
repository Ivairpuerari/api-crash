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
@Table(name = "SISTEMA")
@Data
@NoArgsConstructor
public class Sistema implements Serializable {

    private static final long serialVersionUID = -1658880922896615129L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SIS_ID")
    private Long id;

    @Column(name = "SIS_DESCRICAO")
    private String descricao;

    @Column(name = "SIS_STATUS")
    private String status;
}

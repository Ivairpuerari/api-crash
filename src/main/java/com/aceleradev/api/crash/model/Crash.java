package com.aceleradev.api.crash.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CRASH")
@Data
@NoArgsConstructor
public class Crash implements Serializable {

    private static final long serialVersionUID = -5403450142167030383L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CRA_ID")
    private Long id;

    @Column(name = "LEV_ID")
    private Integer levelId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LEV_ID", insertable = false, updatable = false)
    private Level level;

    @Column(name = "CRA_DESCRICAO_EVENTO")
    private String descricaoEvento;

    @Column(name = "CRA_LOG")
    private String log;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SIS_ID", insertable = false, updatable = false)
    private Sistema sistema;

    @Column(name = "SIS_ID")
    private Integer sistemaId;

    @Column(name = "CRA_DATA")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date dataCriacao;

    @Column(name = "CRA_QUANTIDADE")
    private Integer quantidade;

}

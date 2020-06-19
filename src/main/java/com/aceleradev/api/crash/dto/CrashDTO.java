package com.aceleradev.api.crash.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CrashDTO {

    private Long id;
    private String level;
    private String descricaoEvento;
    private String sistema;
    private Date data;
    private Integer quantidade;
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aceleradev.api.crash.repository;

import java.util.Date;
import java.util.List;

import com.aceleradev.api.crash.model.Crash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrashRepository extends JpaRepository<Crash, Long> {
    List<Crash> findByLevelDescricao(String descricao);

    List<Crash> findByDescricaoEvento(String descricaoEvento);

    List<Crash> findByLog(String log);

    List<Crash> findBySistemaDescricao(String sistema);

    List<Crash> findByDataCriacao(Date data);

    List<Crash> findByQuantidade(Integer quantidade);

}

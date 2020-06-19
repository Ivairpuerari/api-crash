/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aceleradev.api.crash.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.aceleradev.api.crash.dto.CrashDTO;
import com.aceleradev.api.crash.model.Crash;
import com.aceleradev.api.crash.service.CrashService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CrashController {

    @Autowired
    CrashService crashService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Crash> buscarLogDeEvento(@PathVariable Long id) {

        Optional<Crash> crash = this.crashService.buscarLogDoEvento(id);

        if (!crash.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Crash>(crash.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/paginar", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CrashDTO>> buscarTodosPorPaginacao(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
        return new ResponseEntity<List<CrashDTO>>(crashService.buscarTodosPorPaginacao(pageNo, pageSize, sortBy),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CrashDTO>> buscarTodosPorFiltro(@RequestParam(required = false) Optional<String> level,
            @RequestParam(required = false) Optional<String> descricaoEvento,
            @RequestParam(required = false) Optional<String> log,
            @RequestParam(required = false) Optional<String> sistema,
            @RequestParam(required = false) Optional<Date> data,
            @RequestParam(required = false) Optional<Integer> quantidade) {
        return new ResponseEntity<List<CrashDTO>>(
                crashService.buscarTodosPorFiltro(level, descricaoEvento, log, sistema, data, quantidade),
                HttpStatus.OK);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Crash> salvar(@RequestBody Crash crash) {
        return new ResponseEntity<Crash>(crashService.salvar(crash), HttpStatus.OK);
    }

}

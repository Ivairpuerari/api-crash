package com.aceleradev.api.crash.service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.aceleradev.api.crash.dto.CrashDTO;
import com.aceleradev.api.crash.mapper.CrashMapper;
import com.aceleradev.api.crash.model.Crash;
import com.aceleradev.api.crash.repository.CrashRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CrashService {

    @Autowired
    CrashRepository crashRepository;

    @Autowired
    CrashMapper crashMapper;

    public List<CrashDTO> buscarTodosPorPaginacao(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Crash> pagedResult = crashRepository.findAll(paging);

        return crashMapper.toListCrashDtos(pagedResult.getContent());
    }

    public Optional<Crash> buscarLogDoEvento(Long id) {
        return this.crashRepository.findById(id);
    }

    public List<CrashDTO> buscarTodosPorFiltro(Optional<String> level, Optional<String> descricaoEvento,
            Optional<String> log, Optional<String> sistema, Optional<Date> data, Optional<Integer> quantidade) {

        List<Crash> crashs = null;

        if (level.isPresent()) {
            crashs = this.crashRepository.findByLevelDescricao(level.get());
        }

        if (descricaoEvento.isPresent()) {
            crashs = this.crashRepository.findByDescricaoEvento(descricaoEvento.get());
        }

        if (log.isPresent()) {
            crashs = this.crashRepository.findByLog(log.get());
        }

        if (sistema.isPresent()) {
            crashs = this.crashRepository.findBySistemaDescricao(sistema.get());
        }

        if (data.isPresent()) {
            crashs = this.crashRepository.findByDataCriacao(data.get());
        }

        if (quantidade.isPresent()) {
            crashs = this.crashRepository.findByQuantidade(quantidade.get());
        }

        crashs = Objects.isNull(crashs) ? this.crashRepository.findAll() : crashs;

        return crashMapper.toListCrashDtos(crashs);
    }

    public Crash salvar(Crash crash) {
        return this.crashRepository.save(crash);
    }

}

package com.aceleradev.api.crash.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.aceleradev.api.crash.dto.CrashDTO;
import com.aceleradev.api.crash.model.Crash;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CrashMapper {
    public CrashDTO toCrashDto(Crash crash) {
        return Objects.isNull(crash) ? null
                : new CrashDTO(crash.getId(), crash.getLevel().getDescricao(), crash.getDescricaoEvento(),
                        crash.getSistema().getDescricao(), crash.getDataCriacao(), crash.getQuantidade());
    }

    public List<CrashDTO> toListCrashDtos(List<Crash> crashs) {
        return Objects.isNull(crashs) ? null
                : crashs.stream().map(crash -> toCrashDto(crash)).collect(Collectors.toList());
    }
}
package com.github.rogerp91.tasks_communication.presentation;

import com.github.rogerp91.tasks_communication.MapperDtoModel;
import com.github.rogerp91.tasks_communication.data.NamesDto;
import com.github.rogerp91.tasks_communication.view.NamesModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class MapperNames implements MapperDtoModel<NamesDto, NamesModel> {

    @Override
    public NamesModel toModel(NamesDto dto) {
        return new NamesModel(dto.getName(), dto.getRegion(), dto.getAge(), dto.getPhoto());
    }

    @Override
    public List<NamesModel> toModels(List<NamesDto> dtos) {
        List<NamesModel> namesModels = new ArrayList<>();
        for (NamesDto taskDto : dtos) {
            namesModels.add(toModel(taskDto));
        }
        return namesModels;
    }
}

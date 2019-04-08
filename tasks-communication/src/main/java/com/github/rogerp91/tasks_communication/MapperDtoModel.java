package com.github.rogerp91.tasks_communication;

import java.util.List;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public interface MapperDtoModel<D, M> {

    M toModel(D dto);

    List<M> toModels(List<D> dtos);

}

package com.github.rogerp91.tasks_communication.presentation;

import com.github.rogerp91.tasks_communication.data.NamesDto;
import com.github.rogerp91.tasks_communication.util.DisposableManager;
import com.github.rogerp91.tasks_communication.view.NamesModel;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class LoadCountryPresenterObserver extends DisposableObserver<List<NamesDto>> {

    private final NamesPresenter namesPresenter;

    public LoadCountryPresenterObserver(NamesPresenter namesPresenter) {
        this.namesPresenter = namesPresenter;
    }

    @Override
    public void onNext(List<NamesDto> namesDtos) {
        MapperNames mapperNames = new MapperNames();
        List<NamesModel> namesModels = mapperNames.toModels(namesDtos);
        namesPresenter.getView().showTasks(namesModels);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        dispose();
    }
}

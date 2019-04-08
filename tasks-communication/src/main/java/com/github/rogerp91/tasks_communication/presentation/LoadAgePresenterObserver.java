package com.github.rogerp91.tasks_communication.presentation;

import com.github.rogerp91.tasks_communication.data.AgeDto;
import com.github.rogerp91.tasks_communication.util.DisposableManager;

import java.util.List;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class LoadAgePresenterObserver extends DisposableObserver<List<AgeDto>> {

    private final NamesPresenter namesPresenter;

    public LoadAgePresenterObserver(NamesPresenter namesPresenter) {
        this.namesPresenter = namesPresenter;
    }

    @Override
    public void onNext(List<AgeDto> ageDtos) {
        namesPresenter.getView().showAge(ageDtos);
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {
        DisposableManager.dispose();
    }
}

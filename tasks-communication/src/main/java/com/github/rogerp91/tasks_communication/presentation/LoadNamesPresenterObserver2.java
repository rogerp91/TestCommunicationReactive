package com.github.rogerp91.tasks_communication.presentation;

import com.github.rogerp91.tasks_communication.data.NamesDto;
import com.github.rogerp91.tasks_communication.util.DisposableManager;
import com.github.rogerp91.tasks_communication.view.NamesModel;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class LoadNamesPresenterObserver2 implements Observer<List<NamesDto>> {

    private NamesPresenter namesPresenter;

    public LoadNamesPresenterObserver2(NamesPresenter namesPresenter) {
        this.namesPresenter = namesPresenter;
    }

    public LoadNamesPresenterObserver2() {
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(List<NamesDto> namesDtos) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}

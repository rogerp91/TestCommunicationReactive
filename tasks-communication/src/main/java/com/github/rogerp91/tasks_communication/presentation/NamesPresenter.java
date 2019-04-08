package com.github.rogerp91.tasks_communication.presentation;

import android.support.annotation.NonNull;

import com.github.rogerp91.tasks_communication.data.NamesDto;
import com.github.rogerp91.tasks_communication.domain.GetAge;
import com.github.rogerp91.tasks_communication.domain.GetNames;
import com.github.rogerp91.tasks_communication.domain.GetNamesForCountry;
import com.github.rogerp91.tasks_communication.util.BaseSchedulerProvider;
import com.github.rogerp91.tasks_communication.util.DisposableManager;
import com.github.rogerp91.tasks_communication.view.NamesModel;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class NamesPresenter implements NamesContract.Presenter {

    private final NamesContract.View view;
    private final GetNames getNames;
    private final GetAge getAge;
    private final GetNamesForCountry getNamesForCountry;

    public NamesPresenter(NamesContract.View view, GetNames getNames, GetAge getAge, GetNamesForCountry getNamesForCountry) {
        this.view = view;
        this.getNames = getNames;
        this.getAge = getAge;
        this.getNamesForCountry = getNamesForCountry;
    }

    @Override
    public void loadTasks() {
        LoadNamesPresenterObserver loadTaskDisposableObserver = new LoadNamesPresenterObserver(this);
        getNames.execute(loadTaskDisposableObserver);
    }

    @Override
    public void loadAge() {
        LoadAgePresenterObserver loadAgePresenterObserver = new LoadAgePresenterObserver(this);
        getAge.execute(loadAgePresenterObserver);
    }


    @Override
    public void loadCountry() {
        LoadCountryPresenterObserver loadCountryPresenterObserver = new LoadCountryPresenterObserver(this);
        getNamesForCountry.execute(loadCountryPresenterObserver);
    }

    @NonNull
    NamesContract.View getView() {
        return view;
    }

}

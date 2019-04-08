package com.github.rogerp91.tasks_communication.domain;

import android.support.annotation.NonNull;

import com.github.rogerp91.tasks_communication.data.NamesDto;
import com.github.rogerp91.tasks_communication.data.NamesDataSource;
import com.github.rogerp91.tasks_communication.presentation.LoadNamesPresenterObserver2;
import com.github.rogerp91.tasks_communication.util.BaseSchedulerProvider;
import com.github.rogerp91.tasks_communication.util.DisposableManager;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class GetNames extends UseCase<List<NamesDto>> {

    public GetNames(NamesDataSource tasksDataSource, BaseSchedulerProvider schedulerProvider) {
        super(tasksDataSource, schedulerProvider);
    }

    @Override
    protected Observable<List<NamesDto>> buildUseCaseObservable() {
        return tasksDataSource.getNames();
    }

    /**
     * TODO: EJEMPLO
     */
    public void execute2(DisposableObserver<List<NamesDto>> observer) {
        final Observable<List<NamesDto>> observable =
                tasksDataSource.getNames()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());;
        DisposableManager.add(observable.subscribeWith(observer));
    }

    /**
     * TODO: EJEMPLO
     */
    protected void buildUseCaseObservable3() {
        tasksDataSource
                .getNames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<NamesDto>>() {
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
                });

    }
}

package com.github.rogerp91.tasks_communication.domain;

import android.support.annotation.NonNull;

import com.github.rogerp91.tasks_communication.data.NamesDataSource;
import com.github.rogerp91.tasks_communication.util.BaseSchedulerProvider;
import com.github.rogerp91.tasks_communication.util.DisposableManager;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public abstract class UseCase<T> {

    protected NamesDataSource tasksDataSource;
    private final BaseSchedulerProvider schedulerProvider;

    public UseCase(NamesDataSource tasksDataSource, BaseSchedulerProvider schedulerProvider) {
        this.tasksDataSource = tasksDataSource;
        this.schedulerProvider = schedulerProvider;
    }

    protected abstract Observable<T> buildUseCaseObservable();

    public void execute(@NonNull DisposableObserver<T> observer) {
        final Observable<T> observable =
                buildUseCaseObservable()
                        .subscribeOn(schedulerProvider.io())
                        .observeOn(schedulerProvider.ui());
        DisposableManager.add(observable.subscribeWith(observer));
    }
}

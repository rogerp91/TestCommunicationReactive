package com.github.rogerp91.tasks_communication.domain;

import com.github.rogerp91.tasks_communication.data.NamesDataSource;

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
public abstract class UseCase2<T> {

    protected NamesDataSource tasksDataSource;
    protected Disposable disposable = Disposables.empty();
    private final CompositeDisposable compositeDisposable;

    public UseCase2(NamesDataSource tasksDataSource) {
        this.tasksDataSource = tasksDataSource;
        this.compositeDisposable = new CompositeDisposable();
    }

    protected abstract Observable<T> buildUseCaseObservable();

    public <S extends Observer<T> & Disposable> void execute(S useCaseDisposable) {
        disposable = buildUseCaseObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribeWith(useCaseDisposable);
    }

    public void execute(DisposableObserver<T> observer) {
        final Observable<T> observable = buildUseCaseObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread());
        compositeDisposable.add(observable.subscribeWith(observer));
    }

    public void unsubscribe() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    public boolean isUnsubscribed() {
        return disposable.isDisposed();
    }

    public boolean isUnsubscribedComposite() {
        return compositeDisposable.isDisposed();
    }
}

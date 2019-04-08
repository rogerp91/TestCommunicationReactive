package com.github.rogerp91.tasks_communication.domain;

import android.support.annotation.NonNull;

import com.github.rogerp91.tasks_communication.data.NamesDataSource;
import com.github.rogerp91.tasks_communication.data.NamesDto;
import com.github.rogerp91.tasks_communication.util.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class GetNamesForCountry extends UseCase<List<NamesDto>> {

    public GetNamesForCountry(NamesDataSource tasksDataSource, BaseSchedulerProvider schedulerProvider) {
        super(tasksDataSource, schedulerProvider);
    }

    @Override
    protected Observable<List<NamesDto>> buildUseCaseObservable() {
        return tasksDataSource
                .getNames()
                .flatMap(new Function<List<NamesDto>, ObservableSource<List<NamesDto>>>() {
                    @Override
                    public ObservableSource<List<NamesDto>> apply(final List<NamesDto> namesDtos) throws Exception {
                        return getListObservableSourceFilter(namesDtos);
                    }
                })
                .flatMap(new Function<List<NamesDto>, ObservableSource<List<NamesDto>>>() {
                    @Override
                    public ObservableSource<List<NamesDto>> apply(List<NamesDto> namesDtos) throws Exception {
                        return getListObservableSourceIterable(namesDtos);
                    }
                });
    }

    /**
     * @param namesDtos
     * @return
     */
    private ObservableSource<List<NamesDto>> getListObservableSourceFilter(@NonNull final List<NamesDto> namesDtos) {
        return Observable.create(new ObservableOnSubscribe<List<NamesDto>>() {
            @Override
            public void subscribe(ObservableEmitter<List<NamesDto>> emitter) throws Exception {
                emitterReturnEvent(emitter, namesDtos);
            }
        });
    }

    /**
     * @param emitter
     * @param namesDtos
     */
    private void emitterReturnEvent(@NonNull final ObservableEmitter<List<NamesDto>> emitter, @NonNull final List<NamesDto> namesDtos) {
        List<NamesDto> newNamesDtos = new ArrayList<>();
        for (NamesDto namesDto : namesDtos) {
            if (namesDto.getAge() >= 32) {
                newNamesDtos.add(namesDto);
            }
        }
        emitter.onNext(newNamesDtos);
        emitter.onComplete();
    }

    /**
     * @param namesDtos
     * @return
     */
    private ObservableSource<List<NamesDto>> getListObservableSourceIterable(@NonNull final List<NamesDto> namesDtos) {
        return Observable.fromIterable(namesDtos).
                flatMap(new Function<NamesDto, ObservableSource<List<NamesDto>>>() {
                    @Override
                    public ObservableSource<List<NamesDto>> apply(NamesDto namesDto) throws Exception {
                        return tasksDataSource.getCountry(namesDto.getRegion());
                    }
                });
    }

}

package com.github.rogerp91.tasks_communication.domain;

import com.github.rogerp91.tasks_communication.data.AgeDto;
import com.github.rogerp91.tasks_communication.data.NamesDataSource;
import com.github.rogerp91.tasks_communication.data.NamesDto;
import com.github.rogerp91.tasks_communication.util.BaseSchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class GetAge extends UseCase<List<AgeDto>> {

    public GetAge(NamesDataSource tasksDataSource, BaseSchedulerProvider schedulerProvider) {
        super(tasksDataSource, schedulerProvider);
    }

    @Override
    protected Observable<List<AgeDto>> buildUseCaseObservable() {
        return tasksDataSource
                .getNames()
                .map(new Function<List<NamesDto>, List<AgeDto>>() {
                    @Override
                    public List<AgeDto> apply(List<NamesDto> namesDtos) throws Exception {
                        List<AgeDto> ageDtos = new ArrayList<>();
                        for (NamesDto namesDto : namesDtos) {
                            ageDtos.add(new AgeDto(namesDto.getAge()));
                        }
                        return ageDtos;
                    }
                }).flatMap(new Function<List<AgeDto>, ObservableSource<List<AgeDto>>>() {
                    @Override
                    public ObservableSource<List<AgeDto>> apply(final List<AgeDto> ageDtos) throws Exception {
                        return Observable.create(new ObservableOnSubscribe<List<AgeDto>>() {
                            @Override
                            public void subscribe(ObservableEmitter<List<AgeDto>> emitter) throws Exception {
                                List<AgeDto> ageDtos2 = new ArrayList<>();
                                for (AgeDto ageDto : ageDtos) {
                                    if (ageDto.getAge() >= 30) {
                                        ageDtos2.add(ageDto);
                                    }
                                }

                                emitter.onNext(ageDtos2);
                                emitter.onComplete();
                            }
                        });
                    }
                });
    }
}

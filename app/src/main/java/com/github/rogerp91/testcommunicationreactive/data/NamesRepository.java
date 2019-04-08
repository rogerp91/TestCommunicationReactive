package com.github.rogerp91.testcommunicationreactive.data;

import android.os.Parcel;
import android.support.annotation.NonNull;

import com.github.rogerp91.tasks_communication.data.NamesDataSource;
import com.github.rogerp91.tasks_communication.data.NamesDto;
import com.github.rogerp91.testcommunicationreactive.data.dto.NamesBo;
import com.github.rogerp91.testcommunicationreactive.data.remote.NameDefinition;
import com.github.rogerp91.testcommunicationreactive.data.remote.NamesApi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class NamesRepository implements NamesDataSource {

    @Override
    public Observable<List<NamesDto>> getNames() {
            return Observable.create(new ObservableOnSubscribe<List<NamesDto>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<NamesDto>> emitter) throws Exception {
                NameDefinition service = NamesApi.getClient().create(NameDefinition.class);
                service.getNames().enqueue(new Callback<List<NamesBo>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<NamesBo>> call, @NonNull Response<List<NamesBo>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<NamesDto> namesDtos = getNamesDtos(response.body());
                            emitter.onNext(namesDtos);
                            emitter.onComplete();
                        } else {
                            emitter.onError(new NullPointerException("Error"));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<NamesBo>> call, @NonNull Throwable t) {
                        emitter.onError(t);
                    }
                });
            }
        });
    }

    @Override
    public Observable<List<NamesDto>> getCountry(final String region) {
        return Observable.create(new ObservableOnSubscribe<List<NamesDto>>() {
            @Override
            public void subscribe(final ObservableEmitter<List<NamesDto>> emitter) throws Exception {
                NameDefinition service = NamesApi.getClient().create(NameDefinition.class);
                service.getNamesForCountry(region).enqueue(new Callback<List<NamesBo>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<NamesBo>> call, @NonNull Response<List<NamesBo>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<NamesDto> namesDtos = getNamesDtos(response.body());
                            emitter.onNext(namesDtos);
                            emitter.onComplete();
                        } else {
                            emitter.onError(new NullPointerException("Error"));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<NamesBo>> call, @NonNull Throwable t) {
                        emitter.onError(t);
                    }
                });
            }
        });
    }

    private List<NamesDto> getNamesDtos(List<NamesBo> namesBos) {
        List<NamesDto> namesDtos = new ArrayList<>();
        for (NamesBo namesBo : namesBos) {
            namesDtos.add(new NamesDto(namesBo.getName(), namesBo.getRegion(), namesBo.getAge(), namesBo.getPhoto()));
        }

        return namesDtos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    public NamesRepository() {
    }

    protected NamesRepository(Parcel in) {
    }

    public static final Creator<NamesRepository> CREATOR = new Creator<NamesRepository>() {
        @Override
        public NamesRepository createFromParcel(Parcel source) {
            return new NamesRepository(source);
        }

        @Override
        public NamesRepository[] newArray(int size) {
            return new NamesRepository[size];
        }
    };
}

package com.github.rogerp91.testcommunicationreactive.data.remote;

import com.github.rogerp91.testcommunicationreactive.data.dto.NamesBo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public interface NameDefinition {

    //united+states
    @GET("?ext&amount=25&region=random&gender=random&source=uinames.com")
    Call<List<NamesBo>> getNames();

    @GET("?ext&amount=25&&gender=random&source=uinames.com")
    Call<List<NamesBo>> getNamesForCountry(@Query("country") String country);
}

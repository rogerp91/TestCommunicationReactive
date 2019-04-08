package com.github.rogerp91.tasks_communication.data;

import android.os.Parcelable;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public interface NamesDataSource extends Parcelable {

    Observable<List<NamesDto>> getNames();

    Observable<List<NamesDto>> getCountry(String region);

}

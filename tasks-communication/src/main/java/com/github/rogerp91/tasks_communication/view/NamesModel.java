package com.github.rogerp91.tasks_communication.view;

import android.support.annotation.Nullable;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class NamesModel {

    private String name;
    private String region;
    private Integer age;
    private String photo;

    public NamesModel(String name, String region, Integer age, String photo) {
        this.name = name;
        this.region = region;
        this.age = age;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoto() {
        return photo;
    }
}

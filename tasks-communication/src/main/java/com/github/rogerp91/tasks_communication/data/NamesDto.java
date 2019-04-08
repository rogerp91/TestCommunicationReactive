package com.github.rogerp91.tasks_communication.data;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */

/**
 * Immutable model class for a Task.
 */
public final class NamesDto {

    private String name;
    private String region;
    private Integer age;
    private String photo;

    public NamesDto(String name, String region, Integer age, String photo) {
        this.name = name;
        this.region = region;
        this.age = age;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

package com.github.rogerp91.testcommunicationreactive.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class BirthdayBo {

    @SerializedName("dmy")
    private String dmy;
    @SerializedName("mdy")
    private String mdy;
    @SerializedName("raw")
    private Integer raw;

    public String getDmy() {
        return dmy;
    }

    public void setDmy(String dmy) {
        this.dmy = dmy;
    }

    public String getMdy() {
        return mdy;
    }

    public void setMdy(String mdy) {
        this.mdy = mdy;
    }

    public Integer getRaw() {
        return raw;
    }

    public void setRaw(Integer raw) {
        this.raw = raw;
    }
}

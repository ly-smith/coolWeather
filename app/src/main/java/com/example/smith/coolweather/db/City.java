package com.example.smith.coolweather.db;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class City extends DataSupport{
    private int id;
    private  String cityName;       //城市名字
    private  int cityCode;          //城市ID
    private int provinceId;         //记录当前市所属省份的ID值

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}

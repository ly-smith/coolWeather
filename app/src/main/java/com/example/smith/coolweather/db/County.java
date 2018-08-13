package com.example.smith.coolweather.db;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class County extends DataSupport {
    private int id;
    private String countyName;      //记录县的名字
    private String weatherId;       //天气ID
    private int cityId;             //当前县对应的市ID

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countName) {
        this.countyName = countName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}

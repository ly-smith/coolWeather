package com.example.smith.coolweather.db;

import android.os.Parcel;
import android.os.Parcelable;

import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.MySQLConnection;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

public class Province extends DataSupport{
    private int id;
    private String provinceName;    //省份名字
    private int provinceCode;       //省份ID

    public int getId() {
        return id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}

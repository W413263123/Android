package com.example.jesophwen.coolweather.util;

import android.text.TextUtils;

import com.example.jesophwen.coolweather.db.CoolWeatherDB;
import com.example.jesophwen.coolweather.model.City;
import com.example.jesophwen.coolweather.model.County;
import com.example.jesophwen.coolweather.model.Province;

/**
 * Created by wenkui on 16/10/8.
 * 数据解析辅助类
 */

public class Utility {
    /**
     * 解析服务器返回的数据
     */
    public synchronized static boolean handleProvinceResponse(CoolWeatherDB coolWeatherDB, String
            response) {
        if (!TextUtils.isEmpty(response)) {
            String[] allProvince = response.split(",");
            if (allProvince != null && allProvince.length > 0) {
                for (String p : allProvince) {
                    String[] messages = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(messages[0]);
                    province.setProvinceName(messages[1]);
                    // 将解析出来的数据存储到数据库Province表
                    coolWeatherDB.saveProvince(province);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析处理返回的市级数据
     */
    public synchronized static boolean handleCityResponse(CoolWeatherDB coolWeather, String
            response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            String[] cities = response.split(",");
            if (cities != null && cities.length > 0) {
                for (String c : cities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setProvinceId(provinceId);
                    city.setCityName(array[1]);
                    city.setCityCode(array[0]);
                    // 将解析出来的数据存储到数据库City表
                    coolWeather.saveCity(city);
                }
                return true;
            }
        }

        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountiesResponse(CoolWeatherDB coolWeatherDB, String response,
                                                 int cityId) {
        if (!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if (allCounties != null && allCounties.length > 0) {
                for (String c : allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    // 将解析出来的数据存储到County表
                    coolWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }
}

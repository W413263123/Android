package com.example.jesophwen.coolweather.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jesophwen.coolweather.R;
import com.example.jesophwen.coolweather.db.CoolWeatherDB;
import com.example.jesophwen.coolweather.model.City;
import com.example.jesophwen.coolweather.model.County;
import com.example.jesophwen.coolweather.model.Province;
import com.example.jesophwen.coolweather.util.HttpCallBackListenter;
import com.example.jesophwen.coolweather.util.HttpUtil;
import com.example.jesophwen.coolweather.util.Utility;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ChooseAreaActivity extends Activity {

    public static final int LEVEL_PROVINCE = 0;  // 设置省级的信息级别
    public static final int LEVEL_CITY = 1;  // 设置市级的信息级别
    public static final int LEVEL_COUNTY = 2;  // 设置县级的信息级别

    private ProgressDialog progressDialog;
    private TextView titleText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private CoolWeatherDB coolWeatherDB;
    private List<String> dataList = new ArrayList<String>();
    private List<Province> provinceList;  // 省列表
    private List<City> cityList;  // 市列表
    private List<County> countyList;  // 县列表
    private Province selectProvince;  // 选中的省份
    private City selectCity;  // 选中的城市
    private int currentLevel;  // 当前选中的级别


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /** 隐藏标题栏 */
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.choose_area);
        listView = (ListView) findViewById(R.id.list_view);
        titleText = (TextView) findViewById(R.id.title_text);
        /** 设置列表视图适配器 */
        adapter = new ArrayAdapter<String>(ChooseAreaActivity.this, android.R.layout
                .simple_list_item_1, dataList);
        listView.setAdapter(adapter);
        /** 获取数据库管理对象 */
        coolWeatherDB = CoolWeatherDB.getInstance(ChooseAreaActivity.this);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentLevel == LEVEL_PROVINCE) {
                    selectProvince = provinceList.get(position);
                    /** 查询市级数据 */
                    queryCities();
                } else if (currentLevel == LEVEL_CITY) {
                    selectCity = cityList.get(position);
                    /** 查询县级数据 */
                    queryCounties();
                }
            }
        });
        /** 查询省级数据 */
        queryProvinces();
    }

    /**
     * 从数据库中查询省级数据
     */
    public void queryProvinces() {
        /** 从数据库中读取省份信息 */
        provinceList = coolWeatherDB.loadProvinces();
        /** 判断数据库中是否存在省份信息 */
        if (provinceList.size() > 0) {
            /** 存在则清空当前数据源数据 */
            dataList.clear();
            /** 设置数据源数据 */
            for (Province province : provinceList) {
                /** 将省份的名字添加到数据源中 */
                dataList.add(province.getProvinceName());
            }
            /** 通知视图刷新列表视图 */
            adapter.notifyDataSetChanged();
            /** 设置当前的列表等级 */
            currentLevel = LEVEL_PROVINCE;
            /** 设置列表视图的当前选中的表格 */
            listView.setSelection(0);
            /** 设置标题显示的内容 */
            titleText.setText("中国");
        } else {
            queryFromServer(null, "province");
        }
    }

    /**
     * 从数据库中查询市级数据
     */
    public void queryCities() {
        cityList = coolWeatherDB.loadCities(selectProvince.getId());
        if (cityList.size() > 0) {
            dataList.clear();
            for (City city : cityList) {
                dataList.add(city.getCityName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_CITY;
            titleText.setText(selectProvince.getProvinceName());
        } else {
            queryFromServer(selectProvince.getProvinceName(), "city");
        }
    }

    /**
     * 从数据库中查询县级数据
     */
    public void queryCounties() {
        countyList = coolWeatherDB.loadCounties(selectCity.getId());
        if (countyList.size() > 0) {
            dataList.clear();
            for (County county : countyList) {
                dataList.add(county.getCountyName());
            }
            adapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel = LEVEL_COUNTY;
            titleText.setText(selectCity.getCityName());
        } else {
            queryFromServer(encodeWithUTF8(selectCity.getCityName()), "county");
        }

    }

    /**
     * 将中文字符进行UTF-8 编码
     */
    public String encodeWithUTF8(String string) {
        String strUTF8 = null;
        try {
            String strGBK = URLEncoder.encode(string, "GBK");
            System.out.println(strGBK);
            strUTF8 = URLDecoder.decode(string, "UTF-8");
            System.out.println(strUTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return strUTF8;
        }
    }

    /**
     * 从网络获取当前数据
     */
    public void queryFromServer(final String name, final String type) {
        /** 设置请求地址 */
        String address;
        if (!TextUtils.isEmpty(name)) {
            address = "http://apis.baidu.com/apistore/weatherservice/cityinfo?cityname=" + name;
        } else {
            address = "http://www.weather.com.cn/data/city3jdata/china.html";
        }
        /** 弹出进度框 */
        showProgressDialog();
        /** 设置网络请求适配器 */
        HttpUtil.sendHttpRequest(address, new HttpCallBackListenter() {
            @Override
            public void onFinish(String response) {
                boolean result = false;
                if ("province".equals(type)) {
                    result = Utility.handleProvinceResponse(coolWeatherDB, response);
                } else if ("city".equals(type)) {
                    result = Utility.handleCityResponse(coolWeatherDB, response, selectProvince
                            .getId());
                } else if ("county".equals(type)) {
                    result = Utility.handleCountiesResponse(coolWeatherDB, response, selectCity
                            .getId());
                }

                if (result) {
                    /** 数据请求成功返回主线程处理 */
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            /** 关闭请求对话框 */
                            closeProgressDialog();
                            if ("province".equals(type)) {
                                queryProvinces();
                            } else if ("city".equals(type)) {
                                queryCities();
                            } else if ("county".equals(type)) {
                                queryCounties();
                            }
                        }
                    });
                }
            }

            @Override
            public void onError(Exception e) {
                /** 返回主线程处理逻辑 */
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        closeProgressDialog();
                        Toast.makeText(ChooseAreaActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /**
     * 显示当前的网络请求状态的弹出框
     */
    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(ChooseAreaActivity.this);
            progressDialog.setMessage("正在加载...");
            progressDialog.setCanceledOnTouchOutside(false);
        }
        progressDialog.show();
    }

    /**
     * 关闭当前的网络请求状态的弹出框
     */
    public void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    /**
     * 返回按钮点击
     */
    @Override
    public void onBackPressed() {
        if (currentLevel == LEVEL_COUNTY) {
            queryCities();
        } else if (currentLevel == LEVEL_CITY) {
            queryProvinces();
        } else {
            finish();
        }
    }
}

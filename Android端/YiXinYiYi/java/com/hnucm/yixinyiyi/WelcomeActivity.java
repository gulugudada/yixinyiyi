package com.hnucm.yixinyiyi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends AppCompatActivity {

    public LocationClient mLocationClient;
    String province;
    String city;
    String district;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        x.Ext.init(getApplication());//网络xutils初始化
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new WelcomeActivity.MyLocationListener());
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(WelcomeActivity.this, Manifest.
                permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(WelcomeActivity.this,Manifest.
                permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(WelcomeActivity.this,Manifest.
                permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()){
            String [] permissions = permissionList.toArray(new String[permissionList.
                    size()]);
            ActivityCompat.requestPermissions(WelcomeActivity.this,permissions,1);
        }
        else{
            requestLocation();
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 * 延时执行的代码
                 */
                SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
                boolean isLogin = sharedPreferences.getBoolean("isLogin",false);
                Intent intent;
                if(isLogin){
                    intent = new Intent(WelcomeActivity.this,MainActivity.class);
                }
                else{
                    intent = new Intent(WelcomeActivity.this,LoginActivity.class);
                }
                intent.putExtra("province",province);
                intent.putExtra("city",city);
                intent.putExtra("district",district);
                startActivity(intent);
                WelcomeActivity.this.finish();//结束当前activity
            }
        },2000); // 延时2秒
    }

    private void requestLocation(){
        initLocation();
        mLocationClient.start();
    }

    private void  initLocation(){
        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        option.setLocationMode(LocationClientOption.LocationMode.Device_Sensors);
        mLocationClient.setLocOption(option);
    }

    protected  void onDestory(){
        super.onDestroy();
        mLocationClient.stop();
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(final BDLocation location) {
            province = location.getProvince();
            city = location.getCity();
            district = location.getDistrict();
            mLocationClient.stop();
        }

        public void onConnectHotSpotMessage(String s,int i){

        }
    }
}
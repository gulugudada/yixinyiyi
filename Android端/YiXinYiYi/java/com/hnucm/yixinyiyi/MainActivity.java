package com.hnucm.yixinyiyi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;

public class MainActivity extends AppCompatActivity {

    HomePageFragment homePageFragment = new HomePageFragment();
    SelfMedicineFragment selfMedicineFragment = new SelfMedicineFragment();
    RobotFragment robotFragment = new RobotFragment();
    MyFragment myFragment = new MyFragment();

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout1 = findViewById(R.id.constraintLayout3);
        ConstraintLayout constraintLayout2 = findViewById(R.id.constraintLayout2);
        ConstraintLayout constraintLayout3 = findViewById(R.id.constraintLayout4);
        ConstraintLayout constraintLayout4 = findViewById(R.id.constraintLayout5);
        String province = getIntent().getStringExtra("province");
        String city = getIntent().getStringExtra("city");
        String district = getIntent().getStringExtra("district");
        Log.i("sb",province+city+district);
        Bundle sendBundle = new Bundle();
        sendBundle.putString("province",province);
        sendBundle.putString("city",city);
        sendBundle.putString("district",district);
        homePageFragment.setArguments(sendBundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout,homePageFragment).commit();
        constraintLayout1.setSelected(true);
        constraintLayout2.setSelected(false);
        constraintLayout3.setSelected(false);
        constraintLayout4.setSelected(false);
        constraintLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout,homePageFragment).commit();
                constraintLayout1.setSelected(true);
                constraintLayout2.setSelected(false);
                constraintLayout3.setSelected(false);
                constraintLayout4.setSelected(false);
            }
        });
        constraintLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout,selfMedicineFragment).commit();
                constraintLayout1.setSelected(false);
                constraintLayout2.setSelected(true);
                constraintLayout3.setSelected(false);
                constraintLayout4.setSelected(false);
            }
        });
        constraintLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout,robotFragment).commit();
                constraintLayout1.setSelected(false);
                constraintLayout2.setSelected(false);
                constraintLayout3.setSelected(true);
                constraintLayout4.setSelected(false);
            }
        });
        constraintLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout,myFragment).commit();
                constraintLayout1.setSelected(false);
                constraintLayout2.setSelected(false);
                constraintLayout3.setSelected(false);
                constraintLayout4.setSelected(true);
            }
        });
    }
}
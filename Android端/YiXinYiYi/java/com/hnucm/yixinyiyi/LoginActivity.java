package com.hnucm.yixinyiyi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.button);
        Button register = findViewById(R.id.button2);
        EditText tel = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tel.getText().toString().equals("")){
                    AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this)
                            .setTitle("警告")
                            .setMessage("电话号码不能为空！")
                            .setIcon(R.mipmap.ic_launcher)
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .create();
                    alertDialog.show();
                }
                else{
                    if(password.getText().toString().equals("")){
                        AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this)
                                .setTitle("警告")
                                .setMessage("密码不能为空！")
                                .setIcon(R.mipmap.ic_launcher)
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                })
                                .create();
                        alertDialog.show();
                    }
                    else{
                        RequestParams requestParams = new RequestParams("http://yzx.free.idcfengye.com/findPassWordByAccount");
                        requestParams.addParameter("account",tel.getText().toString());
                        requestParams.addParameter("password",password.getText().toString());
                        x.http().post(requestParams, new Callback.CommonCallback<String>() {
                            @Override
                            public void onSuccess(String result) {
                                String msg = "";
                                int code = -1;
                                try {
                                    JSONObject jsonObject = new JSONObject(result);
                                    msg = jsonObject.getString("msg");
                                    code = jsonObject.getInt("code");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                if(code == 0){
                                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                    SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putBoolean("isLogin",true);
                                    editor.putString("account",tel.getText().toString());
                                    editor.commit();
                                    intent.putExtra("province",getIntent().getStringExtra("province"));
                                    intent.putExtra("city",getIntent().getStringExtra("city"));
                                    intent.putExtra("district",getIntent().getStringExtra("district"));
                                    startActivity(intent);
                                    finish();//结束当前activity
                                }
                                else{
                                    AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this)
                                            .setTitle("警告")
                                            .setMessage(msg+"！")
                                            .setIcon(R.mipmap.ic_launcher)
                                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                }
                                            })
                                            .create();
                                    alertDialog.show();
                                }
                            }

                            @Override
                            public void onError(Throwable ex, boolean isOnCallback) {

                            }

                            @Override
                            public void onCancelled(CancelledException cex) {

                            }

                            @Override
                            public void onFinished() {

                            }
                        });
                    }
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
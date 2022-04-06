package com.hnucm.yixinyiyi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button register = findViewById(R.id.button3);
        Button fanhui = findViewById(R.id.button4);
        EditText tel = findViewById(R.id.editTextTextPersonName2);
        EditText username = findViewById(R.id.editTextTextPersonName3);
        EditText password = findViewById(R.id.editTextTextPassword2);
        EditText password2 = findViewById(R.id.editTextTextPassword3);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tel.getText().toString().equals("")) {
                    AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this)
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
                else {
                    if (username.getText().toString().equals("")) {
                        AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this)
                                .setTitle("警告")
                                .setMessage("用户名不能为空！")
                                .setIcon(R.mipmap.ic_launcher)
                                .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                })
                                .create();
                        alertDialog.show();
                    }
                    else {
                        if (password.getText().toString().equals("") || password2.getText().toString().equals("")) {
                            AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this)
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
                        else {
                            if (!password.getText().toString().equals(password2.getText().toString())) {
                                AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this)
                                        .setTitle("警告")
                                        .setMessage("两次密码不一致！")
                                        .setIcon(R.mipmap.ic_launcher)
                                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                            }
                                        })
                                        .create();
                                alertDialog.show();
                            }
                            else {
                                RequestParams requestParams = new RequestParams("http://yzx.free.idcfengye.com/addAccount");
                                requestParams.addParameter("account",tel.getText().toString());
                                requestParams.addParameter("username",username.getText().toString());
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
                                            finish();//结束当前activity
                                        }
                                        else{
                                            AlertDialog alertDialog = new AlertDialog.Builder(RegisterActivity.this)
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
                }
            }
        });
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
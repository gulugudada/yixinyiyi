package com.hnucm.yixinyiyi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class GerenxinxiActivity extends AppCompatActivity {

    private Dialog upSex;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        upSex = new Dialog(GerenxinxiActivity.this, R.style.dialog);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerenxinxi);
        EditText usernameEdit = findViewById(R.id.editTextTextPersonName4);
        EditText usernameEdit1 = findViewById(R.id.editTextTextPersonName6);
        EditText usernameEdit2 = findViewById(R.id.editTextTextPersonName7);
        EditText usernameEdit3 = findViewById(R.id.editTextTextPersonName8);
        EditText usernameEdit4 = findViewById(R.id.editTextTextPersonName9);
        EditText usernameEdit5 = findViewById(R.id.editTextTextPersonName10);
        EditText usernameEdit6 = findViewById(R.id.editTextTextPersonName11);
        Button wancheng = findViewById(R.id.button9);
        Button fanhui = findViewById(R.id.button10);
        ConstraintLayout constraintLayout1 = findViewById(R.id.constaintLayout6);
        ConstraintLayout constraintLayout2 = findViewById(R.id.constaintLayout1);
        ConstraintLayout constraintLayout3 = findViewById(R.id.constaintLayout7);
        ConstraintLayout constraintLayout4 = findViewById(R.id.constaintLayout8);
        usernameEdit.setText(getIntent().getStringExtra("username"));
        usernameEdit1.setText(getIntent().getStringExtra("sex"));
        usernameEdit2.setText(getIntent().getStringExtra("birthday"));
        usernameEdit3.setText(getIntent().getStringExtra("school"));
        usernameEdit5.setText(getIntent().getStringExtra("college"));
        usernameEdit6.setText(getIntent().getStringExtra("grade")+getIntent().getStringExtra("administrativeclass"));
        usernameEdit4.setText(getIntent().getStringExtra("province")+getIntent().getStringExtra("city")+getIntent().getStringExtra("district"));
        wancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams requestParams = new RequestParams("http://yzx.free.idcfengye.com/updateUser");
                requestParams.addParameter("username",getIntent().getStringExtra("username"));
                Log.i("sb",usernameEdit1.getText().toString());
                requestParams.addParameter("sex",usernameEdit1.getText().toString());
                requestParams.addParameter("birthday",usernameEdit2.getText());
                requestParams.addParameter("school",usernameEdit3.getText().toString()+usernameEdit6.getText().toString().split("级")[0]+usernameEdit5.getText().toString()+usernameEdit6.getText().toString().split("级")[1]);
                requestParams.addParameter("location",usernameEdit4.getText().toString());
                x.http().post(requestParams, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {

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
                finish();
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
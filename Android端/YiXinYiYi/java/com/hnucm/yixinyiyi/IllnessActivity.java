package com.hnucm.yixinyiyi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class IllnessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_illness);
        TextView name = findViewById(R.id.textView38);
        TextView jieshao = findViewById(R.id.textView40);
        TextView biaoxian = findViewById(R.id.textView42);
        TextView advice = findViewById(R.id.textView44);
        ImageView imageView = findViewById(R.id.imageView10);
        name.setText(getIntent().getStringExtra("illnessname"));
        jieshao.setText(getIntent().getStringExtra("introduction"));
        biaoxian.setText(getIntent().getStringExtra("feature"));
        advice.setText(getIntent().getStringExtra("advice"));
        Glide.with(IllnessActivity.this).load("http://yzx.free.idcfengye.com/" + getIntent().getStringExtra("image")).into(imageView);
    }
}
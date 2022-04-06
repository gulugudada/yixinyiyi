package com.hnucm.yixinyiyi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class YangShengActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yang_sheng);
        String season = getIntent().getStringExtra("season");
        recyclerView = findViewById(R.id.recyclerView2);
        TextView season1 = findViewById(R.id.textView24);
        season1.setText(season);
        RequestParams requestParams = new RequestParams("http://yzx.free.idcfengye.com/findYangSheng");
        requestParams.addParameter("season",season);
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    jsonArray = jsonObject.getJSONArray("yangsheng");
                    myAdapter = new MyAdapter();
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(YangShengActivity.this));
                } catch (JSONException e) {
                    e.printStackTrace();
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

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(YangShengActivity.this).inflate(R.layout.item_list2,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            try {
                holder.cookbook.setText(jsonArray.getJSONObject(position).getString("cookbook"));
                holder.method.setText(jsonArray.getJSONObject(position).getString("method"));
                Glide.with(YangShengActivity.this).load("http://yzx.free.idcfengye.com/"+ jsonArray.getJSONObject(position).getString("image")).into(holder.image);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return jsonArray.length();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView cookbook;
        TextView method;
        ImageView image;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cookbook = itemView.findViewById(R.id.textView35);
            method = itemView.findViewById(R.id.textView36);
            image = itemView.findViewById(R.id.imageView8);
        }
    }
}
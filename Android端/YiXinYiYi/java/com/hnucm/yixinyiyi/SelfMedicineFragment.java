package com.hnucm.yixinyiyi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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

public class SelfMedicineFragment extends Fragment {

    public Activity mActivity;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    JSONArray jsonArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_self_medicine, container, false);
        recyclerView = view.findViewById(R.id.recyclerView5);
        RequestParams requestParams = new RequestParams("http://yzx.free.idcfengye.com/findAllIllness");
        x.http().post(requestParams, new Callback.CommonCallback<String>(){
            @Override
            public void onSuccess(String result) {
                Log.i("sb",result);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(result);
                    jsonArray = jsonObject.getJSONArray("data");
                    Log.i("sb",jsonArray.toString());
                    Log.i("sb",""+jsonArray.length());
                    myAdapter = new MyAdapter();
                    recyclerView.setAdapter(myAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
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
        return view;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_list3,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Log.i("sb","123456");
            try {
                holder.name.setText(jsonArray.getJSONObject(position).getString("illnessname"));
                Glide.with(mActivity).load("http://yzx.free.idcfengye.com/"+ jsonArray.getJSONObject(position).getString("image")).into(holder.image);
                holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mActivity,IllnessActivity.class);
                        try {
                            intent.putExtra("illnessname",jsonArray.getJSONObject(position).getString("illnessname"));
                            intent.putExtra("introduction",jsonArray.getJSONObject(position).getString("introduction"));
                            intent.putExtra("feature",jsonArray.getJSONObject(position).getString("feature"));
                            intent.putExtra("advice",jsonArray.getJSONObject(position).getString("advice"));
                            intent.putExtra("image",jsonArray.getJSONObject(position).getString("image"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        startActivity(intent);
                    }
                });
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
        TextView name;
        ImageView image;
        ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textView37);
            image = itemView.findViewById(R.id.imageView9);
            constraintLayout = itemView.findViewById(R.id.con);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }
}
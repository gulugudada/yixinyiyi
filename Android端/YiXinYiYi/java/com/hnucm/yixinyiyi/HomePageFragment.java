package com.hnucm.yixinyiyi;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomePageFragment extends Fragment {

    public Activity mActivity;
    RecyclerView yangsheng;
    MyAdapter myAdapter;
    JSONArray jsonArray;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_page, container, false);
        TextView date = view.findViewById(R.id.textView9);
        TextView address = view.findViewById(R.id.textView10);
        TextView weather = view.findViewById(R.id.textView5);
        TextView wendu = view.findViewById(R.id.textView11);
        TextView fengxiang = view.findViewById(R.id.textView12);
        TextView fengli = view.findViewById(R.id.textView14);
        TextView tip = view.findViewById(R.id.textView15);
        yangsheng = view.findViewById(R.id.recyclerView);
        String province = "";
        String city = "";
        String district = "";
        Bundle b = getArguments();
        if(null != b){
            province = b.getString("province");
            city = b.getString("city");
            district = b.getString("district");
        }
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Calendar c = Calendar.getInstance();
        Date curDate = new Date(System.currentTimeMillis());
        c.setTime(curDate);
        date.setText(formatter.format(curDate).split(" ")[0]+getWeek(c));
        String address1 = province+city+district;
        address.setText(address1);
        RequestParams requestParams = new RequestParams("https://api.vvhan.com/api/weather?city=" + city);
        x.http().post(requestParams, new Callback.CommonCallback<String>(){

            @Override
            public void onSuccess(String result) {
//                {
//                 "success":true,
//                 "city":"岳麓区",
//                 "info":
//                      {"date":"12日星期天",
//                       "type":"小雨",
//                       "high":"高温 10℃",
//                       "low":"低温 7℃",
//                       "fengxiang":"北风",
//                       "fengli":"3级",
//                       "tip":"感冒多发期，适当减少外出频率，适量补充水分，适当增减衣物。"
//                       }
//                 }
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject jsonObject1 = new JSONObject(jsonObject.getJSONObject("info").toString());
                    String str1 = "今日天气：" + jsonObject1.getString("type");
                    String str2 = "今日温度：" + jsonObject1.getString("high").split(" ")[1] + "/" + jsonObject1.getString("low").split(" ")[1];
                    String str3 = "今日风向：" + jsonObject1.getString("fengxiang");
                    String str4 = "今日风力：" + jsonObject1.getString("fengli");
                    String str5 = jsonObject1.getString("tip");
                    weather.setText(str1);
                    wendu.setText(str2);
                    fengxiang.setText(str3);
                    fengli.setText(str4);
                    tip.setText(str5);
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
        requestParams = new RequestParams("http://yzx.free.idcfengye.com/findAllReason");
        x.http().post(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    jsonArray = jsonObject.getJSONArray("reason");
                    myAdapter = new MyAdapter();
                    yangsheng.setAdapter(myAdapter);
                    yangsheng.setLayoutManager(new LinearLayoutManager(mActivity));
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
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_list,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            try {
                holder.season.setText(jsonArray.getJSONObject(position).getString("season"));
                holder.reason1.setText(jsonArray.getJSONObject(position).getString("reason"));
                Glide.with(mActivity).load("http://yzx.free.idcfengye.com/"+ jsonArray.getJSONObject(position).getString("image")).into(holder.image);
                holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mActivity,YangShengActivity.class);
                        try {
                            intent.putExtra("season",jsonArray.getJSONObject(position).getString("season"));
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
        TextView season;
        TextView reason1;
        ImageView image;
        ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            season = itemView.findViewById(R.id.textView19);
            reason1 = itemView.findViewById(R.id.textView16);
            image = itemView.findViewById(R.id.imageView7);
            constraintLayout = itemView.findViewById(R.id.constraintLayout10);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }

    public String getWeek(Calendar calendar){
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return "星期天";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            return "星期一";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            return "星期二";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            return "星期三";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            return "星期四";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            return "星期五";
        }
        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return "星期六";
        }
        return null;
    }
}
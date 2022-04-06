package com.hnucm.yixinyiyi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

public class MyFragment extends Fragment {

    public Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        TextView username = view.findViewById(R.id.textView6);
        TextView geqian = view.findViewById(R.id.textView13);
        CircleImageView touxiang = view.findViewById(R.id.imageView6);
        TextView tuichu = view.findViewById(R.id.textView18);
        TextView gerenxinxi = view.findViewById(R.id.textView20);
        final JSONObject[] jsonObject1 = {null};
        SharedPreferences sharedPreferences = mActivity.getSharedPreferences("user",Context.MODE_PRIVATE);
        RequestParams requestParams = new RequestParams("http://yzx.free.idcfengye.com/findUserByAccount");
        requestParams.addParameter("account",sharedPreferences.getString("account",""));
        x.http().post(requestParams, new Callback.CommonCallback<String>() {

            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    jsonObject1[0] = jsonObject.getJSONObject("data");
                    username.setText(jsonObject1[0].getString("username"));
                    geqian.setText(jsonObject1[0].getString("geqian"));
                    Glide.with(mActivity).load("http://yzx.free.idcfengye.com/"+ jsonObject1[0].getString("touxiang")).into(touxiang);
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
        gerenxinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity,GerenxinxiActivity.class);
                try {
                    intent.putExtra("username",jsonObject1[0].getString("username"));
                    intent.putExtra("birthday",jsonObject1[0].getString("birthday"));
                    intent.putExtra("sex",jsonObject1[0].getString("sex"));
                    intent.putExtra("school",jsonObject1[0].getString("school"));
                    intent.putExtra("grade",jsonObject1[0].getString("grade"));
                    intent.putExtra("college",jsonObject1[0].getString("college"));
                    intent.putExtra("administrativeclass",jsonObject1[0].getString("administrativeclass"));
                    intent.putExtra("province",jsonObject1[0].getString("location").split("省")[0]+"省");
                    intent.putExtra("city",jsonObject1[0].getString("location").split("省")[1].split("市")[0]+"市");
                    intent.putExtra("district",jsonObject1[0].getString("location").split("市")[1]);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                startActivity(intent);
            }
        });
        tuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = mActivity.getSharedPreferences("user",mActivity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLogin",false);
                editor.commit();
                mActivity.finish();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }
}
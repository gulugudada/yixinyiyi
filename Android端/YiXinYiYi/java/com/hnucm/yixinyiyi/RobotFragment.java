package com.hnucm.yixinyiyi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RobotFragment extends Fragment {
    public Activity mActivity;
    RecyclerView session;
    MyAdapter myAdapter;
    List<String> sessionList = new ArrayList<String>();

    public RobotFragment(){
        iniSession();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_robot, container, false);
        session = view.findViewById(R.id.recyclerView5);
        myAdapter = new MyAdapter();
        session.setAdapter(myAdapter);
        session.setLayoutManager(new LinearLayoutManager(mActivity));
        return view;
    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mActivity).inflate(R.layout.item_list4,parent,false);
            MyViewHolder myViewHolder = new MyViewHolder(view);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            try {
                JSONObject jsonObject = new JSONObject(sessionList.get(position));
                holder.name.setText(jsonObject.getString("name"));
                holder.circleImageView.setImageResource(R.drawable.robotimage);
                holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(mActivity,SessionActivity.class);
                        try {
                            intent.putExtra("name",jsonObject.getString("name"));
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
            return sessionList.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout constraintLayout;
        CircleImageView circleImageView;
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            constraintLayout = itemView.findViewById(R.id.constraintLayout8);
            circleImageView = itemView.findViewById(R.id.imageView12);
            name = itemView.findViewById(R.id.textView7);
        }
    }

    public void iniSession(){
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("name","自医机器人");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sessionList.add(jsonObject.toString());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (Activity)context;
    }
}
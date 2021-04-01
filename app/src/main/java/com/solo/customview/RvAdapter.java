package com.solo.customview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RvAdapter extends RecyclerView.Adapter {

    private static final String TAG = "RvAdapter";

    private final Context mContext;
    private final List<String> mList;

    public RvAdapter(Context context, List list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return new MyViewHolder(layoutInflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        ((MyViewHolder)holder).tv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = itemView.findViewById(R.id.tv4);
        }
    }

}

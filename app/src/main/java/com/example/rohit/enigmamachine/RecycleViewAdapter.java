package com.example.rohit.enigmamachine;


import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ROHIT on 12/28/2018.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

    private ArrayList<String> keys;
    private ArrayList<String> keyhighlight;
    public RecycleViewAdapter(ArrayList<String> keys,ArrayList<String> x) {
        this.keys=keys;
        this.keyhighlight =x;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_key,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(position<=25) {
            holder.textView.setText(keys.get(position));

            if(keyhighlight.size()>0) {
                if (Character.toUpperCase(keys.get(position).charAt(0))== (keyhighlight.get(keyhighlight.size() - 1)).charAt(0)) {
                    holder.textView.setTextColor(Color.BLACK);
                    holder.textView.setBackgroundColor(Color.RED);
                    Log.d("color key", "onBindViewHolder:working " + keyhighlight.get(keyhighlight.size() - 1));
                }
            }

        }


    }

    @Override
    public int getItemCount() {
        return (keys.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.key);
        }
    }

}

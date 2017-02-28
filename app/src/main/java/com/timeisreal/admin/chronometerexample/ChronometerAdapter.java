package com.timeisreal.admin.chronometerexample;

import android.content.Context;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChronometerAdapter extends BaseAdapter {
    Context context;
    int layoutResourceId;
    private ArrayList<Participants> data = new ArrayList<Participants>();

    public ChronometerAdapter(Context context, int layoutResourceId, ArrayList<Participants> data){
        super();
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public void UpdateChronometer(ArrayList<Participants> data){
        this.data = data;
        notifyDataSetChanged();
    }


    public int getCount(){
        return data.size();
    }

    //getitem returns oobject but we can override
    @Override
    public Participants getItem(int position){
        return data.get(position);
    }

    //getitemid is often useless but it shou;ld be there
    public long getItemId(int position){
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        View row = convertView;
        final RecordHolder holder;

        if(row == null){
            LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.nameOfParticipant = (TextView)row.findViewById(R.id.textView1);
            holder.myChronometer = (Chronometer)row.findViewById(R.id.myChronometer);
            holder.start = (Button)row.findViewById(R.id.startButton);
            holder.stop = (Button)row.findViewById(R.id.stopButton);
            holder.reset = (Button)row.findViewById(R.id.resetButton);
            row.setTag(holder);
        }else{
            holder = (RecordHolder)row.getTag();
        }

        final Participants participants = data.get(position);
        holder.nameOfParticipant.setText(participants.getNameOfParticipants());
        holder.myChronometer.setTag(participants.getNameOfParticipants());
        final Chronometer thisChronometer = (Chronometer)row.findViewWithTag(holder.nameOfParticipant.getText());
        holder.start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                if (holder.myChronometer.getTag().toString().equals(holder.nameOfParticipant.getText().toString())) {
                    thisChronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(context, "" + position, Toast.LENGTH_LONG).show();
                    thisChronometer.start();
                    holder.stop.setVisibility(View.VISIBLE);
                    holder.reset.setVisibility(View.GONE);
                }
            }
        });

        holder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                if (holder.myChronometer.getTag().toString().equals(holder.nameOfParticipant.getText().toString())) {
                    thisChronometer.stop();
                    Long timeElapsed=SystemClock.elapsedRealtime()-thisChronometer.getBase();
                    int hours =(int)(timeElapsed/3600000);
                    int minutes = (int)(timeElapsed-hours*3600000)/60000;
                    int seconds = (int)(timeElapsed-hours*3600000-minutes*60000)/1000;
                    Toast.makeText(context, "" + seconds, Toast.LENGTH_LONG).show();
                    holder.stop.setVisibility(View.GONE);
                    holder.reset.setVisibility(View.VISIBLE);
                }
            }
        });

        holder.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO Auto-generated method stub
                if (holder.myChronometer.getTag().toString().equals(holder.nameOfParticipant.getText().toString())) {
                    thisChronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(context, "" + position, Toast.LENGTH_LONG).show();
                    holder.reset.setVisibility(View.GONE);
                    holder.stop.setVisibility(View.VISIBLE);
                }
            }
        });
        return row;
    }

    static class RecordHolder{
        TextView nameOfParticipant;
        Chronometer myChronometer;
        Button start, stop, reset;
    }
}

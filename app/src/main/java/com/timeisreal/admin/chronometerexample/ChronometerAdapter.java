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

public class ChronometerAdapter extends ArrayAdapter<Participants> {
    Context context;
    int layoutResourceId;
    ArrayList<Participants> data = new ArrayList<Participants>();
    private long lastPause;
    private Participants mToggles;

    public ChronometerAdapter(Context context, int layoutResourceId, ArrayList<Participants> data){
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    /**public void setToggleList(Participants data){
        this.mToggles = data;
        notifyDataSetChanged();
    }**/
    //create a new view for each

    public View getView(final int position, View convertView, ViewGroup parent){
        View row = convertView;
        final RecordHolder holder;

        //int numberOfItems = data.size();
        if(row == null){
            LayoutInflater inflater = ((AppCompatActivity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new RecordHolder();
            holder.nameOfParticipant = (TextView)row.findViewById(R.id.textView1);
            holder.myChronometer = (Chronometer)row.findViewById(R.id.myChronometer);
            holder.start = (Button)row.findViewById(R.id.startButton);
            holder.start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO Auto-generated method stub
                    holder.myChronometer.setBase(SystemClock.elapsedRealtime());
                    holder.myChronometer.start();
                    holder.start.setVisibility(View.VISIBLE);
                    holder.resume.setVisibility(View.GONE);
                    Toast.makeText(getContext(), ""+position, Toast.LENGTH_SHORT).show();
                }
            });
            holder.stop = (Button)row.findViewById(R.id.stopButton);
            holder.myChronometer.setTag(position);
            holder.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO Auto-generated method stub
                    lastPause = SystemClock.elapsedRealtime();
                    holder.myChronometer.stop();
                    holder.resume.setVisibility(View.VISIBLE);
                }
            });
            holder.resume = (Button)row.findViewById(R.id.resumeButton);
            holder.resume.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO Auto-generated method stub
                    holder.myChronometer.setBase(holder.myChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                    holder.myChronometer.start();
                    holder.resume.setVisibility(View.GONE);
                    holder.stop.setVisibility(View.VISIBLE);
                }
            });
            row.setTag(holder);
        }else{
            holder = (RecordHolder)row.getTag();
        }

        Participants participants = data.get(position);
        holder.nameOfParticipant.setText(participants.getNameOfParticipants());
        /**holder.myChronometer = participants.getMyChronometer();
        holder.start = participants.getStartButton();
        holder.stop = participants.getStopButton();
        holder.resume = participants.getResumeButton();**/
        return row;
    }

    static class RecordHolder{
        TextView nameOfParticipant;
        Chronometer myChronometer;
        Button start, stop, resume;
    }
}

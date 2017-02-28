package com.timeisreal.admin.chronometerexample;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Participants> gridArray = new ArrayList<>();
    ChronometerAdapter chronometerAdapter;
    List<String> myParticipantsList = Arrays.asList("Michael","Rachel","Dorothy","Norman","Milly","Brian","Nyamchika",
            "Lois","Trevor","Charlene","Sydney","James", "Janet", "Danella", "Cinderella");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<myParticipantsList.size();i++){
            gridArray.add(new Participants(myParticipantsList.get(i)));
        }

        gridView = (GridView)findViewById(R.id.gridView);
        chronometerAdapter = new ChronometerAdapter(this, R.layout.activity_chronometer_adapter, gridArray);
        gridView.setAdapter(chronometerAdapter);

    }

    //Button allStart = (Button)findViewById(R.id.allstartbutton);
    public void AllStart(View view){
        Chronometer myChronometer;

        for(int i=0; i<=gridView.getLastVisiblePosition(); i++){
            //TODO Auto-generated method stub
            myChronometer = (Chronometer)gridView.findViewWithTag(myParticipantsList.get(i));
            myChronometer.setBase(SystemClock.elapsedRealtime());
            myChronometer.start();
        }
    }

    public void AllReset(View view){
        Chronometer myChronometer;
        for(int i=0; i<=gridView.getLastVisiblePosition();i++){
            myChronometer = (Chronometer)gridView.findViewWithTag(myParticipantsList.get(i));
            myChronometer.setBase(SystemClock.elapsedRealtime());
            myChronometer.stop();
        }
    }
}

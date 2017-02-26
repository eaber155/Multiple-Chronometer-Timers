package com.timeisreal.admin.chronometerexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Chronometer;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    ArrayList<Participants> gridArray = new ArrayList<>();
    ChronometerAdapter chronometerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridArray.add(new Participants("Michael"));
        gridArray.add(new Participants("Rachel"));
        gridArray.add(new Participants("Dorothy"));
        gridArray.add(new Participants("Norman"));
        gridArray.add(new Participants("Milly"));
        gridArray.add(new Participants("Brian"));
        gridArray.add(new Participants("Nyamchika"));
        gridArray.add(new Participants("Lois"));

        gridView = (GridView)findViewById(R.id.gridView);
        chronometerAdapter = new ChronometerAdapter(this, R.layout.activity_chronometer_adapter, gridArray);
        gridView.setAdapter(chronometerAdapter);
    }
}

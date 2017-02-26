package com.timeisreal.admin.chronometerexample;

import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by Admin on 26-Feb-17.
 */

public class Participants{
    Chronometer myChronometer;
    String nameOfParticipants;
    Button startButton, stopButton, resumeButton;

    public Participants(String nameOfParticipants){
        super();
        this.nameOfParticipants = nameOfParticipants;
    }

    public void setNameOfParticipants(String nameOfParticipants){
        this.nameOfParticipants = nameOfParticipants;
    }

    public String getNameOfParticipants(){
        setNameOfParticipants(nameOfParticipants);
        return nameOfParticipants;
    }

    /**public void setMyChronometer(Chronometer myChronometer){
        this.myChronometer = myChronometer;
    }

    public Chronometer getMyChronometer(){
        setMyChronometer(myChronometer);
        return myChronometer;
    }

    public void setStartButton(Button startButton){
        this.startButton = startButton;
    }

    public Button getStartButton(){
        setStartButton(startButton);
        return startButton;
    }

    public void setStopButton(Button stopButton){
        this.stopButton = stopButton;
    }

    public Button getStopButton(){
        setStopButton(stopButton);
        return stopButton;
    }

    public void setResumeButton(Button resumeButton){
        this.resumeButton = resumeButton;
    }

    public Button getResumeButton(){
        setResumeButton(resumeButton);
        return resumeButton;
    }**/
}

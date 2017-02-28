package com.timeisreal.admin.chronometerexample;

import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by Admin on 26-Feb-17.
 */

public class Participants{
    String nameOfParticipants;
    //String startButtonTag, stopButtonTag, resumeButtonTag;

    /** Participants(String nameOfParticipants, Chronometer myChronometer, Button startButton, Button stopButton, Button resumeButton){
        super();
        this.nameOfParticipants = nameOfParticipants;
        this.myChronometer = myChronometer;
        this.startButton = startButton;
        this.stopButton = stopButton;
        this.resumeButton = resumeButton;
    }**/
    public Participants(String nameOfParticipants){
        super();
        this.nameOfParticipants = nameOfParticipants;
        /**this.startButtonTag = startButtonTag;
        this.stopButtonTag = stopButtonTag;
        this.resumeButtonTag = resumeButtonTag;**/
    }

    public void setNameOfParticipants(String nameOfParticipants){
        this.nameOfParticipants = nameOfParticipants;
    }

    public String getNameOfParticipants(){
        setNameOfParticipants(nameOfParticipants);
        return nameOfParticipants;
    }

    /**public void setMyChronometerTag(String myChronometerTag){
        this.myChronometerTag = myChronometerTag;
    }

    public String getMyChronometerTag(){

        setMyChronometerTag(myChronometerTag);
        return myChronometerTag;
    }

    public void setStartButtonTag(String startButtonTag){
        this.startButtonTag = startButtonTag;
    }

    public String getStartButtonTag(){
        setStartButtonTag(startButtonTag);
        return startButtonTag;
    }

    public void setStopButton(String stopButtonTag){
        this.stopButtonTag = stopButtonTag;
    }

    public String getStopButtonTag(){
        setStopButton(stopButtonTag);
        return stopButtonTag;
    }

    public void setResumeButtonTag(String resumeButtonTag){
        this.resumeButtonTag = resumeButtonTag;
    }

    public String getResumeButtonTag(){
        setResumeButtonTag(resumeButtonTag);
        return resumeButtonTag;
    }**/
}

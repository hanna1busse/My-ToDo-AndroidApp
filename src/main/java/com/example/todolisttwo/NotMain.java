package com.example.todolisttwo;

import java.util.ArrayList;

public class NotMain {
//declare Class variables
public static int startTime = 900;
public static String[] inputEvents = new String[5];
public static int[][] inputTimes= new int[5][3];
public static ArrayList<String> scheduledEvents = new ArrayList<String>();
public static ArrayList<Integer> scheduledStartTimes = new ArrayList<Integer>();
public static ArrayList<Integer> scheduledEndTimes = new ArrayList<Integer>();

  public static void main(String[] args) {
  	inputEvents = Data.fillEvents();
    inputTimes = Data.fillTimes();
    Sort.byOrder();
	//for(int i=0;i<5;i++){
    //System.out.println(inputEvents[i]);
    //}
   
    putTimedTasksOnSchedule();
    putOtherTasksOnSchedule();
  }
    
  
  
  
            
	static void putTimedTasksOnSchedule(){
    	//for each event/time
        //if order=0/start time !=0
            for(int i=0;i<5;i++){
        	if(inputTimes[i][1]==0){
            //put it on the schedule at the time
            scheduledEvents.add(inputEvents[i]);
            //round the time
            int time = roundTime(inputTimes[i][2]);
            scheduledStartTimes.add(time);
            //calculate end time
            time=time+inputTimes[i][0];
            scheduledEndTimes.add(time);
            }
        }
        //System.out.println(scheduledEvents + " , " + scheduledStartTimes+ " , "+ scheduledEndTimes);
    }

	static int roundTime(int startTime){
    //to nearest fifteen minutes
    	String digits="";
        //three digits or four in the time?
        int nDigits;
        if(startTime-1000<0){
        nDigits=1;}
        else{nDigits=2;}
        //get last two digits of startTime
        String startTimeString1 = Integer.toString(startTime);
        String startTimeString2 = startTimeString1.substring(nDigits);
        startTimeString1 = startTimeString1.substring(0,nDigits);
        startTime=Integer.parseInt(startTimeString2);
        //round
    	if (startTime>=0 && startTime <= 7){
			digits="00";}
        if (startTime>7 && startTime <= 22){
			digits="15";}
        if (startTime>22 && startTime <= 37){
			digits="30";}
        if (startTime>37 && startTime <= 52){
			digits="45";}
        if (startTime>52){
            // maybe need to add digits?
			digits="00";
            //add an hour when you round up
            int temp = Integer.parseInt(startTimeString1);
            temp++;
            startTimeString1=Integer.toString(temp);}    
        //append digits to startTime1
        startTimeString1 = startTimeString1.concat(digits);
        startTime=Integer.parseInt(startTimeString1);
        //System.out.println(startTime);
        return startTime;}
            
       //Put all the other tasks on the schedule
      static void putOtherTasksOnSchedule(){
       		//start at 9am for now (but it's a class variable, so I can change it later on.)
            //figure out length of time until first timed task
            //how do i optimize what goes there and consider the priorities of tasks? Do I just split tasks up to before and after? <-- YES
            //firstEvent
            //firstChunkofTime
            //put it on the schedule
            String event="";
            int eventStartTime = startTime;
            int eventEndTime=0;
            for(int i=0;i<5;i++){
                //if event doesnt have a specific start time
            if(inputTimes[i][1]!=0){
                //add it next to the schedule
                event=inputEvents[i];
                scheduledEvents.add(event);
                scheduledStartTimes.add(eventStartTime);
                //calculate end time
                eventEndTime=eventStartTime+inputTimes[i][0];
                eventEndTime= roundTime(eventEndTime);
                scheduledEndTimes.add(eventEndTime);
                Sort.byStartTime();
            
                
         //  System.out.println(scheduledEvents + " , " + scheduledStartTimes+ " , "+ scheduledEndTimes);
     
                //System.out.println(scheduledStartTimes);
                //get next start time
                int nextIndex=scheduledEvents.indexOf(event);
                nextIndex++;
                int nextStartTime = scheduledStartTimes.get(nextIndex);
                //compare end time to next start time
                if(eventEndTime>nextStartTime){
                    //if they overlap, split up this event into two chunks on the schedule
                    int extraTime=eventEndTime - nextStartTime;
                    eventEndTime= nextStartTime;
                    scheduledEndTimes.set(nextIndex-1, eventEndTime);
                    //add second chunk to schedule
                    // need to remove first/ incorrect end time!
                    scheduledEvents.add(event);
                    eventStartTime= scheduledEndTimes.get(nextIndex);
                    scheduledStartTimes.add(eventStartTime);
                    eventEndTime= eventStartTime+ extraTime;
                    eventEndTime= roundTime(eventEndTime);
                    scheduledEndTimes.add(eventEndTime);
                    
                    
                }
                 eventStartTime = eventEndTime;
                 
            }
            
          
            }
         // System.out.println(scheduledEvents);
         // System.out.println(scheduledStartTimes);
          System.out.println(scheduledEvents + " , " + scheduledStartTimes+ " , "+ scheduledEndTimes);
     
      }}
  
  

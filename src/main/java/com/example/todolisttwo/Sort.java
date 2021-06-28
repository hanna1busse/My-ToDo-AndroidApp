package com.example.todolisttwo;

import java.util.ArrayList;

class Sort{
    static void byOrder(){
      //sorts NotMain.inputTimes[] and NotMain.inputEvents[] by order.
    System.out.println("Sorted!");
  	int[] temp= new int[NotMain.inputTimes[0].length];
    String temp2="";
	for (int i = 0; i < NotMain.inputTimes.length; i++) {
    for (int j = 0; j < NotMain.inputTimes.length; j++) {
    //sort by order, in row 1
        if (NotMain.inputTimes[i][1] < NotMain.inputTimes[j][1]) {
            temp[0] = NotMain.inputTimes[i][0];
            temp[1]=NotMain.inputTimes[i][1];
            temp[2]=NotMain.inputTimes[i][2];
            temp2=NotMain.inputEvents[i];
            
            NotMain.inputTimes[i][0]=NotMain.inputTimes[j][0];
			NotMain.inputTimes[i][1]=NotMain.inputTimes[j][1];
			NotMain.inputTimes[i][2]=NotMain.inputTimes[j][2];
            NotMain.inputEvents[i]=NotMain.inputEvents[j];
            
            NotMain.inputTimes[j][0]=temp[0];
			NotMain.inputTimes[j][1]=temp[1];
			NotMain.inputTimes[j][2]=temp[2];
            NotMain.inputEvents[j]=temp2;
            }}}
            }
    
    
    //.get(3) .set(0,newThing) .remove(5)        
    static void byStartTime(){
        //System.out.println("Sorted!");
  	    int temp= 0;
        String temp2="";
        int temp3 =0;
	    for (int i = 0; i < NotMain.scheduledStartTimes.size(); i++) {
	    for (int j = 0; j < NotMain.scheduledStartTimes.size(); j++) {
        if (NotMain.scheduledStartTimes.get(i) < NotMain.scheduledStartTimes.get(j)) {
            
            temp = NotMain.scheduledStartTimes.get(i);
            temp2=NotMain.scheduledEvents.get(i);
            temp3=NotMain.scheduledEndTimes.get(i);
            
            
            NotMain.scheduledStartTimes.set(i,NotMain.scheduledStartTimes.get(j));
            NotMain.scheduledEvents.set(i,NotMain.scheduledEvents.get(j));
            NotMain.scheduledEndTimes.set(i,NotMain.scheduledEndTimes.get(j));
            
            NotMain.scheduledStartTimes.set(j,temp);
            NotMain.scheduledEvents.set(j,temp2);
            NotMain.scheduledEndTimes.set(j,temp3);
            }}}
    }
}
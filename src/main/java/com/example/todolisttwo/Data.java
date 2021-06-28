package com.example.todolisttwo;

import com.example.todolisttwo.NotMain;

class Data{
    static String[] fillEvents(){
 
  	NotMain.inputEvents[0]="Shower";
    NotMain.inputEvents[1]="Lunch";
	NotMain.inputEvents[2]="Class";
	NotMain.inputEvents[3]="Yoga";
	NotMain.inputEvents[4]="Studio Time";
  return NotMain.inputEvents;
  }
  static int[][] fillTimes(){
  //length in minutes, order, start time in 2400 (0=null)
  //note: autofill with 0 when no user input is provided???
  
  	NotMain.inputTimes[0][0]=30;
	NotMain.inputTimes[0][1]=3;
	NotMain.inputTimes[0][2]=0;
	NotMain.inputTimes[1][0]=45;
	NotMain.inputTimes[1][1]=0;
	NotMain.inputTimes[1][2]=1200;
	NotMain.inputTimes[2][0]=120;
	NotMain.inputTimes[2][1]=1;
	NotMain.inputTimes[2][2]=0;
	NotMain.inputTimes[3][0]=30;
	NotMain.inputTimes[3][1]=2;
	NotMain.inputTimes[3][2]=0;
	NotMain.inputTimes[4][0]=240;
	NotMain.inputTimes[4][1]=4;
	NotMain.inputTimes[4][2]=0;
  return NotMain.inputTimes;
  }
}
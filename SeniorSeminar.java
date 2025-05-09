
/**
 * SeniorSeminar.java
 * 
 * Author: Nico Mayoral
 * Date: 4/21/25
 * Preconditons: SeniorSeminar  Class and Object
 * Purpose: Students and sessions are loaded from a CSV file into studentList and presenterList.
 * - Each session is tallied for popularity based on student choices.
 * - Sessions are scheduled into timeslots and rooms (primary and secondary offerings).
 * - Students are assigned to their highest-priority available session choices, avoiding time conflicts.
 * - Class rosters and student schedules can be printed to show final scheduling results.
 * 
 * Purpose: To manage and the scheduling of senior seminar sessions based on student preferences,
 * optomizing satisfaction while avoiding session and timeslot conflicts.
 * 
 */

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class SeniorSeminar {
 
   private ArrayList<Student> studentList = new ArrayList<Student>(); //choices and the student name
   private ArrayList<Sessions> presenterList = new ArrayList<Sessions>(); 
   private int number_of_rooms = 5;
   private int number_of_timeslots = 5;
   private int max_per_classroom = 16; 
   
 
   public SeniorSeminar() {
    
    try {
	
      File myObj = new File("SrSeminar_DataNico.csv");
      Scanner myReader = new Scanner(myObj);
       myReader.nextLine();
     
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] newData1 = data.split(",");
        Student List = new Student(newData1[0],Integer.parseInt(newData1[1]),Integer.parseInt(newData1[2]),Integer.parseInt(newData1[3]),Integer.parseInt(newData1[4]),Integer.parseInt(newData1[5]));
        studentList.add(List);
        try {
          Sessions List1 = new Sessions(newData1[6], Integer.parseInt(newData1[7]), newData1[8]);
          presenterList.add(List1);
        } catch (Exception e) {
		}
      }

      
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
      
    }
 
  }
  
	
	 //tally for amount of selected chocies for each session
  public void tallySessions(){
     for(int i = 0; i < presenterList.size(); i++){
       int counter = 0;
       for(int j = 0; j < studentList.size(); j++){
		  if(presenterList.get(i).getsessionID() == studentList.get(j).getchoice(1) //sets the array to to session Id and then sets studentList to look for column 1 
		     || presenterList.get(i).getsessionID() == studentList.get(j).getchoice(2) 
		     || presenterList.get(i).getsessionID() == studentList.get(j).getchoice(3)
		     || presenterList.get(i).getsessionID() == studentList.get(j).getchoice(4)
		     || presenterList.get(i).getsessionID() == studentList.get(j).getchoice(5))
		  
		  {
			counter++; //adds if someone has the choice in their column choices
		  }  
	    }
  	 presenterList.get(i).setCount(counter);
  	 // begin to sort presenterList descending based on popularity
	
     int numberofpresenters = presenterList.size();
	  //start from the second element and move through it
	 for (int j = 1; j < numberofpresenters; j++)
      {
	      int temp = presenterList.get(j).getCount();	
		  Sessions Sessions_temp = presenterList.get(j);
 
          int possibleIndex = j;
          //While we are not at the begninning and the current value is greater than the previous value
          while (possibleIndex > 0 && temp > presenterList.get(possibleIndex - 1).getCount())
          {
                  //Shift the smaller value one position to the right   
              Sessions Sessions_temp2 = presenterList.get(possibleIndex - 1);
              presenterList.set(possibleIndex,Sessions_temp2);
              possibleIndex--;
           }
           presenterList.set(possibleIndex,Sessions_temp);
      }
  // end of sorting  	 
	}
  }
  
	
  public void ScheduleSessions() {
	  // Assign a classroom and timeslot for each session. The sessions have been sorted 
	  //The most popular classes will be assigned first and so that they do not repeat with the same time
	
	  int timeslot = 0; // Tracks current timeslot index
	  int room = 1; // Tracks current room number
	  
	  //schedule the classes. naviagtes the time slot and the rooms to set them 
	  for(int i = 0; i < presenterList.size(); i++){
		timeslot++; // Move to next timeslot
		if(timeslot > number_of_timeslots ){ //greater than 5 puts it back to 1
			room++;
			timeslot = 1;
		}
		presenterList.get(i).setroomnumber(room); // set room number
		presenterList.get(i).settimeslot(timeslot); // set timeslot
	  }
	  // schedule classes in the remaining time slots
	  
	  boolean capacity_available = true;
	  for(int i = 0; i < presenterList.size() && capacity_available; i++){
		timeslot++;  // Move to next timeslot
		if(timeslot > number_of_timeslots){
			room++;
			timeslot = 1;
		} if (room <= number_of_rooms) {  //less than 5
			  // set alternate room/timeslot
	   	   presenterList.get(i).set_alt_roomnumber(room);
		   presenterList.get(i).set_alt_timeslot(timeslot);
		  } 
		  else capacity_available = false; //makes it false when you assign the 5 rooms for the 5 timeslots 
	  }
		
	  //since each class is assigned to a room and timeslot now schedule the students
	  
	  for(int i = 0; i < presenterList.size(); i++){   // For each class, find up to 16 students who are not scheduled in the timeslot 
		 timeslot = presenterList.get(i).gettimeslot(); // Get sessions main timeslot
		 int sessionID = presenterList.get(i).getsessionID(); // Get session ID
		 
		  //finding one student that pciked the session and still has room in their schedule.
		  // go through their top 5 choices, check if this session matches and their timeslot is free.
		  //if the sessionID lines up with their first chocie and it is not scheudled their 1 set it 
		  for (int j = 1;j <= max_per_classroom;j++) {
		      boolean found_student = false;
		      for (int k = 0; k < studentList.size() && !found_student; k++) {
				   //check choice #1
				  if ((studentList.get(k).getchoice(1) == sessionID)
				     && !studentList.get(k).is_scheduled(1)
				     && !studentList.get(k).istimeslotbooked(timeslot)) 
				   {
				      studentList.get(k).mark_as_scheduled_primary(true,1);  //
				      studentList.get(k).settimeslot(true,timeslot);   //Marks students timeslot
				      found_student = true; //Seat is taken, break inner loop
			       } //check choice #2
			       else if ((studentList.get(k).getchoice(2) == sessionID)
				     && !studentList.get(k).is_scheduled(2)
				     && !studentList.get(k).istimeslotbooked(timeslot)) {
					  studentList.get(k).mark_as_scheduled_primary(true,2);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
				   } //check choice #3
				   else if ((studentList.get(k).getchoice(3) == sessionID)
				     && !studentList.get(k).is_scheduled(3)
				     && !studentList.get(k).istimeslotbooked(timeslot)) {
					  studentList.get(k).mark_as_scheduled_primary(true,3);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
				   } //check choice #4
				    else if ((studentList.get(k).getchoice(4) == sessionID)
				     && !studentList.get(k).is_scheduled(4)
				     && !studentList.get(k).istimeslotbooked(timeslot)) {
					  studentList.get(k).mark_as_scheduled_primary(true,4);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
				   } //check choice #5
				   else if ((studentList.get(k).getchoice(5) == sessionID)
				     && !studentList.get(k).is_scheduled(5)
				     && !studentList.get(k).istimeslotbooked(timeslot)) {
					  studentList.get(k).mark_as_scheduled_primary(true,5);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
				   }        
			   } 
		  }
			
      }
	  
	  //proceed to schedule the students in the secondary offering of the classes for those that has not been scheduled yet
	  
	    for(int i = 0; i < presenterList.size(); i++){   // For each class, find up to 16 students who are not scheduled in the timeslot 
		 timeslot = presenterList.get(i).get_alt_timeslot(); // Alternate timeslot for this session
		 int sessionID = presenterList.get(i).getsessionID();
		 
		  for (int j = 1;j <= max_per_classroom;j++) { //make classrooms is 16
		      boolean found_student = false;
		      for (int k = 0; k < studentList.size() && !found_student;k++) {  //not found student makes it 
				   //check choice #1 for secondary
				  if ((studentList.get(k).getchoice(1) == sessionID)
				     && !studentList.get(k).is_scheduled(1)
				     && !studentList.get(k).istimeslotbooked(timeslot)) 
				   {
				      studentList.get(k).mark_as_scheduled_secondary(true,1);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
			       }  //check choice #2 for secondary
			       else if ((studentList.get(k).getchoice(2) == sessionID)
				     && !studentList.get(k).is_scheduled(2)
				     && !studentList.get(k).istimeslotbooked(timeslot)) {
					  studentList.get(k).mark_as_scheduled_secondary(true,2);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
				   }  //check choice #3 for secondary
				   else if ((studentList.get(k).getchoice(3) == sessionID)
				     && !studentList.get(k).is_scheduled(3)
				     && !studentList.get(k).istimeslotbooked(timeslot)) {
					  studentList.get(k).mark_as_scheduled_secondary(true,3);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
				   } //check choice #4 for secondary
				     else if ((studentList.get(k).getchoice(4) == sessionID)
				     && !studentList.get(k).is_scheduled(4)
				     && !studentList.get(k).istimeslotbooked(timeslot)) {
					  studentList.get(k).mark_as_scheduled_secondary(true,4);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
				   }  //check choice #1 for secondary
				   else if ((studentList.get(k).getchoice(5) == sessionID)
				     && !studentList.get(k).is_scheduled(5)
				     && !studentList.get(k).istimeslotbooked(timeslot)) {
					  studentList.get(k).mark_as_scheduled_secondary(true,5);
				      studentList.get(k).settimeslot(true,timeslot);
				      found_student = true;
				   }        
			   } 
		  }	
      }
   }
   
   //print the rosters 
   public void PrintRosterPerSessions () {
	   System.out.println("Roster of all Sessions");
	   System.out.println();
	   
	   for(int i = 1; i <= number_of_rooms; i++){
			for(int j = 1; j <= number_of_timeslots; j++){
				for(int k = 0; k < presenterList.size(); k++){
					// if the current loop’s room i and timeslot j match this sessions assigned room and timeslot then print the roster
					if((i == presenterList.get(k).getroomnumber() && j == presenterList.get(k).gettimeslot()))
					{			
						System.out.println("Room #: " + i + " Timeslot #: " + j + " "); //Room number and timeslot
						System.out.println("        " + presenterList.get(k).printSessionDetails());//print the session
						int currentSession = presenterList.get(k).getsessionID();
						for(int l = 0; l < studentList.size(); l++){
							if(studentList.get(l).is_scheduled_primary(currentSession)){
							    System.out.println("            " + studentList.get(l).getName()); //print student name
							}
						}
					}
				}
			}
		}
		//printing the rosters for the secondary run
	   for(int i = 1; i <= number_of_rooms; i++){
			for(int j = 1; j <= number_of_timeslots; j++){
				for(int k = 0; k < presenterList.size(); k++){
					if((i == presenterList.get(k).get_alt_roomnumber() && j == presenterList.get(k).get_alt_timeslot()))
					{
						System.out.println("Room #: " + i + " Timeslot #: " + j + " ");
						System.out.println("        " + presenterList.get(k).printSessionDetails());//print the session
						int currentSession = presenterList.get(k).getsessionID();
						for(int l = 0; l < studentList.size(); l++){
							if(studentList.get(l).is_scheduled_secondary(currentSession)){
								System.out.println("            " + studentList.get(l).getName()); //print student name
							}
						}
					}
				}
			}
		}
   }
   
}

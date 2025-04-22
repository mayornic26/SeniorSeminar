/**
 * Sessions.java
 * 
 * Author: Nico Mayoral
 * Date: 4/21/25
 * 
 * Preconditons: Sessions Class and Objects
 * Postconditions: Generates a Sessions object containing session Name, Session ID, Presenter, number of people who choose it, timeslots, room number, alternate timeslot
 *                 and alternate room number
 * Purpose:  This object allows to store the information for each session that will be taught. The program uses the Sessions class 
 * to store multiple attendees in an array structure for each retrieval.
 * 
 */

/* Sessions Class:  Creates the structure for Sessions for the use of storing each session and its attributes including session Name, Session ID, Presenter, number of people who choose it, timeslor, room number, alternate timeslot
 *                 and alternate room number .   It can be used to be stored in an ArrayList by the program using the class
 */

public class Sessions {

	   //Attributes to store for each session
	   private String sessionName;
	   private int sessionID;
	   private String Presenter;
	   private int count; 
	   private int timeslot;
	   private int roomnumber;
	   private int alt_timeslot;
	   private int alt_roomnumber;  
        
        //constructor for the class
        public Sessions (String session, int ID, String personPresenter)
   
        {
			sessionName = session;
            sessionID = ID;
            Presenter = personPresenter;
            count = 0;
            timeslot = 0;
            roomnumber = 0;
            alt_timeslot = 0;
            alt_roomnumber = 0;         
        }
        
        //getter method to obtain the session name
        public String getsessionName(){
			return sessionName;
		}
		
		//getter method to obtain the time slot
		public int gettimeslot(){
			return timeslot;
		}
	
	
		//getter method to obtain the room number	
		public int getroomnumber(){
			return roomnumber;
		}
		
		//getter method to obtain the alternate time slot
		public int get_alt_timeslot(){
			return alt_timeslot;
		}

		//getter method to obtain the alternate room number			
		public int get_alt_roomnumber(){
			return alt_roomnumber;
		}
		
		//getter method to obtain the session ID	
        public int getsessionID() {
            return sessionID;
        }
        
		//getter method to obtain the presenter	
        public String getPresenter() {
            return Presenter;
        }
        
        
        //return session name and the ID and the presenter for the sessions
        public String printSession() {
			return "Session ID: " + sessionID + " Count: " + count;
        }
        
        //return session details
        public String printSessionDetails(){
			return sessionID + ": Session Name: " + sessionName + "." + " Presenter " + Presenter;
		}	
		
		//return session name
		public String printSessionNames() {
			return "Sessions: " + sessionName;
		}
        
        //setter method for the counter of how many people chose the session
        public void setCount(int number) {
			count = number;
		}
		
		// getter method to ontain the count number               
        public int getCount() {
			return count;
		}
		
		// setter method for timeslot   
		public void settimeslot(int slot) {
			timeslot = slot;
		}

		// setter method for room number 
		public void setroomnumber(int room){
			roomnumber = room;
		}

		// setter method for alternate timeslot   
		public void set_alt_timeslot(int slot){
			alt_timeslot = slot;
		}
		
		// setter method for alternate room number  
		public void set_alt_roomnumber(int room){
			alt_roomnumber = room;
		}


    }
	

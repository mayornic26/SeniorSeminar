

public class Sessions {

	//instance variables
	   private String sessionName;
	   private int sessionID;
	   private String Presenter;
	   private int count; 
	   private int timeslot;
	   private int roomnumber;
	   private int alt_timeslot;
	   private int alt_roomnumber;  
        
        //constructor	
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
        
    //getters and setters
        
        //session name
        public String getsessionName(){
			return sessionName;
		}
		
		public int gettimeslot(){
			return timeslot;
		}
		
		public int getroomnumber(){
			return roomnumber;
		}
		
		public int get_alt_timeslot(){
			return alt_timeslot;
		}
		
		public int get_alt_roomnumber(){
			return alt_roomnumber;
		}
		
        //session ID
        public int getsessionID() {
            return sessionID;
        }
        
        //presenter
        public String getPresenter() {
            return Presenter;
        }
        
        
        //return session anme and the ID and the presenter for the sessions
        public String printSession() {
			return "Session ID: " + sessionID + " Count: " + count;
        }
        
        public String printSessionDetails(){
			return sessionID + ": Session Name: " + sessionName + " Presenter " + Presenter;
		}
        
        //counter for tally
        public void setCount(int number){
			count = number;
		}
		
		        
        public int getCount(){
			return count;
		}
		
		public void settimeslot(int slot){
			timeslot = slot;
		}
		
		public void setroomnumber(int room){
			roomnumber = room;
		}

		public void set_alt_timeslot(int slot){
			alt_timeslot = slot;
		}
		
		public void set_alt_roomnumber(int room){
			alt_roomnumber = room;
		}


    }
	

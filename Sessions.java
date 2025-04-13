
public class Sessions {

	//instance variables
	   private String sessionName;
	   private int sessionID;
	   private String Presenter;
	   private int count; 
        
        //constructor	
        public Sessions (String session, int ID, String personPresenter)
   
        {
			sessionName = session;
            sessionID = ID;
            Presenter = personPresenter;
            count = 0;
        }
        
    //getters and setters
        
        //session name
        public String getsessionName(){
			return sessionName;
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
            return "Session Name: " + sessionName + ", Session ID: " + sessionID + ", Presenter: " + Presenter + "- Total Selected: " + count + "-";
        }
        
        //counter for tally
        public void setCount(int number){
			count = number;
		}
      
      

    }


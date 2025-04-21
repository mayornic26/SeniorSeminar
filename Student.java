
public class Student {

	//instance variables
        private String name;  // name of the student
    // five choices of classes
        private int c1;
        private int c2;
        private int c3;
        private int c4;
        private int c5;
        
      // Variables to indicate if the student has been scheduled for each of their chocies
        
        private boolean S1;
        private boolean S2;
        private boolean S3;
        private boolean S4;
        private boolean S5;
       
       // varibles to tell per class which timeslot is scheduled
       
        private boolean timeslot1;
        private boolean timeslot2;
        private boolean timeslot3;
        private boolean timeslot4;
        private boolean timeslot5;
        
        // varibles to indicate if the student will attend the class on the 2nd run 
        
        private boolean secondary1;
        private boolean secondary2;
        private boolean secondary3;
        private boolean secondary4;
        private boolean secondary5;
        
        
    //constructor	
        public Student (String studentName, int choiceOne, int choiceTwo, int choiceThree, int choiceFour, int choiceFive)
        {
            name = studentName;
            c1 = choiceOne;
            c2 = choiceTwo;
            c3 = choiceThree;
            c4 = choiceFour;
            c5 = choiceFive;
            S1 = false;
            S2 = false;
            S3 = false;
            S4 = false;
            S5 = false;
            timeslot1 = false;
            timeslot2 = false;
            timeslot3 = false;
            timeslot4 = false;
            timeslot5 = false;       
            secondary1 = false;
            secondary2 = false;
            secondary3 = false;
            secondary4 = false;
            secondary5 = false;     
        }
        
    //getters and setters
        
        //get name
        public String getName() {
            return name;
        }
        
        //get the choices 
        
        public int getchoice(int number) {
		   if(number ==1  ) {
			   return c1;
		   } else if (number == 2) {
			   return c2;   
	       } else if (number == 3) {
			   return c3;   
		   } else if (number == 4) {
	           return c4;
	       } else if (number == 5) {
			  return c5; 
		   }  else return 0;
			   	
		} 
		
		 public boolean issessionscheduled(int number) {
		   if(number == 1 ) {
			   return S1;
		   } else if (number == 2) {
			   return S2;   
	       } else if (number == 3) {
			   return S3;   
		   } else if (number == 4) {
	           return S4;
	       } else if (number == 5) {
			  return S5; 
		   }  else return false;
			   	
		} 

		public boolean is_scheduled(int sessionNumber){
			return ((sessionNumber == c1) && S1) 
			|| ((sessionNumber == c2) && S2)
			|| ((sessionNumber == c3) && S3)
			|| ((sessionNumber == c4) && S4)
			|| ((sessionNumber == c5) && S5);
			
		}
		
		public boolean is_scheduled_primary(int sessionNumber){
			return ((sessionNumber == c1) && S1 && !secondary1) 
			|| ((sessionNumber == c2) && S2 && !secondary2)
			|| ((sessionNumber == c3) && S3 && !secondary3)
			|| ((sessionNumber == c4) && S4 && !secondary4)
			|| ((sessionNumber == c5) && S5 && !secondary5);
			
		}
		
		public boolean is_scheduled_secondary(int sessionNumber){
			return ((sessionNumber == c1) && S1 && secondary1) 
			|| ((sessionNumber == c2) && S2 && secondary2)
			|| ((sessionNumber == c3) && S3 && secondary3)
			|| ((sessionNumber == c4) && S4 && secondary4)
			|| ((sessionNumber == c5) && S5 && secondary5);
			
		}
		
		
		
		//setters
		
		public void mark_as_scheduled_primary(boolean value,int slot){
			if (slot == 1) {
			   S1 = value;
			} else if (slot == 2) {
				S2 = value;
			} else if (slot == 3) {
				S3 = value;
			} else if (slot == 4) {
				S4 = value;
			} else if (slot == 5) {
				S5 = value;
			}
		}
		
		public void mark_as_scheduled_secondary(boolean value,int slot){
			if (slot == 1) {
			   S1 = value;
			   secondary1 = true;
			} else if (slot == 2) {
				S2 = value;
				secondary2 = true;
			} else if (slot == 3) {
				S3 = value;
				secondary3 = true;
			} else if (slot == 4) {
				S4 = value;
				secondary4 = true;
			} else if (slot == 5) {
				S5 = value;
				secondary5 = true;
			}
		}
		

		public void settimeslot(boolean value,int slot){
			if (slot == 1) {
			   timeslot1 = value;
			} else if (slot == 2) {
				timeslot2 = value;
			} else if (slot == 3) {
				timeslot3 = value;
			} else if (slot == 4) {
				timeslot4 = value;
			} else if (slot == 5) {
				timeslot5 = value;
			}
		}
			
		public boolean istimeslotbooked(int slot){
			if (slot == 1) {
			   return timeslot1;
			} else if (slot == 2) {
				return timeslot2;
			} else if (slot == 3) {
				return timeslot3;
			} else if (slot == 4) {
				return timeslot4;
			} else if (slot == 5) {
				return timeslot5;
			} else return false;
		}
		
	
		//return student and their list choices print
        public String getListChoice() {
            return "The choices of the student: " + name + " are - Choice 1: " + c1 + ", Choice 2: " + c2 + ", Choice 3: " + c3 + ", Choice4: " + c4 + ", Choice 5: " + c5;
        }
    }


public class Student {

	//instance variables
        private String name;
        private int c1;
        private int c2;
        private int c3;
        private int c4;
        private int c5;
        
        
    //constructor	
        public Student (String studentName, int choiceOne, int choiceTwo, int choiceThree, int choiceFour, int choiceFive)
   
        {
            name = studentName;
            c1 = choiceOne;
            c2 = choiceTwo;
            c3 = choiceThree;
            c4 = choiceFour;
            c5 = choiceFive;
        }
        
    //getters and setters
        
        //get name
        public String getName() {
            return name;
        }
        
        //get the choices 
         public int getc1(){
			return c1;
		}
		
		public int getc2(){
			return c2;
		}
		
		public int getc3(){
			return c3;
		}
		
		public int getc4(){
			return c4;
		}
		
		public int getc5(){
			return c5;
		}
	
		//return student and their list choices print
        public String getListChoice() {
            return "The choices of the student: " + name + " are - Choice 1: " + c1 + ", Choice 2: " + c2 + ", Choice 3: " + c3 + ", Choice4: " + c4 + ", Choice 5: " + c5;
        }
    }

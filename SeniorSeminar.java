
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class SeniorSeminar {
 
   private ArrayList<Student> studentList = new ArrayList<Student>(); // dynamic list to hold rows
   private ArrayList<Sessions> presenterList = new ArrayList<Sessions>(); // dynamic list to hold rows
 
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
  
  //method for printing the student and their choices
  public void PrintStudentList() {
   for (int i = 0; i < studentList.size(); i++)
        {
            System.out.println(studentList.get(i).getListChoice());
        }
	  
	}  
	
	 //tally for amount of selected chocies for each session
  public void tallySessions(){
     for(int i = 0; i < presenterList.size(); i++){
       int counter = 0;
       for(int j = 0; j < studentList.size(); j++){
		  if(presenterList.get(i).getsessionID() == studentList.get(j).getc1()
		     || presenterList.get(i).getsessionID() == studentList.get(j).getc2()
		     || presenterList.get(i).getsessionID() == studentList.get(j).getc3()
		     || presenterList.get(i).getsessionID() == studentList.get(j).getc4()
		     || presenterList.get(i).getsessionID() == studentList.get(j).getc5())
		  
		  {
			counter++;
		  }  
	    }
  	 presenterList.get(i).setCount(counter);
	}
		int n = presenterList.get(i).printSession();
		//sorting for the tallys
			for (int j = 1; j <= 18; j++)
            { 
              int possibleIndex = j;
              while (possibleIndex > 0 && n < presenterList[possibleIndex - 1])
              {
				  if(n < presenterList[possibleIndex - 1]) {
                     insertCompare++; 
                   }
                  presenterList[possibleIndex] = presenterList[possibleIndex - 1];
                  possibleIndex--;
              }
              presenterList[possibleIndex] = n;
              }
              
              for(int w = 0; w <= 18; w++){
				System.out.print(presenterList[w] + " ");
			}
  }
  
	
	//method for priting the session
  public void PrintPresenterID(){
	 int numP = presenterList.size();
      for(int i = 0; i < numP; i++)
		{
			System.out.println(presenterList.get(i).printSession());
		}
	}
}

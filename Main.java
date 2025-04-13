
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
        SeniorSeminar p1 = new SeniorSeminar();
        
        p1.PrintStudentList();
        p1.tallySessions();
        p1.PrintPresenterID();
    }
}

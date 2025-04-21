/**
 * Main.java
 * 
 * Author: Nico Mayoral
 * Date: 4/21/25
 * Preconditons: Main  Class and Object
 * Postconditions: uses SessionSeminar.java, Sessions.java and Student.java  and calls the methods available
 * 
 * Purpose: This object is used as a tester for the SessionSeminar class able to execute all needed methods
 * 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
        SeniorSeminar p1 = new SeniorSeminar();
        p1.tallySessions();        
        p1.ScheduleSessions();
        p1.PrintRosterPerSessions();
        p1.PrintRosterforStudent();
    }
}

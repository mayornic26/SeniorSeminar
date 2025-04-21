//**
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

/** Main Class: Creates Session Seminar object, calls for sessions to be counted based on popularity, executes the assignment and prints the rosters and schedules
*/

public class Main {
	public static void main(String[] args) {
        SeniorSeminar p1 = new SeniorSeminar();  // Creates the SeniorSeminar Object
        p1.tallySessions();       // Performs a tally of how many people chose each class and sorts descending order
        p1.ScheduleSessions();    // Proceeds to schedule each session on room and timeslot and assign the students
        p1.PrintRosterPerSessions();   // Prints on the screen the schedule for each session (room, timeslot and students)
        p1.PrintRosterforStudent();   // Prints on the screen each student and its scheduled classes
    }
}

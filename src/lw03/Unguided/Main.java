package lw03.Unguided;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Set<String> registeredStudents = new HashSet<>();
        List<String> checkedInStudents = new ArrayList<>();
        List<String> results = new ArrayList<>();
       
        Scanner registrationScanner = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        while (registrationScanner.hasNextLine()) {
            String studentId = registrationScanner.nextLine();
            registeredStudents.add(studentId);
        }

        registrationScanner.close();

        Scanner checkInScanner = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        
        int rejectedAttempts = 0;
        while (checkInScanner.hasNextLine()) {
            String studentId = checkInScanner.nextLine();

            if (!registeredStudents.contains(studentId)) {
                results.add(studentId + ": Rejected (not registered)");
                rejectedAttempts++;
            } else if (checkedInStudents.contains(studentId)) {
                results.add(studentId + ": Rejected (already checked in)");
                rejectedAttempts++;
            } else {
                checkedInStudents.add(studentId);
                results.add(studentId + ": Checked in");
            }
        }

        checkInScanner.close();

        System.out.println("===== Event Check-In Results =====");
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }

        int absentStudents = registeredStudents.size() - checkedInStudents.size();

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registeredStudents.size());
        System.out.println("Successful check-ins: " + checkedInStudents.size());
        System.out.println("Absent students: " + absentStudents);
        System.out.println("Rejected attempts: " + rejectedAttempts);
    }
}


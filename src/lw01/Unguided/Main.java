package Unguided;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WashService[] washes;
        int[] unitsOf;

        try (Scanner scanner = new Scanner(new File("washes.txt"))) {
            int total = scanner.nextInt();
            washes = new WashService[total];
            unitsOf = new int[total];

                        for (int i = 0; i < total; i++) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                int units = scanner.nextInt();

                if (type.equals("MOTORCYCLE")) {
                    washes[i] = new MotorcycleWash(id, days);
                } else {
                    washes[i] = new CarWash(id, days);
                }
                unitsOf[i] = units;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File washes.txt not found.");
            return;
        }

           for (int i = 0; i < washes.length; i++) {
            WashService wash = washes[i];
            System.out.println(wash.getId() + " | " + wash.label() + " | " + wash.calculateCharge(unitsOf[i]));
        }
    }
}


package lw03.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
    }

    // ==================== PROBLEM 1 ====================
    private static void problem1() {
        List<String> playlist = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(
                    new File("src/lw03/prelab/playlist.txt")
            );

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty()) {
                    continue;
                }

                if (line.startsWith("ADD ")) {
                    String song = line.substring(4);
                    playlist.add(song);

                } else if (line.startsWith("INSERT ")) {
                    String rest = line.substring(7);

                    int spaceIndex = rest.indexOf(' ');
                    int index = Integer.parseInt(
                            rest.substring(0, spaceIndex)
                    );

                    String song = rest.substring(spaceIndex + 1);

                    playlist.add(index, song);

                } else if (line.startsWith("REMOVE ")) {
                    String song = line.substring(7);

                    playlist.remove(song);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("playlist.txt not found.");
        }

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        System.out.println();
    }

    // ==================== PROBLEM 2 ====================
    private static void problem2() {
        Set<String> participants = new LinkedHashSet<>();
        int duplicates = 0;

        try {
            Scanner scanner = new Scanner(
                    new File("src/lw03/prelab/participants.txt")
            );

            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    continue;
                }

                if (participants.contains(name)) {
                    duplicates++;
                } else {
                    participants.add(name);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("participants.txt not found.");
        }

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int number = 1;

        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }

        System.out.println("Duplicate registrations: " + duplicates);
        System.out.println();
    }

    // ==================== PROBLEM 3 ====================
    private static void problem3() {
        Map<String, Integer> stock = new LinkedHashMap<>();
        int failedSales = 0;

        try {
            Scanner scanner = new Scanner(
                    new File("src/lw03/prelab/inventory.txt")
            );

            while (scanner.hasNext()) {
                String type = scanner.next();
                String product = scanner.next();
                int quantity = scanner.nextInt();

                if (type.equals("ADD")) {

                    if (stock.containsKey(product)) {
                        stock.put(
                                product,
                                stock.get(product) + quantity
                        );
                    } else {
                        stock.put(product, quantity);
                    }

                } else if (type.equals("SELL")) {

                    if (stock.containsKey(product)
                            && stock.get(product) >= quantity) {

                        stock.put(
                                product,
                                stock.get(product) - quantity
                        );

                    } else {
                        failedSales++;
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("inventory.txt not found.");
        }

        System.out.println("===== Problem 3 =====");

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }

        System.out.println("Failed sales: " + failedSales);
    }
}

package lw02.prelab.Unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foods = new LinkedList<>();
        LinkedList<String[]> drinks = new LinkedList<>();
        LinkedList<String[]> success= new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();


        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("orders.txt"));

        while (scanner.hasNext()) {
            String name = scanner.next();
            String side_dish = scanner.next();
            String drink = scanner.next();
            String table = scanner.next();
            orders.add(new String[]{name, side_dish, drink, table});

            foods.add(new String[]{side_dish, "Bakso", "2"});
            foods.add(new String[]{side_dish, "Sate", "1"});
            foods.add(new String[]{side_dish, "Soto", "2"});

            drinks.add(new String[]{drink, "EsTeh", "4"});
            drinks.add(new String[]{drink, "EsJeruk", "2"});
        }
            queue.addAll(orders);

            while (!queue.isEmpty()) {
                String[] order = queue.poll();
                String name = order[0];
                String side_dish = order[1];
                String drink = order[2];
                String table = order[3];

                
                String[] food = null;
                if (!foods.isEmpty()) {
                    for (String[] f : foods) {
                        if (f[0].equals(side_dish)) {
                            food = f;
                            break;
                        }
                    }
                }
                String[] drinkItem = null;
                if (!drinks.equals("-")) {
                    for (String[] d : drinks) {
                        if (d[0].equals(drink)) {
                            drinkItem = d;
                            break;
                        }
                    }
                }
            if (food != null && drinkItem != null) {
                success.add(order);
            } else {
                failed.push(order);
            }
        }
        
        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : success) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for (String[] f : foods) {
            System.out.println(f[0] + " : " + f[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] d : drinks) {
            System.out.println(d[0] + " : " + d[1]);
        }

        System.out.println();
        System.out.println("=== Failed Orders ===");
        while (!failed.isEmpty()) {
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }
    }
}


        


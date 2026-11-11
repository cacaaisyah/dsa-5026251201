package lw04.Unguided;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    // Method Bubble Sort Descending
    public static void bubbleSort(int[] arr, int[] afterTwoPasses) {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
 
            }

        // Copy array after 2 passes
        if (i == 1) {
            for (int j = 0; j < n; j++) {
                afterTwoPasses[j] = arr[j];
            }

        }
    }

}

// Method Binary Search Descending
public static int[] binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int steps = 0;

    while (low <= high) {
        steps++;
        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return new int[]{mid, steps};
        } else if (arr[mid] > target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return new int[]{-1, steps};
}

// Main Method
public static void main(String[] args) throws FileNotFoundException {

    Scanner input = new Scanner(new File("src/lw04/Unguided/parcels.txt"));

    // read number of parcels
    int N = input.nextInt();
    int[] parcels = new int[N];
    for (int i = 0; i < N; i++) {
        parcels[i] = input.nextInt();
    }

    // read number of targets
    int M = input.nextInt();
    int[] targets = new int[M];
    for (int i = 0; i < M; i++) {
        targets[i] = input.nextInt();
   }

   input.close();

   //array to store the state of parcels after 2 passes 
    int[] afterTwoPasses = new int[N];

    //call bubble sort
    bubbleSort(parcels, afterTwoPasses);

    //display array after 2 passes
    System.out.println("==== After 2 Passes ====");
    for (int i = 0; i < N; i++) {
        System.out.print(afterTwoPasses[i] + " ");  
    }
    System.out.println();

    //display fully sorted array
    System.out.println("==== Fully Sorted ====");
    for (int i = 0; i < N; i++) {
        System.out.print(parcels[i] + " ");
    }
    System.out.println();

    //display search reusults
    System.out.println();
    System.out.println("==== Search Results ====");
    for (int i = 0; i < M; i++) {
        int[] result = binarySearch(parcels, targets[i]);
        
        int index = result[0];
        int steps = result[1];

            if (index != -1) {
                System.out.println(targets[i] + ": FOUND at index " + index + " (steps: " + steps + ")");
            } else {
            System.out.println(targets[i] + ": NOT FOUND (steps: " + steps + ")");
            }
        }
    }

}
package lw04.prelab;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i <= 3; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }

    return -1;
}
public static void main(String[] args) throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("src/lw04/prelab/branches.txt"));

    int N = scanner.nextInt();
    int[] branches = new int[N];

    for (int i = 0; i < N; i++) {
    branches[i] = scanner.nextInt();
    }

    int M = scanner.nextInt();
    int[] targets = new int[M];

    for (int i = 0; i < M; i++) {
    targets[i] = scanner.nextInt();
}

    insertionSort(branches);
for (int i = 0; i < branches.length; i++) {
    System.out.print(branches[i]);

    if (i < branches.length - 1) {
        System.out.print(" ");
    }
}

System.out.println();

for (int i = 0; i < M; i++) {
    int result = linearSearch(branches, targets[i]);

    if (result != -1) {
        System.out.println(targets[i] + ": FOUND at index " + result);
    } else {
        System.out.println(targets[i] + ": NOT FOUND");
    }
}

scanner.close();
    }
}
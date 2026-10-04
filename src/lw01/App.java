package lw01;
import lw01.prelab.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        List<PrintJob> jobs = new ArrayList<>();

        Scanner scanner = new Scanner(
            new File("src/lw01/prelab/jobs.txt")
        );

        while (scanner.hasNext()) {
            String type = scanner.next();
            String jobId = scanner.next();
            int pages = scanner.nextInt();

            PrintJob job;

            if (type.equals("MONO")) {
                job = new MonoPrint(jobId, pages);
            } else {
                job = new ColourPrint(jobId, pages);
            }

            jobs.add(job);
            // Process the print job based on its type and ID
        }

        scanner.close();

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }

    }
}
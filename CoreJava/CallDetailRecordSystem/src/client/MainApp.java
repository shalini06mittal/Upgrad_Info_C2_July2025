package client;

import dao.CDRDao;
import model.CDR;
import service.CDRService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws Exception {
        CDRDao dao = new CDRDao();
        CDRService service = new CDRService(dao);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        int choice;
        do {
            System.out.println("\nCDR Analyzer System");
            System.out.println("1. Add Call Record");
            System.out.println("2. View CDRs by Number");
            System.out.println("3. Get Total Call Duration");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Caller: ");
                    String caller = sc.nextLine();
                    System.out.print("Receiver: ");
                    String receiver = sc.nextLine();
                    System.out.print("Date (dd MM yyyy): ");
                    LocalDate date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd MM yyyy"));


                    System.out.print("Duration (sec): ");
                    int dur = sc.nextInt(); sc.nextLine();

                    service.recordCall(new CDR(caller, receiver, date, dur));
                    System.out.println("✅ Call record added.");
                }

                case 2 -> {
                    System.out.print("Enter Mobile Number: ");
                    String number = sc.nextLine();
                    List<CDR> cdrs = service.getUserCDRs(number);
                    cdrs.forEach(System.out::println);
                }

                case 3 -> {
                    System.out.print("Enter Mobile Number: ");
                    String number = sc.nextLine();
                    int total = service.getTotalCallDuration(number);
                    System.out.println("Total call duration: " + total + " seconds");
                }

                case 4 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}

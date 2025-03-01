import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
    Scanner scan = new Scanner(System.in);
    private Register reg;

    // Arrays to store approved applications
    public String[] approvedUsers = new String[Register.MAX_USERS];
    public String[] reportData = new String[Register.MAX_USERS];
    public int approvedCount = 0;

    // Constructor to accept Register instance
    public Admin(Register reg) {
        this.reg = reg;
    }

    // Admin Panel
    public void admin() {
        while (true) {
            System.out.println("\n=== ADMIN PANEL ===");
            System.out.println("1. Review Applications");
            System.out.println("2. Exit");
            System.out.print("Enter the option: ");
            int opt = scan.nextInt();

            switch (opt) {
                case 1:
                    reviewApplications();
                    break;
                case 2:
                    return; // Exit admin panel
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    // Review applications
    public void reviewApplications() {
        System.out.println("\n=== REVIEW APPLICATIONS ===");

        boolean hasPending = false;
        for (int i = 0; i < reg.userCount; i++) {
            if (reg.role[i].equalsIgnoreCase("user")) { // Check if user is not an admin
                hasPending = true;
                System.out.println("User ID: " + reg.userId[i] + " | Name: " + reg.name[i] + " | Email: " + reg.email[i]);
                System.out.println("Approve application? (1 = Approve, 2 = Reject)");
                int choice = scan.nextInt();

                if (choice == 1) {
                    approveApplication(i);
                } else {
                    System.out.println("Application rejected.");
                }
            }
        }

        if (!hasPending) {
            System.out.println("No applications to review.");
        }
    }

    // Approve user application and save to report
    public void approveApplication(int index) {
        approvedUsers[approvedCount] = reg.name[index];

        // Generate fake license details for reporting
        String licenseId = "LIC-" + (1000 + index);
        String category = "General";
        String issueDate = "2024-03-01";
        String expiryDate = "2029-03-01";

        // Save approved user data
        reportData[approvedCount] = "User: " + reg.name[index] + " | License ID: " + licenseId + " | Category: " + category + " | Issue: " + issueDate + " | Expiry: " + expiryDate;
        approvedCount++;

        saveReportToFile(index, licenseId, category, issueDate, expiryDate);
        System.out.println("Application approved for " + reg.name[index]);
    }

    // Save report data to file
    public void saveReportToFile(int index, String licenseId, String category, String issueDate, String expiryDate) {
        try (FileWriter writer = new FileWriter("report.txt", true)) {
            writer.write(reg.name[index] + "," + licenseId + "," + category + "," + issueDate + "," + expiryDate + "\n");
        } catch (IOException e) {
            System.out.println("Error saving report data: " + e.getMessage());
        }
    }

    // User panel
    public void users() {
        System.out.println("\nWelcome " + reg.name[reg.userCount - 1] + "!");
        while (true) {
            System.out.println("1. Apply for License");
            System.out.println("2. View Report");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int opt = scan.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("Your application has been submitted.");
                    break;
                case 2:
                    viewReport();
                    break;
                case 3:
                    return; // Exit user panel
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // View approved report
    public void viewReport() {
        System.out.println("\n=== LICENSE REPORT ===");
        if (approvedCount == 0) {
            System.out.println("No approved licenses yet.");
            return;
        }

        for (int i = 0; i < approvedCount; i++) {
            System.out.println(reportData[i]);
        }
    }
}

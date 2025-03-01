import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {
    public static final int MAX_USERS = 100; // Maximum number of users

    public double[] userId = new double[MAX_USERS];
    public double[] citizenshipNumber = new double[MAX_USERS];
    public String[] name = new String[MAX_USERS];
    public String[] role = new String[MAX_USERS];
    public String[] email = new String[MAX_USERS];
    public String[] password = new String[MAX_USERS];

    public int userCount = 0; // Track number of users

    Admin user = new Admin(this);
    Scanner scan = new Scanner(System.in);

    // Method for Register
    public void Reg() {
        if (userCount >= MAX_USERS) {
            System.out.println("User limit reached. Cannot register more users.");
            return;
        }

        System.out.println("Enter user ID:");
        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a numeric User ID:");
            scan.next();
        }
        userId[userCount] = scan.nextDouble();
        scan.nextLine();

        System.out.println("Enter user Name:");
        name[userCount] = scan.nextLine();

        System.out.println("Enter role (user/admin):");
        role[userCount] = scan.nextLine();

        System.out.println("Enter Email:");
        email[userCount] = scan.nextLine();

        System.out.println("Enter Citizenship Number:");
        while (!scan.hasNextDouble()) {
            System.out.println("Invalid input! Please enter a numeric Citizenship Number:");
            scan.next();
        }
        citizenshipNumber[userCount] = scan.nextDouble();
        scan.nextLine();

        System.out.println("Enter password:");
        password[userCount] = scan.nextLine();

        saveUserDataToFile(userCount); // Save data to file
        userCount++;

        System.out.println("Registration successful!");
    }

    // Method to save user data to a file
    public void saveUserDataToFile(int index) {
        try (FileWriter writer = new FileWriter("userdata.txt", true)) {
            writer.write(userId[index] + "," + name[index] + "," + role[index] + "," +
                    email[index] + "," + citizenshipNumber[index] + "," + password[index] + "\n");
        } catch (IOException e) {
            System.out.println("Error saving user data to file: " + e.getMessage());
        }
    }

    // Login method
    public void login() {
        System.out.println("Enter your email:");
        String inputEmail = scan.nextLine();

        System.out.println("Enter your password:");
        String inputPassword = scan.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (inputEmail.equals(email[i]) && inputPassword.equals(password[i])) {
                if (role[i].equalsIgnoreCase("admin")) {
                    user.admin();
                } else {
                    user.users();
                }
                return;
            }
        }
        System.out.println("Invalid Email or Password.");
    }
}

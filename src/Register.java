import java.util.Scanner;
public class Register {
    public double userId,citizenshipNumber;
    public String name,role,email,password;
//method for user and admin
    Admin user = new Admin();
    Scanner scan = new Scanner(System.in);
//for Register
    public void Reg(){

        System.out.println("Enter user ID:");
        userId = scan.nextDouble();
        scan.nextLine();
        System.out.println("Enter user Name:");
        name = scan.nextLine();
        System.out.println("Enter role:");
        role = scan.nextLine();
        System.out.println("Enter Email:");
        email = scan.nextLine();
        System.out.println("Enter Citizenship Number:");
        citizenshipNumber = scan.nextDouble();
        scan.nextLine();
        System.out.println("Enter password:");
        password = scan.nextLine();
    }

//fo login
    public void login(){

        System.out.println("Enter your email :");
        String inputEmail = scan.nextLine();
        System.out.println("Enter your Password :");
        String inputPassword = scan.nextLine();
        if(inputEmail.equals(email) && inputPassword.equals(password) && role.equals("admin") ){
            user.admin();
        } else if (inputEmail.equals(email) && inputPassword.equals(password) && role.equals("user")) {
            user.users();
        }
    }
}

import java.util.Scanner;

public class Admin {

    Scanner scan = new Scanner(System.in);


    public void admin(){
        while(true){
            System.out.println("\n#Admin Review and Application");
            System.out.println("Enter the option:");
            String opt = scan.nextLine();

            switch (opt){
                case "#":
                    System.out.println("App");//add other method
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }


    public void users(){
        System.out.println("1.License Application");
        System.out.println("2.Report");
        System.out.println("Enter your choice:");
        int opt = scan.nextInt();
        switch (opt){
            case 1:
                System.out.println("Application");//add other method
                break;
            case 2:
                System.out.println("Report");//add other method
                break;
            default:
                System.out.println("Invalid");
        }
    }
}

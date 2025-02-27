import java.util.Scanner;
public class Main{
    public static void main(String[]args){
//        Methods
        Scanner scan = new Scanner(System.in);
        Register reg =new Register();

//        till here Methods
        boolean loop = true;
        while(loop){
            System.out.println("===Licence-Management-System===");
            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");
            System.out.println("===============================");
            System.out.print("Enter number according to ur choice:");
            int opt = scan.nextInt();
            switch (opt){
                case 1:
                    reg.Reg();
                    break;
                case 2:
                    reg.login();
                   break;
                case 3:
                    loop =false;
                    break;
                default:
                    System.out.println("Invalid Option");

            }

        }
    }
}
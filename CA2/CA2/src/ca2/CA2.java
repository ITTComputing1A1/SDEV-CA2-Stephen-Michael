package ca2;
/**
 * Michael Brady X00136103
 */
import java.util.Scanner;
public class CA2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter your username");
        String username;
        username = input.nextLine();
        String password;
        System.out.println("Enter your password");
        password = input.nextLine();
        System.out.println("Confirm your password");
        if(input.nextLine().equals(password)) {
            System.out.println("Password accepted");
        }
        else {
            System.out.println("Username or Password incorrect");
        }
        
        int selection = 0;
        
        while(selection != 5){
            System.out.printf("Student Finance System%n"
                    + "1. Calculate Student Grant%n"
                    + "2. Current Overall Student Average%n"
                    + "3. Fee Data%n"
                    + "4. Grant Category Information%n"
                    + "5. Exit");
            System.out.println("Select option");
            selection = input.nextInt();
            
            switch(selection){
                case 1:
                    System.out.println("You have selected "+"Calculate Student Grant");
                    String studentName;
                    String studentNumber;
                    System.out.println("Enter your name");
                    input.nextLine();
                    studentName = input.nextLine();
                    System.out.println("Enter your student number.");
                    studentNumber = input.nextLine();
                    while(studentNumber.charAt(0) != 'X'){
                        System.out.println("Invalid Student Number format. Number must begin with uppercase 'X'. Please re-enter.");
                        studentNumber = input.nextLine();
                    }
                    break;
                case 2:
                    System.out.println("Option 2");
                    break;
                case 3:
                    System.out.println("Option 3");
                    break;
                case 4:
                    System.out.println("Option 4");
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection. Please re-enter");
                    break;
            }
        }
    }
}

package ca2;

/**
 *
 * @author X00136103 + X00137811
 */
import java.util.Scanner;

public class CA2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int FEE_PAID_MAJORITY = 750;
        final int FEE_PAID_HALF = 1500;
        final int FEE_PAID_NONE = 3000;
        String username1, password1;
        int attempts, overallAverageResult = 0,
            totalFee, totalPaidByGrant = 0, totalPaidByStudent = 0,
            studentsProcessed = 0, studentsWithGrant = 0;

        System.out.println("Please enter your username");
        username1 = input.nextLine();

        System.out.println("Please enter your password");
        password1 = input.nextLine();

        System.out.println("Please confirm your password");
        attempts = 3;
        while (attempts != -1) {
            if (input.nextLine().equals(password1)) {
                System.out.println("Logged in.");
                break;
            } 
            else {
                System.out.printf("Password or Username is incorrect. %d attempts left.%n", attempts);
                attempts--;
            }
        }
        if (attempts == -1) {
            System.exit(0);
        }
        int selection = 0;
        System.out.println("degub");
        do{ //Display the menu at least once
            System.out.printf("Student Finance System%n"
                    + "1. Calculate Student Grant%n"
                    + "2. Current Overall Student Average%n"
                    + "3. Fee Data%n"
                    + "4. Grant Category Information%n"
                    + "5. Exit");
            System.out.printf("%nSelect option%n");
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    int sDevResult, mathsResult, L2LResult, compArchResult, averageResult;
                    System.out.println("You have selected " + "Calculate Student Grant");
                    String studentName;
                    String studentNumber;
                    System.out.println("Enter your name");
                    input.nextLine();
                    studentName = input.nextLine();
                    System.out.println("Enter your student number.");
                    studentNumber = input.nextLine();
                    while (studentNumber.charAt(0) != 'X') {
                        System.out.println("Invalid Student Number format. Number must begin with uppercase 'X'. Please re-enter.");
                        studentNumber = input.nextLine();
                    }
                    System.out.printf("%nCredentials accepted%nPlease enter your results for the following subjects:%nSoftware Development: %n");
                    sDevResult = input.nextInt();
                    System.out.println("Mathematics: ");
                    mathsResult = input.nextInt();
                    System.out.println("Learning to Learn: ");
                    L2LResult = input.nextInt();
                    System.out.println("Computer Architecture: ");
                    compArchResult = input.nextInt();
                    averageResult = (sDevResult + mathsResult + L2LResult + compArchResult) / 4;    //Calculate the average right here
                    if(overallAverageResult == 0) 
                        overallAverageResult = averageResult;   //Check to see if overall average hasn't been set yet, so that the first result doesn't average with 0.
                    overallAverageResult = (overallAverageResult += averageResult) / 2; //Add the average of the current student to the average of the others.
                    System.out.printf("%nStudent Name: %s%nStudent Number: %s%nYour average result is %d.%n", studentName, studentNumber, averageResult);
                    
                    //If-else all the grades to find out who's got what kind of grant
                    if(averageResult >= 90 && averageResult <= 100) {
                        totalFee = 0;
                        System.out.printf("Your total fee comes to %d. Your grant covers 100%% of your fees.", totalFee);
                        studentsWithGrant++;
                        studentsProcessed++;
                        totalPaidByGrant += FEE_PAID_NONE;
                    }
                    else if(averageResult >= 75) 
                    {
                        totalFee = FEE_PAID_MAJORITY;
                        System.out.printf("Your total fee comes to %d. Your grant covers 75%% of your fees.", totalFee);
                        studentsWithGrant++;
                        studentsProcessed++;
                        totalPaidByGrant += FEE_PAID_MAJORITY;
                        totalPaidByStudent += FEE_PAID_MAJORITY;
                    }
                    else if(averageResult >= 50) 
                     {
                        totalFee = FEE_PAID_HALF;
                        System.out.printf("Your total fee comes to %d. Your grant covers 50%% of your fees.", totalFee);
                        studentsWithGrant++;
                        studentsProcessed++;
                        totalPaidByGrant += FEE_PAID_HALF;
                        totalPaidByStudent += FEE_PAID_HALF;
                    }
                    else if(averageResult < 50) 
                     {
                        totalFee = FEE_PAID_NONE;
                        System.out.printf("Your total fee comes to %d. Your grant covers 0%% of your fees.", totalFee);
                        studentsProcessed++;
                        totalPaidByStudent += FEE_PAID_NONE;
                    }
                    else {
                                System.out.println("Invalid results.");
                    }
                    break;
                case 2:
                    System.out.println("Overall Average Result: " + overallAverageResult);
                    break;
                case 3:
                    System.out.println("You have selected" + "Fee Data");
                    System.out.printf("%nOverall fees paid by grant: %d%nOverall fees paid by student: %d%nStudents Processed: %d%nTotal number of students "
                            + "who recieved a grant: %d%n", totalPaidByGrant, totalPaidByStudent, studentsProcessed, studentsWithGrant);                                       
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
        }  while (selection != 5);
        }
    }
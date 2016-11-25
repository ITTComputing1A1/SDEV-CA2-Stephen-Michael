package ca2;

/*
 * @Michael Brady X00136103 + @Stephen Curran X00137811
 */
import java.util.Scanner;

public class CA2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int FEE_PAID_MAJORITY = 2250;
        final int FEE_PAID_HALF = 1500;
        final int FEE_PAID_NONE = 3000;
        String username1, password1;
        int attempts;
        double overallAverageResult = 0, totalFee, totalPaidByGrant = 0, totalPaidByStudent = 0;

        int studentsProcessed = 0, studentsWithGrant = 0, studentsFullGrant = 0, //Create all the counters for the grant section
                studentsMajorityGrant = 0, studentsHalfGrant = 0, studentsNoGrant = 0;

        System.out.print("Please enter your username: ");
        username1 = input.nextLine();

        System.out.print("Please enter your password: ");
        password1 = input.nextLine();

        System.out.print("Please confirm your password: ");
        attempts = 3;
        while (attempts != -1) { //Check if the password was entered correctly
            if (input.nextLine().equals(password1)) {
                System.out.println("Logged in.");
                break;
            } else {
                System.out.printf("Password or Username is incorrect. Please re-enter. %d attempts left: ", attempts);
                attempts--;
            }
        }
        if (attempts == -1) {
            System.exit(0);
        }

        int selection = 0;
        do { //Display the menu at least once
            System.out.printf("%n-------------------------------%n"
                    + "Student Finance System%n"
                    + "1. Calculate Student Grant%n"
                    + "2. Current Overall Student Average%n"
                    + "3. Fee Data%n"
                    + "4. Grant Category Information%n"
                    + "5. Exit"
                    + "%n-------------------------------%n");
            System.out.printf("%nSelect option: ");
            selection = input.nextInt();
            switch (selection) {
                case 1:
                    //Declare variables to hold each result
                    int sDevResult,
                     mathsResult,
                     L2LResult,
                     compArchResult,
                     averageResult;
                    System.out.println("You have selected \"Calculate Student Grant\".");
                    String studentName;
                    String studentNumber;
                    System.out.print("Enter your name: ");
                    input.nextLine();
                    studentName = input.nextLine();
                    System.out.print("Enter your student number: ");
                    studentNumber = input.nextLine();
                    while (studentNumber.charAt(0) != 'X') { //Check if the number starts with an X
                        System.out.print("Invalid Student Number format. Number must begin with uppercase 'X'. Please re-enter: ");
                        studentNumber = input.nextLine();
                    }
                    System.out.printf("%nCredentials accepted%nPlease enter your results for the following subjects:%nSoftware Development: ");
                    sDevResult = input.nextInt();
                    System.out.printf("%nMathematics: ");
                    mathsResult = input.nextInt();
                    System.out.printf("%nLearning to Learn: ");
                    L2LResult = input.nextInt();
                    System.out.printf("%nComputer Architecture: ");
                    compArchResult = input.nextInt();
                    averageResult = (sDevResult + mathsResult + L2LResult + compArchResult) / 4;    //Calculate the average right here
                    if (overallAverageResult == 0) {
                        overallAverageResult = averageResult;   //Check to see if overall average hasn't been set yet, so that the first result doesn't average with 0.
                    }
                    overallAverageResult = (overallAverageResult += averageResult) / 2; //Add the average of the current student to the average of the others.
                    System.out.printf("%nStudent Name: %s%nStudent Number: %s%nYour average result is %d.%n", studentName, studentNumber, averageResult);

                    //If-else all the grades to find out who's got what kind of grant
                    if (averageResult >= 90 && averageResult <= 100) {
                        totalFee = 0;
                        System.out.printf("Your total fee comes to %.2f. Your grant covers 100%% of your fees.%n", totalFee);
                        studentsWithGrant++;
                        studentsProcessed++;
                        studentsFullGrant++;
                        totalPaidByGrant += FEE_PAID_NONE;
                    } else if (averageResult >= 75) {
                        totalFee = 750;
                        System.out.printf("Your total fee comes to %.2f. Your grant covers 75%% of your fees.%n", totalFee);
                        studentsWithGrant++;
                        studentsProcessed++;
                        studentsMajorityGrant++;
                        totalPaidByGrant += FEE_PAID_MAJORITY;
                        totalPaidByStudent += FEE_PAID_NONE - FEE_PAID_MAJORITY;
                    } else if (averageResult >= 50) {
                        totalFee = 1500;
                        System.out.printf("Your total fee comes to %.2f. Your grant covers 50%% of your fees.%n", totalFee);
                        studentsWithGrant++;
                        studentsProcessed++;
                        studentsHalfGrant++;
                        totalPaidByGrant += FEE_PAID_HALF;
                        totalPaidByStudent += FEE_PAID_HALF;
                    } else if (averageResult < 50) {
                        totalFee = FEE_PAID_NONE;
                        System.out.printf("Your total fee comes to %.2f. Your grant covers 0%% of your fees.%n", totalFee);
                        studentsProcessed++;
                        studentsNoGrant++;
                        totalPaidByStudent += FEE_PAID_NONE;
                    } else {
                        System.out.println("Invalid results.");
                    }
                    System.out.println("Press enter to return to menu.");
                    input.nextLine();
                    input.nextLine();
                    break;
                case 2:
                    System.out.println("Overall Average Result: " + overallAverageResult);
                    System.out.println("Press enter to return to menu.");
                    input.nextLine();
                    input.nextLine();
                    break;
                case 3:
                    System.out.println("You have selected\"Fee Data\"");
                    System.out.printf("%nOverall fees paid by grant: %.2f%nOverall fees paid by student: %.2f%nStudents Processed: %d%nTotal number of students "
                            + "who recieved a grant: %d%n", totalPaidByGrant, totalPaidByStudent, studentsProcessed, studentsWithGrant);
                    System.out.println("Press enter to return to menu.");
                    input.nextLine();
                    input.nextLine();
                    break;
                case 4:
                    System.out.printf("You have selected \"Grant Category Information\"%nNumber of students who received a grant of 100%% off their total fees: %d%nNumber of"
                            + "students who received a grant of 75%% off their total fees: %d%nNumber of students who received a grant of 50%% off their total fees: %d%n"
                            + "Number of students who didn't receive a grant: %d%n", studentsFullGrant, studentsMajorityGrant, studentsHalfGrant, studentsNoGrant);
                    int biggestCategory = Math.max(Math.max(studentsFullGrant, studentsMajorityGrant), Math.max(studentsHalfGrant, studentsNoGrant)); //Find the biggest counter
                    if (biggestCategory == studentsFullGrant) {
                        System.out.printf("The majority of students received a 100%% grant.%n");
                    } else if (biggestCategory == studentsMajorityGrant) {
                        System.out.printf("The majority of students received a 75%% grant.%n");
                    } else if (biggestCategory == studentsHalfGrant) {
                        System.out.printf("The majority of students received a 50%% grant.%n");
                    } else if (biggestCategory == studentsFullGrant) {
                        System.out.printf("The majority of students received no grant.%n");
                    }
                    System.out.println("Press enter to return to menu.");
                    input.nextLine();
                    input.nextLine();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection. Please re-enter");
                    break;
            }
        } while (selection != 5);
    }
}

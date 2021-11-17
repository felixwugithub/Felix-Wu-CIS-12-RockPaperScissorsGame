import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RPS {

    private static double inputAmount() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Your Move? --> _____");

            try {
                return input.nextDouble();
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("Error 1: Invalid Input --- Please try again and enter a NUMBER.");
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<String> RPS = new ArrayList<String>();
        RPS.add("Rock");
        RPS.add("Paper");
        RPS.add("Scissor");

        System.out.println("_________________________________________________________");
        System.out.println("----|| Welcome to Felix's Rock Paper Scissor Game. ||----");
        System.out.println("Please choose your move by entering the corresponding number");
        System.out.println("1) Rock");
        System.out.println("2) Paper");
        System.out.println("3) Scissors");

        int INPUT = 0;

        while(true){
            INPUT = (int) inputAmount();
       if(INPUT > RPS.size() || INPUT < 1){
           System.out.println("Error 2: Unavailable Choice --- Please enter a number between 1 to 3, inclusive. ");
       }else{
           break;
       }
        }
        System.out.println("You've selected " + RPS.get(INPUT-1));

        int ComputerMove = (int) ((Math.random())*3);
        System.out.println("The Computer selected " + RPS.get(ComputerMove));

        int ComputerMovePlus1 = ComputerMove + 1;
        int difference = INPUT - ComputerMovePlus1;

        if(INPUT == ComputerMovePlus1){
            System.out.println(" Tie");
        }else if(difference == 1 || difference == -2){
            System.out.println(" YOU Win");
        }else if(difference == -1 || difference == 2){
            System.out.println("YOU Lose");
        }else{
            System.out.println("Error 3: Unknown Logic Error.");
        }






    }
}

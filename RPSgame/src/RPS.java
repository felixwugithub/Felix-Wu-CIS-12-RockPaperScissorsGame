import java.util.ArrayList;
import java.util.Scanner;

public class RPS {

    private static double inputChoice() {   //A while loop that catches invalid inputs and re-prompt the user until a valid input is entered.
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Your Move? --> ");

            try {
                return input.nextInt();
            }
            catch (java.util.InputMismatchException e) { //if the user fails to input an int, then the error will be caught and it will print the following error message
                System.out.println("Error 1: Invalid Input --- Please try again and enter a Natural Number.");
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<String> RPS = new ArrayList<String>();        //ArrayList of allowed actions, saving time for the print stuff
        RPS.add("Rock");
        RPS.add("Paper");
        RPS.add("Scissor");

        System.out.println("_________________________________________________________"); //well, this part is obvious... ASCII art!
        System.out.println("  _____          _   _          _           ____                   _        ____                                    ____           _                                  \n" +
                " |  ___|   ___  | | (_) __  __ ( )  ___    |  _ \\    ___     ___  | | __   |  _ \\    __ _   _ __     ___   _ __    / ___|    ___  (_)  ___   ___    ___    _ __   ___ \n" +
                " | |_     / _ \\ | | | | \\ \\/ / |/  / __|   | |_) |  / _ \\   / __| | |/ /   | |_) |  / _` | | '_ \\   / _ \\ | '__|   \\___ \\   / __| | | / __| / __|  / _ \\  | '__| / __|\n" +
                " |  _|   |  __/ | | | |  >  <      \\__ \\   |  _ <  | (_) | | (__  |   <    |  __/  | (_| | | |_) | |  __/ | |       ___) | | (__  | | \\__ \\ \\__ \\ | (_) | | |    \\__ \\\n" +
                " |_|      \\___| |_| |_| /_/\\_\\     |___/   |_| \\_\\  \\___/   \\___| |_|\\_\\   |_|      \\__,_| | .__/   \\___| |_|      |____/   \\___| |_| |___/ |___/  \\___/  |_|    |___/\n" +
                "                                                                                           |_|                                                                        ");
        System.out.println("Please choose your move by entering the corresponding number");


        for (int i = 0; i < RPS.size() ; i++) {
            System.out.println((i+1) + ") " + RPS.get(i)); //for loop to print out each allowed action one by one.
        }

        int INPUT = 0;
        while(true){
            INPUT = (int) inputChoice();
       if(INPUT > RPS.size() || INPUT < 1){
           System.out.println("Error 2: Unavailable Choice --- Please enter a number between 1 to 3, inclusive. ");
       }else{
           break; //when the user enters a valid value, proceed onto the next step
       }
        }
        System.out.println("You've selected " + RPS.get(INPUT-1));

        //stores an integer from 1 to 3, inclusive.
        int ComputerMove = (int) ((Math.random())*3);
        System.out.println("The Computer selected " + RPS.get(ComputerMove));

        int ComputerMovePlus1 = ComputerMove + 1; //to reduce index confusion
        int difference = INPUT - ComputerMovePlus1;



        if(INPUT == ComputerMovePlus1){                 //obviously if they make the same move it's a tie.
            System.out.println(" Tie");
        }else if((difference-1)% 3 == 0){                //a brilliant equation that determines whether the player wins or not.
            System.out.println(" YOU Win");
        }else if((difference+1)% 3 == 0){                //However,these equations assume that each action in the arraylist is placed after the action that it beats, and the last action defeats the first.
            System.out.println("YOU Lose");
        }else{
            System.out.println("Error 3: This Error is not possible.");
        }






    }
}

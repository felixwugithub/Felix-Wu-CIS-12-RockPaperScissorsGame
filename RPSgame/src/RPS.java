import java.util.ArrayList;
import java.util.Scanner;

public class RPS {

    //A while loop that catches invalid inputs and re-prompt the user until a valid input is entered, because people do stupid things.
    private static double inputChoice() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Your Move? --> ");

            try {
                return input.nextInt();
            }
            //if the user fails to input an int, then the error will be caught, and it will print an error message and allow them to retry.
            catch (java.util.InputMismatchException e) {
                System.out.println("Error 1: Invalid Input --- Please try again and enter a Natural Number.");
                input.nextLine();
            }
        }
    }

    public static void main(String[] args) {

        Scanner Play = new Scanner(System.in);

        //ArrayList of allowed actions
        ArrayList<String> RPS = new ArrayList<String>();
        RPS.add("Rock");
        RPS.add("Paper");
        RPS.add("Scissor");

        //well, this part is obvious... ASCII art!
        System.out.println("  _____          _   _          _           ____                   _        ____                                    ____           _                                  \n" +
                " |  ___|   ___  | | (_) __  __ ( )  ___    |  _ \\    ___     ___  | | __   |  _ \\    __ _   _ __     ___   _ __    / ___|    ___  (_)  ___   ___    ___    _ __   ___ \n" +
                " | |_     / _ \\ | | | | \\ \\/ / |/  / __|   | |_) |  / _ \\   / __| | |/ /   | |_) |  / _` | | '_ \\   / _ \\ | '__|   \\___ \\   / __| | | / __| / __|  / _ \\  | '__| / __|\n" +
                " |  _|   |  __/ | | | |  >  <      \\__ \\   |  _ <  | (_) | | (__  |   <    |  __/  | (_| | | |_) | |  __/ | |       ___) | | (__  | | \\__ \\ \\__ \\ | (_) | | |    \\__ \\\n" +
                " |_|      \\___| |_| |_| /_/\\_\\     |___/   |_| \\_\\  \\___/   \\___| |_|\\_\\   |_|      \\__,_| | .__/   \\___| |_|      |____/   \\___| |_| |___/ |___/  \\___/  |_|    |___/\n" +
                "                                                                                           |_|                                                                        ");

        int playerScore = 0;
       int computerScore = 0;
       boolean continuePlaying = false;

        do {

            System.out.println("------------------------------------------------------------");
            System.out.println("Please choose your move by entering the corresponding number");

            //for loop to print out each allowed action one by one.
            for (int k = 0; k < RPS.size(); k++) {
                System.out.println((k + 1) + ") " + RPS.get(k));
            }

            int INPUT = 0;
            while (true) {
                INPUT = (int) inputChoice();
                if (INPUT > RPS.size() || INPUT < 1) {
                    //if the integer does not correspond to a correct action, the program asks them to try again
                    System.out.println("Error 2: Unavailable Choice --- Please enter a number between 1 to 3, inclusive. ");
                } else {
                    //when the user enters a valid value, proceed onto the next step
                    break;
                }
            }
            System.out.print("You've selected " + RPS.get(INPUT - 1) + "  --  ");

            //stores a random integer from 1 to 3, inclusive. This is mapped to an action the same way the player's move is.
            int ComputerMove = (int) ((Math.random()) * 3);
            System.out.println("The Computer selected " + RPS.get(ComputerMove));

            int ComputerMovePlus1 = ComputerMove + 1; //to reduce index confusion
            int difference = INPUT - ComputerMovePlus1;


            if (INPUT == ComputerMovePlus1) {                 //obviously if they make the same move it's a tie.
                System.out.println("TIE");
                System.out.print("Your score: " + playerScore + "  --  ");
                System.out.println("Computer score: " + computerScore);
            } else if ((difference - 1) % 3 == 0) {                //a brilliant equation that determines whether the player wins or not.
                System.out.println("YOU WIN");
                playerScore++;

                System.out.print("Your score: " + playerScore + "  --  ");
                System.out.println("Computer score: " + computerScore);



            } else if ((difference + 1) % 3 == 0) {                //However,these equations assume that each action in the arraylist is placed after the action that it beats, and the last action defeats the first.
                System.out.println("YOU LOSE");
                computerScore++;
                System.out.print("Your score: " + playerScore + "  --  ");
                System.out.println("Computer score: " + computerScore);
            }

            System.out.println(" --------------------- ");
            System.out.println("Continue Playing? (Y/N)");
            System.out.println(" --------------------- ");
            String INPUT2 = Play.next().toUpperCase();


            if(INPUT2.equals("Y")||INPUT2.equals("YES")){
                continuePlaying = true;
            }else if(INPUT2.equals("N")||INPUT2.equals("NO")){
                System.out.print("Your score: " + playerScore + "  --  ");
                System.out.println("Computer score: " + computerScore);
                if(computerScore > playerScore){
                    System.out.println("-----------------\nYou lost overall.\n------------");
                }else if(playerScore > computerScore){
                    System.out.println("------------\nYou won overall.\n-------------");
                }else{
                    System.out.println("It was a tie overall.");
                }

                continuePlaying = false;

            }else{
                System.out.println("All you had to do was enter Y or N. That's it. I'm not playing with you anymore, stupid human.");
            }

        }while(continuePlaying);




    }
}

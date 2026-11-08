//--------------------------------------------------------------
// Assignment 2
// Written by: Yusuf Salakhutdinov 40358553
// For COMP 248 P - Fall 2026
//--------------------------------------------------------------
// Algorithm 1: COMP-248 Escape Room
//--------------------------------------------------------------

import java.util.Scanner;

public class A2_Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Welcome message
        
        System.out.println("--------------------------------------------------");
        System.out.println("      Welcome to the COMP-248 Escape Room!");
        System.out.println("--------------------------------------------------");
        
        // Choosing difficulty level and name

        System.out.println("Choose your difficulty level:\n"+
        "1 - Easy (score multiplier: x1.0)\n"+
        "2 - Medium (score multiplier x1.5)\n"+
        "3 - Hard (score multiplier x2.0)");
        System.out.print("\nYour choice: ");
        double multiplier = 0;
        String difficulty = "None (x0.0)";
        int choice = scanner.nextInt();
        if (choice == 1) {
            multiplier = 1.0;
            difficulty = "Easy (x1.0)";
        }    
        else if (choice == 2) {
            multiplier = 1.5;
            difficulty = "Medium (x1.5)";
        }
        else if (choice == 3) {
            multiplier = 2.0;
            difficulty = "Hard (x2.0)";
        }
        System.out.print("Enter your adventurer name: ");
        String name = scanner.next();
        double score = 100.00;
        
        // Puzzle 1

        System.out.println("\n--- Puzzle 1: The Combination Lock ---");
        System.out.print("A rusty lock hangs on the door. The sum of the first 5 even numbers is your code. Enter it: ");
        int answerp1 = scanner.nextInt();
        if (answerp1 == 30) System.out.print("Click! The lock opens.");
        else if ((answerp1 - 30 <= 5) && (answerp1 - 30 >= -5)) {
            System.out.print("So close... the lock rattles but holds. [-10 x " + (multiplier) + " = -" + (multiplier*10) + " pts]");
            score += multiplier*-10;
        }
        else if ((answerp1 - 30 <= 10) && (answerp1 - 30 >= -10)) {
            System.out.print("The lock doesn't budge. [-20 x " + (multiplier) + " = -" + (multiplier*20) + " pts]");
            score += multiplier*-20;
        }
        else {
            System.out.print("You pull the wrong lever and trigger a trap! [-30 x " + (multiplier) + " = -" + (multiplier*30) + " pts]");
            score += multiplier*-30;
        }

        // Puzzle 2
        System.out.println();

        System.out.println("\n--- Puzzle 2: The Colour Panel ---");
        System.out.print("Four buttons glow before you: RED, BLUE, GREEN, YELLOW.\n" +
            "The on that is neither a primary colour of light nor warm-toned is your key.\n" +
            "Enter your choice: ");
        String answerp2 = scanner.next();
        if (answerp2.equalsIgnoreCase("green")) {
            System.out.print("The panel hisses and slides open. [15 x " + (multiplier) + " = +" + (multiplier*15) + " pts]");
            score += multiplier*15;
        }
        else if (answerp2.equalsIgnoreCase("red") || answerp2.equalsIgnoreCase("yellow")) {
            System.out.print("Too warm - you feel the heat of a wrong choice. [-15 x " + (multiplier) + " = -" + (multiplier*15) + " pts]");
            score += multiplier*-15;
        }
        else if (answerp2.equalsIgnoreCase("red")) {
            System.out.print("Primary, but not the one. [-10 x " + (multiplier) + " = -" + (multiplier*10) + " pts]");
            score += multiplier*-10;
        }
        else {
            System.out.print("That's not even on the panel. [-20 x " + (multiplier) + " = -" + (multiplier*20) + " pts]");
            score += multiplier*-20;
        }

        // Puzzle 3
        System.out.println();

        System.out.println("\n--- Puzzle 3: The Year Vault ---");
        System.out.print("The vault is engraved with a year.\n"+
            "I am the year Concordia University was founded. What year am I? Enter it: ");
        int answerp3 = scanner.nextInt();
        if (answerp3 == 1974) {
            System.out.print("The vault swings open - you're free! [20 x " + (multiplier) + " = +" + (multiplier*20) + " pts]");
            score += multiplier*20;
        }
        else if ((answerp3 - 1974 <= 5) && (answerp3 - 1974 >= -5)) {
            System.out.print("The vault hums but won't open. [-10 x " + (multiplier) + " = -" + (multiplier*10) + " pts]");
            score += multiplier*-10;
        }
        else if ((answerp3 - 1974 <= 10) && (answerp3 - 1974 >= -10)) {
            System.out.print("A wrong combination - alarms flicker [-20 x " + (multiplier) + " = -" + (multiplier*20) + " pts]");
            score += multiplier*-20;
        }
        else {
            System.out.print("BOOM! The vault locks permanently. [-35 x " + (multiplier) + " = -" + (multiplier*35) + " pts]");
            score += multiplier*-35;
        }

        // Tally
        System.out.println();

        System.out.println("\n------- Final Result for " + name + " -------\n" +
              "Difficulty:   " + difficulty);
        System.out.printf("Final score:  %.2f\n", score);
        System.out.print("Outcome:      ");

        if (score >= 100.0) {
            System.out.print("MASTER ESCAPIST - You solved everything perfectly!");
        }
        else if ((score >= 80.0) && (score < 110.0)) {
            System.out.print("ESCAPED - You made it out, a little roughed up.");
        }
        else if ((score >= 50.0) && (score < 80.0)) {
            System.out.print("BARELY OUT - You stumbled to freedom.");
        }
        else if (score < 50.0) {
            System.out.print("TRAPPED - The room has claimed another victim.");
        }

        // Saving the score
        System.out.println();
        
        System.out.print("\nWould you like to save your score to the Hall of Fame? (yes/no): ");
        String scoresave = scanner.next();
        if (scoresave.equalsIgnoreCase("yes")) System.out.printf("Your score of %.2f has been recorded. Glory awaits!\n", score);
        else System.out.printf("Maybe next time. Your score was %.2f.\n", score);

        // Goodbye
        System.out.println();

        System.out.print("Thanks for playing the COMP-248 Escape Room. See you next time!");

        scanner.close();
    }
}

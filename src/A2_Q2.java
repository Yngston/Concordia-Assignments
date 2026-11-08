//--------------------------------------------------------------
// Assignment 2
// Written by: Yusuf Salakhutdinov 40358553
// For COMP 248 P - Fall 2026
//--------------------------------------------------------------
// Algorithm 2: ARTM Transit Fare Calculator
//--------------------------------------------------------------

import java.util.Scanner;

public class A2_Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fixed variables, I just preemtively made them beforehand so I can plug and play later

        final double stA = 3.75;
        final double stAB = 5.00;
        final double stABC = 7.00;
        final double stABCD = 9.50;

        final double mpA = 104.50;
        final double mpAB = 164.50;
        final double mpABC = 200.50;
        final double mpABCD = 275.50;

        final double rmpA = 62.75;
        final double rmpAB = 98.75;
        final double rmpABC = 120.25;
        final double rmpABCD = 165.25;

        // Welcome message, as always
        
        System.out.println("--------------------------------------------------");
        System.out.println("      Welcome to th ARTM Fare Calculator!");
        System.out.println("--------------------------------------------------");
        
        // Options for the user, the real beginning of the code where I make sure to use \n to properly space out the lines

        System.out.print("Please enter your name: ");
        String name = scanner.next();

        System.out.println("\nPlease choose your ticket type:\n\n"+
        "1. Single trip\n"+
        "2. 10-Trip Passage\n"+
        "3. Monthly Pass\n" +
        "4. Reduced Monthly Pass (ages 6-17, students 18+, ages 65+)\n"+
        "5. Exit");

        System.out.print("\nYour choice: ");
        int choice = scanner.nextInt();

        // Creating base activated variables to use throughout the code, silly names as easter eggs, they will never appear when the code runs

        String ticketType = "Gabriel";
        String zone = "Nathan";
        double price = 0;
        double unitprice = 0;
        int nbTrip = 0;
        int nbTenTripPacks = 0;
        int nbMonths = 0;
        int nbRedMonths = 0;

        // Single Trip

        if (choice == 1) {
            // at the beginning fo each choice, I set the ticketType variable to the correct
            // name so I can call upon it in the summary

            ticketType = "Single Pass";

            // to determine the prices according to the zone, in each choice which requires
            // I reset the unit price of the thing they're purchasing to the right zone
            // using the variables from the beginning

            System.out.print("\nPlease enter your zone(s): ");
            zone = scanner.next();

            if (zone.equalsIgnoreCase("a")) unitprice = stA;
            else if (zone.equalsIgnoreCase("ab")) unitprice = stAB;
            else if (zone.equalsIgnoreCase("abc")) unitprice = stABC;
            else unitprice = stABCD;

            // I used else instead of else if here because were assuming the user won't input
            // a wrong answer
            
            System.out.print("How many trips? ");
            nbTrip = scanner.nextInt();
            System.out.print("Are you making this trip today more than once? ");
            String answerTrip = scanner.next();
            if (answerTrip.equalsIgnoreCase("yes")) {
                System.out.print("How many trips? ");
                int nbReturnTrip = scanner.nextInt();
                nbTrip += nbReturnTrip;
            }
            price = nbTrip * unitprice;
        }

        // 10-Trip Package

        else if (choice == 2) {
            ticketType = "10-Trip Package";
            unitprice = 34.25;

            System.out.print("\nPlease enter your zone(s): ");
            zone = scanner.next();

            if (zone.equalsIgnoreCase("a")) {
                System.out.print("How many packages would you like? ");
                nbTenTripPacks = scanner.nextInt();
                price = nbTenTripPacks * unitprice;
            }
            else System.out.print("\nThe 10-Trip Package is only available for Zone A.");
        }

        // Monthly Pass

        else if (choice == 3) {
            ticketType = "Monthly Pass";

            System.out.print("\nPlease enter your zone(s): ");
            zone = scanner.next();

            if (zone.equalsIgnoreCase("a")) unitprice = mpA;
            else if (zone.equalsIgnoreCase("ab")) unitprice = mpAB;
            else if (zone.equalsIgnoreCase("abc")) unitprice = mpABC;
            else unitprice = mpABCD;
            
            System.out.print("How many months are you purchasing for? ");
            nbMonths = scanner.nextInt();
            price = nbMonths * unitprice;
        }

        // Reduced Monthly Pass

        else if (choice == 4) {
            ticketType = "Reduced Monthly Pass";

            System.out.print("\nPlease enter your zone(s): ");
            zone = scanner.next();

            if (zone.equalsIgnoreCase("a")) unitprice = rmpA;
            else if (zone.equalsIgnoreCase("ab")) unitprice = rmpAB;
            else if (zone.equalsIgnoreCase("abc")) unitprice = rmpABC;
            else unitprice = rmpABCD;
            
            System.out.print("How many months are you purchasing for? ");
            nbRedMonths = scanner.nextInt();
            price = nbRedMonths * unitprice;
        }

        // Exit

        else if (choice == 5) {
            System.out.print("\nThank you for using the ARTM Fare Calculator. Have a great trip!");
        }

        // Invalid selection
        
        else {
            System.out.print("\nInvalid selection. Please try again.");
        }

        // Purchase summary

        if (price > 0) {
            // The bulk of the summary is text and formatting
            // made sure to upper case he zone text they inputed so that it fits with the
            // aesthetics of the table I was given

            System.out.println("\n------- Purchase Summary for " + name + " -------");
            System.out.println("Ticket type: " + ticketType);
            System.out.println("Zone(s): " + zone.toUpperCase());
            System.out.printf("Unit price: $%.2f\n", unitprice);
            if (choice == 1) System.out.println("Quantity: " + nbTrip);
            else if (choice == 2) System.out.println("Quantity: " + nbTenTripPacks);
            else if (choice == 3) System.out.println("Quantity: " + nbMonths + " month(s)");
            else if (choice == 4) System.out.println("Quantity: " + nbRedMonths + " month(s)");
            System.out.printf("Subtotal: $%.2f\n", price);
            if (nbMonths >= 3) {
                double loyaltyDiscount = price*-0.05;
                System.out.printf("Loyalty discount (5%%): $%.2f\n", loyaltyDiscount);
                price -= price*0.05;
            }
            System.out.println("-------------------------------------");
            System.out.printf("Total: $%.2f\n", price);

            System.out.print("\nThank you for using the ARTM Fare Calculator. Have a great trip!");
        }
        
        scanner.close();
    }
}

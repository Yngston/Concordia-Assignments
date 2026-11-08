//--------------------------------------------------------------
// Assignment 1
// Written by: Yusuf Salakhutdinov 40358553
// For COMP 248 P - Fall 2026
//--------------------------------------------------------------
// Algorithm 2: Vending Machine Change Calculator
//--------------------------------------------------------------

import java.util.Scanner;

public class A1_Q2 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner(System.in);
        final int TOONIE = 200;
        final int LOONIE = 100;
        final int QUARTER = 25;
        final int DIME = 10;
        final int NICKEL = 5;
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("      Welcome to the Vending Machine");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("Please enter the amount of inserted in cents: ");
        int insert = scanner.nextInt();
        System.out.print("Please enter the price of the item selected in cents: ");
        int price = scanner.nextInt();
        // Calculating the change
        int change = insert - price;
        // Using Math.ceil() to round the numbers and then reformatting to integers
        int toonieCt = change/TOONIE;
        change = change - TOONIE*toonieCt;
        int loonieCt = change/LOONIE;
        change = change - LOONIE*loonieCt;
        int quarterCt = change/QUARTER;
        change = change - QUARTER*quarterCt;
        int dimeCt = change/DIME;
        change = change - DIME*dimeCt;
        // This took wayyy too long to figure out that I need to (double) the NICKEL
        int nickelCt = (int) Math.ceil(change/ (double) NICKEL);
        System.out.println("Denomination returned:");
        System.out.println("    toonies x " + toonieCt);
        System.out.println("    loonies x " + loonieCt);
        System.out.println("    quarters x " + quarterCt);
        System.out.println("    dimes x " + dimeCt);
        System.out.println("    nickels x " + nickelCt);
        System.out.println("Thank you for using the Vending Machine!");
        scanner.close();
    }
}

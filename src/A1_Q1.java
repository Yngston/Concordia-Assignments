//--------------------------------------------------------------
// Assignment 1
// Written by: Yusuf Salakhutdinov 40358553
// For COMP 248 P - Fall 2026
//--------------------------------------------------------------
// Algorithm 1: Calories Burned Claculator
//--------------------------------------------------------------

import java.util.Scanner;

public class A1_Q1 {
    public static void main (String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("  Welcome to the Calories Burned Calculator");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("Enter the weight in pound of the three individuals?");
        int w1 = scanner.nextInt();
        int w2 = scanner.nextInt();
        int w3 = scanner.nextInt();
        // I found a way online to round the digits, 
        // instead of putting it all in the print statement I made them variables
        double calRun = Math.round((0.0175*10*(w1/2.2)*30)*100.0)/100.0;
        double calBall = Math.round((0.0175*8*(w2/2.2)*60)*100.0)/100.0;
        double calZzz = Math.round((0.0175*1*(w3/2.2)*360)*100.0)/100.0;
        System.out.println("A " + w1 + "LB person burned an estimated " + calRun + " calories by Running");
        System.out.println("A " + w2 + "LB person burned an estimated " + calBall + " calories by playing Basketball");
        System.out.println("A " + w3 + "LB person burned an estimated " + calZzz + " calories by Sleeping");
        System.out.println("Thank you for using the Calories Burned Calculator!");
        scanner.close();
    }
}
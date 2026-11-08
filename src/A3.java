//--------------------------------------------------------------
// Assignment 2
// Written by: Yusuf Salakhutdinov 40358553
// For COMP 248 P - Fall 2026
//--------------------------------------------------------------
// Algorithm 2: ARTM Transit Fare Calculator
//--------------------------------------------------------------

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables
        
        int choice = 0;
        String firstName = "";
        String lastName = "";
        String relationship = "";
        String address = "";
        String city = "";
        String postalCode = "";
        String phoneNumber = "";

        String newfristName = "";
        String newlastName = "";
        int yearBirth = 0;
        int monthBirth = 0;
        int dayBirth = 0;
        String gender = "";
        int height = 0;
        String newAddress = "";
        String newCity = "";
        String newPostalCode = "";
        String newPhoneNumber = "";


        // Wecloming message
        System.out.println("          Welcome to the Montreal Youth Basketball Club (MYBC) Registration System");
        System.out.println("____________________________________________________________________________________________");


        // Beginning of the prompts

        // Names
        boolean operation = true;

        while (operation) {
            System.out.print("\nPlease Enter Your Family Member's First Name and Last Name: ");
            firstName = scanner.next();
            lastName = scanner.next();
            if ((firstName.length()<2)||(lastName.length()<2)) {
                System.out.println("Invalid first name or last name: " + firstName + " " + lastName);
                System.out.println("First Name and Last Name should have at least two characters.\n");
            }
            else {
                operation = false;
            }
        }
        
        // Relationship

        operation = true;

        while (operation) {
            System.out.print("\nPlease Enter the Relationship Between the Family Member and the New Club Member: \n"+
                "1 - Father\n" +
                "2 - Mother\n" +
                "3 - Grandfather\n" +
                "4 - Grandmother\n" +
                "5 - Tutor\n" +
                "6 - Partner\n" +
                "7 - Friend\n" +
                "8 - Other\n\n" +
                "Please enter your choice: ");
            choice = scanner.nextInt();
            if ((choice<1) || (choice>8)) {
                System.out.println("Invalid relationship: " + choice +
                    "\nValid Relationship Between 1 and 8\n"
                );
            }
            else {
                switch (choice) {
                    case 1:
                        relationship = "Father";
                    case 2: 
                        relationship = "Mother";
                    case 3:
                        relationship = "Grandfather";
                    case 4:
                        relationship = "Grandmother";
                    case 5:
                        relationship = "Tutor";
                    case 6:
                        relationship = "Partner";
                    case 7:
                        relationship = "Friend";
                    case 8:
                        relationship = "Other";
                }
                operation = false;
            }
        }
        
        // Address

        System.out.print("\nPlease Enter Your Address: ");
        scanner.nextLine();
        address = scanner.nextLine();

        System.out.print("\nPlease Enter Your City: ");
        city = scanner.nextLine();

        operation = true;

        while (operation) {
            System.out.print("\nPlease Enter Your Postal Code: ");
            postalCode = scanner.next();
            if ((postalCode.length()<6)||(postalCode.length()>6)) {
                System.out.println("Invalid Postal Code: " + postalCode +
                    "\nPostal Code should have six characters.");
            }
            else {
                operation = false;
            }
        }

        // Phone number

        scanner.nextLine();
        operation = true;

        while (operation) {
            System.out.print("\nPlease Enter Your Phone Number: ");
            String tempphoneNumber = scanner.nextLine();
            phoneNumber = tempphoneNumber.replaceAll("[^0-9]","");
            if (phoneNumber.length() < 10) {
                System.out.println("Invalid Phone Number: " + phoneNumber +
                    "\nValid Phone Number contains at least 10 digits.");
            }
            else {
                operation = false;
            }
        }

        // New Member

        operation = true;

        while (operation) {
            System.out.print("\nPlease Enter the New Club Member's First Name and Last Name: ");
            firstName = scanner.next();
            lastName = scanner.next();
            if ((firstName.length()<2)||(lastName.length()<2)) {
                System.out.println("Invalid first name or last name: " + firstName + " " + lastName);
                System.out.println("First Name and Last Name should have at least two characters.\n");
            }
            else {
                operation = false;
            }
        }

        // Year of birth 

        operation = true;

        while (operation) {
            System.out.print("\nPlease Enter the Year of Birth Between (2008 and 2020): ");
            yearBirth = scanner.nextInt();
            if ((yearBirth < 2008) || (yearBirth > 2020)) {
                System.out.print("Invalid year of birth: " + yearBirth +
                    "\nValid year of birth between 2008 and 2020.");
                
            }
        }



    }
}

//--------------------------------------------------------------
// Assignment 3
// Written by: Yusuf Salakhutdinov 40358553
// For COMP 248 P - Fall 2026
//--------------------------------------------------------------
// Assignment 3: Montreal Youth Basketball Club Registration System

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Constants
        final int MAX_MEMBERS = 20;
        final double PERIOD_COST = 100.0;

        // One array per piece of info, same index = same registration
        String[] familyFirstNames = new String[MAX_MEMBERS];
        String[] familyLastNames = new String[MAX_MEMBERS];
        String[] relationships = new String[MAX_MEMBERS];
        String[] familyAddresses = new String[MAX_MEMBERS];
        String[] familyCities = new String[MAX_MEMBERS];
        String[] familyPostalCodes = new String[MAX_MEMBERS];
        String[] familyPhoneNumbers = new String[MAX_MEMBERS];

        String[] memberFirstNames = new String[MAX_MEMBERS];
        String[] memberLastNames = new String[MAX_MEMBERS];
        int[] memberYears = new int[MAX_MEMBERS];
        int[] memberMonths = new int[MAX_MEMBERS];
        int[] memberDays = new int[MAX_MEMBERS];
        String[] memberGenders = new String[MAX_MEMBERS];
        double[] memberHeights = new double[MAX_MEMBERS];
        String[] memberAddresses = new String[MAX_MEMBERS];
        String[] memberCities = new String[MAX_MEMBERS];
        String[] memberPostalCodes = new String[MAX_MEMBERS];
        String[] memberPhoneNumbers = new String[MAX_MEMBERS];

        int[] registrationNumbers = new int[MAX_MEMBERS];

        // true if the member is registered in that period (index 0 = period 1)
        boolean[][] registeredPeriods = new boolean[MAX_MEMBERS][3];

        // Makes it quicker to print later
        String[] periodNames = {
            "Period 1: Jun 7 Jul 2",
            "Period 2: Jul 5 Jul 30",
            "Period 3: Aug 2 Aug 27"
        };

        // Temporary variables for the inputs
        int choice = 0;
        String firstName = "";
        String lastName = "";
        String relationship = "";
        String address = "";
        String city = "";
        String postalCode = "";
        String phoneNumber = "";

        String newFirstName = "";
        String newLastName = "";
        int yearBirth = 0;
        int monthBirth = 0;
        int dayBirth = 0;
        String gender = "";
        double height = 0;
        String newAddress = "";
        String newCity = "";
        String newPostalCode = "";
        String newPhoneNumber = "";

        String answer = "";
        int count = 0;              // how many members are registered so far
        boolean addMore = true;
        boolean operation = true;   // used to repeat the validation loops
        boolean cancelled = false;  // true if the year was bad and the user quit out of the program

        // Welcome message
        System.out.println("_________________________________________________________________________________");
        System.out.println("     Welcome to Montreal Youth Basketball Club (MYBC) Registration System");
        System.out.println("_________________________________________________________________________________");

        // Each time through this loop registers one family member and one child
        while (addMore && count < MAX_MEMBERS) {

            cancelled = false;

            // Family member's name
            operation = true;
            while (operation) {
                System.out.print("Please Enter Your family Member's First Name and Last Name: ");
                firstName = scanner.next();
                lastName = scanner.next();
                scanner.nextLine();
                if ((firstName.length() < 2) || (lastName.length() < 2)) {
                    System.out.println("Invalid first name or last name: " + firstName + " " + lastName);
                    System.out.println("First Name and Last Name should have at least two characters.");
                }
                else {
                    operation = false;
                }
            }

            // Relationship
            operation = true;
            while (operation) {
                System.out.print("Please Enter the Relationship between the family member and the new club member: \n" +
                    " 1 - Father\n" +
                    " 2 - Mother\n" +
                    " 3 - GrandFather\n" +
                    " 4 - GrandMother\n" +
                    " 5 - Tutor\n" +
                    " 6 - Partner\n" +
                    " 7 - Friend\n" +
                    " 8 - Other\n" +
                    "Please Enter your choice (1-8): ");
                choice = scanner.nextInt();
                scanner.nextLine();
                if ((choice < 1) || (choice > 8)) {
                    System.out.println("Invalid Relationship: " + choice);
                    System.out.println("Valid Relationship between 1 and 8");
                }
                else {
                    // break is needed in each case or it keeps running the next ones
                    switch (choice) {
                        case 1:
                            relationship = "Father";
                            break;
                        case 2:
                            relationship = "Mother";
                            break;
                        case 3:
                            relationship = "GrandFather";
                            break;
                        case 4:
                            relationship = "GrandMother";
                            break;
                        case 5:
                            relationship = "Tutor";
                            break;
                        case 6:
                            relationship = "Partner";
                            break;
                        case 7:
                            relationship = "Friend";
                            break;
                        case 8:
                            relationship = "Other";
                            break;
                    }
                    operation = false;
                }
            }

            // Family member's address and city
            System.out.print("Please Enter Your Address: ");
            address = scanner.nextLine();

            System.out.print("Please Enter Your City: ");
            city = scanner.nextLine();

            // Postal code must have 6 characters
            operation = true;
            while (operation) {
                System.out.print("Please Enter Your Postal Code: ");
                postalCode = scanner.next();
                scanner.nextLine();
                if (postalCode.length() != 6) {
                    System.out.println("Invalid Postal Code: " + postalCode);
                    System.out.println("Postal Code should have six characters.");
                }
                else {
                    operation = false;
                }
            }

            // Phone number, only the digits are counted (dashes and spaces are ignored)
            operation = true;
            while (operation) {
                System.out.print("Please Enter Your Phone Number: ");
                phoneNumber = scanner.nextLine();
                String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");
                if (digitsOnly.length() < 10) {
                    System.out.println("Invalid Phone Number: " + phoneNumber);
                    System.out.println("Valid Phone Number contains at least 10 digits.");
                }
                else {
                    operation = false;
                }
            }

            // New member's name
            operation = true;
            while (operation) {
                System.out.print("Please Enter the new club Member's First Name and Last Name: ");
                newFirstName = scanner.next();
                newLastName = scanner.next();
                scanner.nextLine();
                if ((newFirstName.length() < 2) || (newLastName.length() < 2)) {
                    System.out.println("Invalid first name or last name: " + newFirstName + " " + newLastName);
                    System.out.println("First Name and Last Name should have at least two characters.");
                }
                else {
                    operation = false;
                }
            }

            // Year of birth, if it's bad the user can try again or quit
            operation = true;
            while (operation) {
                System.out.print("Please Enter the Year Of Birth between (2008 and 2020): ");
                yearBirth = scanner.nextInt();
                scanner.nextLine();
                if ((yearBirth < 2008) || (yearBirth > 2020)) {
                    System.out.println("Invalid Year Of Birth: " + yearBirth);
                    System.out.println("Valid Year Of Birth between 2008 and 2020");

                    // keep asking until it's yes or no
                    answer = "";
                    while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                        System.out.print("Do you wish to continue (yes/no) ? ");
                        answer = scanner.next();
                        scanner.nextLine();
                    }

                    if (answer.equalsIgnoreCase("no")) {
                        System.out.println("Sorry, There is no membership for your child's age.");
                        cancelled = true;
                        operation = false;
                    }
                }
                else {
                    operation = false;
                }
            }

            // Only continue if the user didn't quit
            if (!cancelled) {

                // Month of birth
                operation = true;
                while (operation) {
                    System.out.print("Please Enter the Month Of Birth (1 - 12): ");
                    monthBirth = scanner.nextInt();
                    scanner.nextLine();
                    if ((monthBirth < 1) || (monthBirth > 12)) {
                        System.out.println("Invalid Month Of Birth: " + monthBirth);
                        System.out.println("Valid Month Of Birth between 1 and 12");
                    }
                    else {
                        operation = false;
                    }
                }

                // Day of birth
                operation = true;
                while (operation) {
                    System.out.print("Please Enter the Day Of Birth (1 - 31): ");
                    dayBirth = scanner.nextInt();
                    scanner.nextLine();
                    if ((dayBirth < 1) || (dayBirth > 31)) {
                        System.out.println("Invalid Day Of Birth: " + dayBirth);
                        System.out.println("Valid Day Of Birth between 1 and 31");
                    }
                    else {
                        operation = false;
                    }
                }

                // Gender, accepts m or M and f or F
                operation = true;
                while (operation) {
                    System.out.print("Please Enter the Gender Of the new club member (M/F): ");
                    gender = scanner.next();
                    scanner.nextLine();
                    if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
                        gender = gender.toUpperCase();
                        operation = false;
                    }
                    else {
                        System.out.println("Invalid Gender: " + gender);
                        System.out.println("Valid Gender is M or F");
                    }
                }

                // Height
                operation = true;
                while (operation) {
                    System.out.print("Please Enter the Height in inches Of the new club member (35-120): ");
                    height = scanner.nextDouble();
                    scanner.nextLine();
                    if ((height < 35) || (height > 120)) {
                        System.out.println("Invalid Height: " + height);
                        System.out.println("Valid Height between 35 and 120 inches");
                    }
                    else {
                        operation = false;
                    }
                }

                // New member's address and city
                System.out.print("Please Enter new club member's Address: ");
                newAddress = scanner.nextLine();

                System.out.print("Please Enter new club member's City: ");
                newCity = scanner.nextLine();

                // New member's postal code
                operation = true;
                while (operation) {
                    System.out.print("Please Enter new club member's Postal Code: ");
                    newPostalCode = scanner.next();
                    scanner.nextLine();
                    if (newPostalCode.length() != 6) {
                        System.out.println("Invalid Postal Code: " + newPostalCode);
                        System.out.println("Postal Code should have six characters.");
                    }
                    else {
                        operation = false;
                    }
                }

                // New member's phone number
                operation = true;
                while (operation) {
                    System.out.print("Please Enter new club member's Phone Number: ");
                    newPhoneNumber = scanner.nextLine();
                    String digitsOnly = newPhoneNumber.replaceAll("[^0-9]", "");
                    if (digitsOnly.length() < 10) {
                        System.out.println("Invalid Phone Number: " + newPhoneNumber);
                        System.out.println("Valid Phone Number contains at least 10 digits.");
                    }
                    else {
                        operation = false;
                    }
                }

                // Random 4 digit registration number, redo it if someone already has it
                int registrationNumber = 0;
                boolean duplicate = true;
                while (duplicate) {
                    registrationNumber = (int) (Math.random() * 9000) + 1000;
                    duplicate = false;
                    for (int i = 0; i < count; i++) {
                        if (registrationNumbers[i] == registrationNumber) {
                            duplicate = true;
                        }
                    }
                }

                // Summer 2027 tournaments, up to 3 periods
                int periodsChosen = 0;
                operation = true;
                while (operation && periodsChosen < 3) {
                    System.out.println("Summer of 2027 Tournaments Registration");
                    System.out.println("_______________________________________");

                    answer = "";
                    while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                        System.out.print("Do you wish to Register " + newFirstName + " with Summer Registration (yes/no) ? ");
                        answer = scanner.next();
                        scanner.nextLine();
                    }

                    if (answer.equalsIgnoreCase("yes")) {
                        // show only the periods that are still free
                        System.out.println("Periods Available to register your child:");
                        for (int p = 0; p < 3; p++) {
                            if (!registeredPeriods[count][p]) {
                                System.out.println(" " + (p + 1) + " - " + periodNames[p]);
                            }
                        }

                        boolean validPeriod = false;
                        while (!validPeriod) {
                            System.out.print("Please Enter your choice: ");
                            choice = scanner.nextInt();
                            scanner.nextLine();
                            if ((choice < 1) || (choice > 3)) {
                                System.out.println("Invalid Period: " + choice);
                                System.out.println("Valid Period between 1 and 3");
                            }
                            else if (registeredPeriods[count][choice - 1]) {
                                System.out.println("Invalid Period: " + newFirstName +
                                    " is already registered in Period " + choice);
                            }
                            else {
                                registeredPeriods[count][choice - 1] = true;
                                periodsChosen++;
                                validPeriod = true;
                            }
                        }
                    }
                    else {
                        operation = false;
                    }
                }

                // Show what they registered for and the cost
                if (periodsChosen == 0) {
                    System.out.println(newFirstName + " " + newLastName +
                        " do not have any Summer 2027 Tournament registration.");
                }
                else {
                    System.out.println(newFirstName + " " + newLastName +
                        " is successfully registered in the following 2027 Summer Tournaments:");
                    for (int p = 0; p < 3; p++) {
                        if (registeredPeriods[count][p]) {
                            System.out.println(periodNames[p]);
                        }
                    }
                    System.out.println("The total Cost of the tournaments registrations is: " +
                        (periodsChosen * PERIOD_COST) + " $");
                }

                // Save everything in the arrays
                familyFirstNames[count] = firstName;
                familyLastNames[count] = lastName;
                relationships[count] = relationship;
                familyAddresses[count] = address;
                familyCities[count] = city;
                familyPostalCodes[count] = postalCode;
                familyPhoneNumbers[count] = phoneNumber;

                memberFirstNames[count] = newFirstName;
                memberLastNames[count] = newLastName;
                memberYears[count] = yearBirth;
                memberMonths[count] = monthBirth;
                memberDays[count] = dayBirth;
                memberGenders[count] = gender;
                memberHeights[count] = height;
                memberAddresses[count] = newAddress;
                memberCities[count] = newCity;
                memberPostalCodes[count] = newPostalCode;
                memberPhoneNumbers[count] = newPhoneNumber;
                registrationNumbers[count] = registrationNumber;

                count++;
            }

            // Ask to add more (the while condition stops it at 20 members)
            if (cancelled) {
                System.out.println("____________________________________________");
            }
            answer = "";
            while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no")) {
                System.out.print("Do you wish to add more members to the club (yes/no) ? ");
                answer = scanner.next();
                scanner.nextLine();
            }
            if (answer.equalsIgnoreCase("no")) {
                addMore = false;
            }
        }

        // Show all the registrations
        System.out.println("-----------------------------------------------------------");
        System.out.println("Montreal Youth Basketball Club (MYBC) have " + count + " New Registrations:");
        System.out.println("-----------------------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.println("___________________________________________");
            System.out.println("New Club Member " + (i + 1) + " Registration Details.");
            System.out.println("____________________________________________");
            System.out.println(familyFirstNames[i] + " " + familyLastNames[i] + " " + relationships[i] +
                " of the new MYBC club member");
            System.out.println(memberFirstNames[i] + " " + memberLastNames[i] +
                " with new MYBC club membership # " + registrationNumbers[i]);
            System.out.println("Lives at: " + familyAddresses[i] + " in the city of " + familyCities[i] +
                " with postal code " + familyPostalCodes[i]);
            System.out.println("Has the following Telephone Number: " + familyPhoneNumbers[i]);
            System.out.println("The new club member " + memberFirstNames[i] + " " + memberLastNames[i] +
                " who lives at: " + memberAddresses[i] + " in the city of " + memberCities[i] +
                " with postal code " + memberPostalCodes[i]);
            System.out.println("Has the following Telephone Number: " + memberPhoneNumbers[i] +
                " who has " + memberHeights[i] + " Inches height is successfully added to the MYBC " +
                (memberGenders[i].equals("M") ? "Boys" : "Girls") + " teams.");
            System.out.println("Born on (year/month/day): " + memberYears[i] + "/" + memberMonths[i] + "/" + memberDays[i]);
        }

        // Question 2: sort by height, shortest first
        // I sort an array of indexes so the other arrays stay untouched (bubble sort)
        int[] order = new int[count];
        for (int i = 0; i < count; i++) {
            order[i] = i;
        }

        for (int pass = 0; pass < count - 1; pass++) {
            for (int j = 0; j < count - 1 - pass; j++) {
                if (memberHeights[order[j]] > memberHeights[order[j + 1]]) {
                    int temp = order[j];
                    order[j] = order[j + 1];
                    order[j + 1] = temp;
                }
            }
        }

        System.out.println("Following is the list of the new Members:");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.println(memberFirstNames[order[i]] + " " + memberLastNames[order[i]] + " " +
                memberHeights[order[i]] + " inches");
        }

        // Closing message
        System.out.println("____________________________________________");
        System.out.println("Thank you for using our Registration System");
        System.out.println("____________________________________________");

        scanner.close();
    }
}
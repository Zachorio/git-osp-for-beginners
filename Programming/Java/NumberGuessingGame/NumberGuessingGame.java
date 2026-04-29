// NumberGuessingGame.java
// By: Zach Cowan
// For CSIS-312

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int numberToGuess = random.nextInt(100) + 1; // Picks a random number as the hidden number
        int userGuess = 0; // User guesses variable
        int attempts = 0; // User attempts variable

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100."); // Prompts the user to enter a number from 1-100

        while (userGuess != numberToGuess) { // Looks until the number is guessed

            System.out.print("Enter your guess: ");

            // Error checking: ensure input is an integer
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a whole number between 1 and 100.");
                scanner.next(); // discard invalid input
                continue;
            }

            userGuess = scanner.nextInt(); // Brings in the next user input as the user's guess
            attempts++; // Adds to the number of attempts

            // Error checking 
            if (userGuess < 1 || userGuess > 100) {
                System.out.println("Please enter a number between 1 and 100.");
                continue;
            }

            if (userGuess < numberToGuess) {
                System.out.println("Too low! Try again."); // Asks the user to guess higher
            } else if (userGuess > numberToGuess) {
                System.out.println("Too high! Try again."); // Asks the user to guess lower
            } else {
                System.out.println("Correct! You guessed it in " + attempts + " attempts."); // Announces message of success
            }
        }

        scanner.close(); // Closes the scanner
    }
}
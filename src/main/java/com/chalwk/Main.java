package com.chalwk;

import java.util.Random;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        int min = 0;
        int max = 1000;

        Random num = new Random();

        int answer = num.nextInt(max - min + 1) + min;
        int guesses = 10;

        System.out.println("Welcome to the guessing game!");
        System.out.println("Type \"hint\" for a hint or \"quit\" to quit the game.");
        System.out.println(" ");
        System.out.println("Enter your guess (" + min + "-" + max + "):");

        while (true) {

            String input = keyboard.nextLine();

            if (input.equals("quit")) {
                System.out.println("You have quit the game!");
                break;
            } else if (input.equals("hint")) {
                System.out.println("The answer is between " + (answer - 10) + " and " + (answer + 10) + " [Guesses: " + (guesses - 1) + "]");
            } else {

                int guess;
                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a number between 1 and 100!");
                    continue;
                }

                if (guess == answer) {
                    System.out.println("You guessed correctly!");
                    break;
                } else if (guess > answer) {
                    System.out.println("Guess too high! [Guesses: " + (guesses - 1) + "]");
                } else {
                    System.out.println("Guess too low! [Guesses: " + (guesses - 1) + "]");
                }

                guesses--;
                if (guesses == 0) {
                    System.out.println("GAME OVER - You have run out of guesses!");
                    break;
                }
            }
        }
    }
}

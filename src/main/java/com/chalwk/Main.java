package com.chalwk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final String RESET = "\033[0m";

    public static void main(String[] args) {
        while (true) {
            System.out.println("Select an operation to perform:");
            System.out.println("1. ADD (+)");
            System.out.println("2. SUBTRACT (-)");
            System.out.println("3. MULTIPLY (*)");
            System.out.println("4. DIVIDE (/)");
            System.out.println("5. SQUARE ROOT (sqrt)");
            System.out.println("6. Logarithm (base 10)");
            System.out.println("7. EXIT");

            String operationString = keyboard.nextLine();
            if ("7".equals(operationString)) {
                break;
            }

            int operation = Integer.parseInt(operationString);

            double num1, num2 = 0;
            try {
                sendMessage(Color.GREEN, "Enter first number: ");
                num1 = getNumericInput();
            } catch (NumberFormatException e) {
                sendMessage(Color.RED, "Invalid first number. Please enter a valid number.");
                continue;
            }

            if (operation != 5 && operation != 6) {
                try {
                    sendMessage(Color.GREEN, "Enter second number: ");
                    num2 = getNumericInput();
                } catch (NumberFormatException e) {
                    sendMessage(Color.RED, "Invalid second number. Please enter a valid number.");
                    continue;
                }
            }

            switch (operation) {
                case 1:
                    sendMessage(Color.GREEN, "The sum is: " + (num1 + num2));
                    break;
                case 2:
                    sendMessage(Color.GREEN, "The difference is: " + (num1 - num2));
                    break;
                case 3:
                    sendMessage(Color.GREEN, "The product is: " + (num1 * num2));
                    break;
                case 4:
                    if (num2 == 0) {
                        sendMessage(Color.RED, "Error! Division by zero is not allowed");
                    } else {
                        sendMessage(Color.GREEN, "The quotient is: " + (num1 / num2));
                    }
                    break;
                case 5:
                    sendMessage(Color.GREEN, "The square root of " + num1 + " is: " + Math.sqrt(num1));
                    break;
                case 6:
                    sendMessage(Color.GREEN, "The logarithm (base 10) of " + num1 + " is: " + Math.log10(num1));
                    break;
                default:
                    sendMessage(Color.RED, "Invalid operation. Please select a valid operation.");
            }
        }
    }

    private static double getNumericInput() {
        return Double.parseDouble(keyboard.nextLine());
    }

    private static void sendMessage(Color color, String message) {
        System.out.println(color.getCode() + message + RESET);
    }

    private enum Color {
        RED("\033[31m"), GREEN("\033[32m"), YELLOW("\033[33m"), BLUE("\033[34m"), MAGENTA("\033[35m");

        private final String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
package org.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void printGreetings() {
        System.out.println("Welcome to Amazing Numbers!\n");
    }

    public static void printInstruction() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be printed;\n" +
                "- two natural numbers and properties to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.");
    }

    public static List<String> isPropertyValid(String[] userInput) {
        List<String> listOfIncompatible = new ArrayList<>();
        for (int i = 0; i < userInput.length; i++) {
            switch (userInput[i]) {
                case "EVEN":
                case "ODD":
                case "PALINDROMIC":
                case "GAPFUL":
                case "BUZZ":
                case "DUCK":
                case "SPY":
                case "SUNNY":
                case "SQUARE":
                case "JUMPING":
                case "HAPPY":
                case "SAD":
                case "-EVEN":
                case "-ODD":
                case "-PALINDROMIC":
                case "-GAPFUL":
                case "-BUZZ":
                case "-DUCK":
                case "-SPY":
                case "-SUNNY":
                case "-SQUARE":
                case "-JUMPING":
                case "-HAPPY":
                case "-SAD":
                    break;
                default:
                    listOfIncompatible.add(userInput[i]);
            }
        }
        return listOfIncompatible;
    }

    public static String[] containsMutual(String[] properties) {
        String[][] propertyPairs = new String[][]{{"ODD", "EVEN"}, {"DUCK", "SPY"}, {"SUNNY", "SQUARE"}, {"SAD", "HAPPY"},
                {"ODD", "-ODD"}, {"SPY", "-SPY"}, {"SUNNY", "-SUNNY"}, {"SAD", "-SAD"}, {"GAPFUL", "-GAPFUL"}, {"BUZZ", "-BUZZ"},
                {"EVEN", "-EVEN"}, {"DUCK", "-DUCK"}, {"SQUARE", "-SQUARE"}, {"HAPPY", "-HAPPY"}, {"PALINDROMIC", "-PALINDROMIC"},
                {"JUMPING", "-JUMPING"}, {"-ODD", "-EVEN"}};
        for (int i = 0; i < propertyPairs.length; i++) {
            int counter = 0;
            for (int j = 0; j < 2; j++) {
                String temp1 = "";
                for (String s : properties) {
                    if (s.equals(propertyPairs[i][j]) && !temp1.equals(s)) {
                        temp1 = s;
                        counter++;
                    }
                }
            }
            if (counter == 2) {
                return propertyPairs[i];
            }
        }
        return new String[0];
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        printGreetings();
        printInstruction();
        boolean stop = false;
        while (!stop) {
            System.out.println("\nEnter a request:");
            String input = scn.nextLine();
            input = input.toUpperCase();
            String[] inputNumsArray = input.split(" ");
            BigInteger firstNum = new BigInteger(inputNumsArray[0]);
            int secondNum = 0;
            if (input.equals("")) {
                printInstruction();
            } else if (firstNum.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
            } else if (firstNum.compareTo(BigInteger.ZERO) == 0) {
                System.out.println("\nGoodbye!");
                break;
                stop = true;
            } else {
                if (inputNumsArray.length == 1) {
                    CheckNumbers newCheck = new CheckNumbers(firstNum);
                    newCheck.checkOneNumber(firstNum);

                } else if (inputNumsArray.length == 2) {
                    secondNum = Integer.parseInt(inputNumsArray[1]);
                    if (secondNum < 0) {
                        System.out.println("The second parameter should be a natural number or zero.");
                    } else if (secondNum == 0) {
                        System.out.println("\nGoodbye!");
                        break;
                    } else {
                        CheckNumbers newCheck = new CheckNumbers(firstNum, secondNum);
                        newCheck.checkRangeOfNumbers(firstNum, secondNum);
                    }
                } else {
                    secondNum = Integer.parseInt(inputNumsArray[1]);
                    String[] properties = new String[inputNumsArray.length - 2];
                    for (int i = 0; i < properties.length; i++) {
                        properties[i] = inputNumsArray[i + 2];
                    }

                    if (secondNum < 0) {
                        System.out.println("The second parameter should be a natural number or zero.");
                    } else if (secondNum == 0) {
                        System.out.println("\nGoodbye!");
                        break;
                    } else if (isPropertyValid(properties).size() != 0) {
                        if (isPropertyValid(properties).size() == 1) {
                            System.out.println("The property " + isPropertyValid(properties) + " is wrong.\n" +
                                    "Available properties: \n[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n");
                        } else {
                            System.out.println("The properties " + isPropertyValid(properties) + " are wrong.\n" +
                                    "Available properties: \n[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]\n");
                        }
                    } else if (containsMutual(properties).length != 0) {
                        System.out.println("The request contains mutually exclusive properties: " + Arrays.toString(containsMutual(properties)) + "\n" +
                                "There are no numbers with these properties.");
                    } else {
                        CheckNumbers newCheck = new CheckNumbers(firstNum, secondNum, properties);
                        newCheck.checkAllProperties(firstNum, secondNum, properties);
                    }
                }
            }
        }
    }
}

package org.example;

import java.util.Scanner;

public class SourceCode {

    private static int waterInTankMl = 400;
    private static int milkInTankMl = 540;
    private static int coffeeInTankGr = 120;
    private static int disposableCups = 9;
    private static int moneyInside = 550;

    public static void makeEspresso() {
        if (waterInTankMl < 250) {
            System.out.println("Sorry, not enough water");
        } else if (coffeeInTankGr < 16) {
            System.out.println("Sorry, not enough coffee");
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough cups");
        } else {
            waterInTankMl -= 250;
            coffeeInTankGr -= 16;
            disposableCups --;
            moneyInside += 4;
        }
    }

    public static void makeLatte() {
        if (waterInTankMl < 350) {
            System.out.println("Sorry, not enough water");
        } else if (milkInTankMl < 75) {
            System.out.println("Sorry, not enough milk");
        } else if (coffeeInTankGr < 20) {
            System.out.println("Sorry, not enough coffee");
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough cups");
        } else {
            waterInTankMl -= 350;
            milkInTankMl -= 75;
            coffeeInTankGr -= 20;
            disposableCups--;
            moneyInside += 7;
        }
    }

    public static void makeCappuccino() {
        if (waterInTankMl < 200) {
            System.out.println("Sorry, not enough water");
        } else if (milkInTankMl < 100) {
            System.out.println("Sorry, not enough milk");
        } else if (coffeeInTankGr < 12) {
            System.out.println("Sorry, not enough coffee");
        } else if (disposableCups < 1) {
            System.out.println("Sorry, not enough cups");
        } else {
            waterInTankMl -= 200;
            milkInTankMl -= 100;
            coffeeInTankGr -= 12;
            disposableCups--;
            moneyInside += 6;
        }
    }

    public static void showStats() {
        System.out.printf("The coffee machine has: %n" +
                "%d ml of water %n" +
                "%d ml of milk %n" +
                "%d g of coffee beans %n" +
                "%d disposable cups %n" +
                "$%d of money %n", waterInTankMl, milkInTankMl, coffeeInTankGr, disposableCups, moneyInside);
        System.out.println();
    }

    public static void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffee = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int addCups = scanner.nextInt();

        waterInTankMl += addWater;
        milkInTankMl += addMilk;
        coffeeInTankGr += addCoffee;
        disposableCups += addCups;

        System.out.println();
    }

    public static void takeMoney() {
        System.out.printf("I gave you $%d", moneyInside);
        moneyInside = 0;

        System.out.println();
    }

    public static void countIngredients() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int numOfCups;
        while (true) {
            if (scanner.hasNextInt()) {
                numOfCups = scanner.nextInt();
                if (numOfCups > 0) {
                    break;
                } else {
                    System.out.println("Input must be a number greater than 0!");
                }
            } else {
                System.out.println("Enter a number!");
            }
        }

        int waterInMl = 200;
        int milkInMl = 50;
        int coffeeInGrams = 15;
        System.out.printf("For %d cups of coffee you will need:%n" +
                "%d ml of water%n" +
                "%d ml of milk%n" +
                "%d g of coffee beans", numOfCups, waterInMl * numOfCups, milkInMl * numOfCups, coffeeInGrams * numOfCups);
    }

    public static void estimateNumOfCups() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterStorageInMl = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkStorageInMl = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeStorageInG = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int numOfCups = scanner.nextInt();

        int waterInMl = 200;
        int milkInMl = 50;
        int coffeeInGrams = 15;

        int cupsFromWater = waterStorageInMl / waterInMl; // 1
        int cupsFromMilk = milkStorageInMl / milkInMl; // 1
        int cupsFromCoffee = coffeeStorageInG / coffeeInGrams; // 6
        int leastAmountOfCups;
        if (cupsFromWater <= cupsFromMilk && cupsFromWater <= cupsFromCoffee) {
            leastAmountOfCups = cupsFromWater;
        } else if (cupsFromMilk <= cupsFromWater && cupsFromMilk <= cupsFromCoffee) {
            leastAmountOfCups = cupsFromMilk;
        } else {
            leastAmountOfCups = cupsFromCoffee;
        }

        int additionalWater = cupsFromWater - numOfCups; // 0
        int additionalMilk = cupsFromMilk - numOfCups; // 0
        int additionalCoffee = cupsFromCoffee - numOfCups; // 5
        int leastAdditional;
        if (additionalWater <= additionalMilk && additionalWater <= additionalCoffee) {
            leastAdditional = additionalWater;
        } else if (additionalMilk <= additionalWater && additionalMilk <= additionalCoffee) {
            leastAdditional = additionalMilk;
        } else {
            leastAdditional = additionalCoffee;
        }

        if (numOfCups > cupsFromWater || numOfCups > cupsFromMilk || numOfCups > cupsFromCoffee) {
            System.out.printf("No, I can make only %d cup(s) of coffee", leastAmountOfCups);
        } else if ((numOfCups <= cupsFromWater) && (numOfCups <= cupsFromMilk) && (numOfCups <= cupsFromCoffee) && leastAdditional == 0) {
            System.out.println("Yes, I can make that amount of coffee");
        } else {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", leastAdditional);
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                if (scanner.hasNextInt()){
                    int number = scanner.nextInt();
                    switch (number) {
                        case 1 -> makeEspresso();
                        case 2 -> makeLatte();
                        case 3 -> makeCappuccino();
                    }
                } else if (scanner.hasNext()) {
                    String inputStr = scanner.nextLine();
                }
            } else if (input.equals("fill")) {
                fillMachine();
            } else if (input.equals("take")) {
                takeMoney();
            } else if (input.equals("remaining")) {
                showStats();
            } else if (input.equals("exit")) {
                break;
            }
        }
    }
}
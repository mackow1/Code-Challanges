package org.example;

import java.util.Scanner;

public class CoffeeMachine {
    private int waterInTankMl;
    private int milkInTankMl;
    private int coffeeInTankGr;
    private int disposableCups;
    private int moneyInside;

    public CoffeeMachine(int waterInTankMl, int milkInTankMl, int coffeeInTankGr, int disposableCups, int moneyInside) {
        this.waterInTankMl = waterInTankMl;
        this.milkInTankMl = milkInTankMl;
        this.coffeeInTankGr = coffeeInTankGr;
        this.disposableCups = disposableCups;
        this.moneyInside = moneyInside;
    }

    public int getWaterInTankMl() {
        return waterInTankMl;
    }

    public void setWaterInTankMl(int waterInTankMl) {
        this.waterInTankMl = waterInTankMl;
    }

    public int getMilkInTankMl() {
        return milkInTankMl;
    }

    public void setMilkInTankMl(int milkInTankMl) {
        this.milkInTankMl = milkInTankMl;
    }

    public int getCoffeeInTankGr() {
        return coffeeInTankGr;
    }

    public void setCoffeeInTankGr(int coffeeInTankGr) {
        this.coffeeInTankGr = coffeeInTankGr;
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public void setDisposableCups(int disposableCups) {
        this.disposableCups = disposableCups;
    }

    public int getMoneyInside() {
        return moneyInside;
    }

    public void setMoneyInside(int moneyInside) {
        this.moneyInside = moneyInside;
    }

    public void machineAction(String userInput) {
        Scanner scanner = new Scanner(System.in);
        if (userInput.equals("buy")) {
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
        } else if (userInput.equals("fill")) {
            fillMachine();
        } else if (userInput.equals("take")) {
            takeMoney();
        } else if (userInput.equals("remaining")) {
            showStats();
        } else {
            System.out.println("Enter valid input!");
        }
    }

    public void makeEspresso() {
        if (this.waterInTankMl < 250) {
            System.out.println("Sorry, not enough water");
        } else if (this.coffeeInTankGr < 16) {
            System.out.println("Sorry, not enough coffee");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough cups");
        } else {
            this.waterInTankMl -= 250;
            this.coffeeInTankGr -= 16;
            this.disposableCups --;
            this.moneyInside += 4;
        }
    }

    public void makeLatte() {
        if (this.waterInTankMl < 350) {
            System.out.println("Sorry, not enough water");
        } else if (this.milkInTankMl < 75) {
            System.out.println("Sorry, not enough milk");
        } else if (this.coffeeInTankGr < 20) {
            System.out.println("Sorry, not enough coffee");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough cups");
        } else {
            this.waterInTankMl -= 350;
            this.milkInTankMl -= 75;
            this.coffeeInTankGr -= 20;
            this.disposableCups--;
            this.moneyInside += 7;
        }
    }

    public void makeCappuccino() {
        if (this.waterInTankMl < 200) {
            System.out.println("Sorry, not enough water");
        } else if (this.milkInTankMl < 100) {
            System.out.println("Sorry, not enough milk");
        } else if (this.coffeeInTankGr < 12) {
            System.out.println("Sorry, not enough coffee");
        } else if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough cups");
        } else {
            this.waterInTankMl -= 200;
            this.milkInTankMl -= 100;
            this.coffeeInTankGr -= 12;
            this.disposableCups--;
            this.moneyInside += 6;
        }
    }

    public void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        int addWater = scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int addMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        int addCoffee = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add: ");
        int addCups = scanner.nextInt();

        this.waterInTankMl += addWater;
        this.milkInTankMl += addMilk;
        this.coffeeInTankGr += addCoffee;
        this.disposableCups += addCups;

        System.out.println();
    }

    public void showStats() {
        System.out.printf("The coffee machine has: %n" +
                "%d ml of water %n" +
                "%d ml of milk %n" +
                "%d g of coffee beans %n" +
                "%d disposable cups %n" +
                "$%d of money %n", this.waterInTankMl, this.milkInTankMl, this.coffeeInTankGr, this.disposableCups, this.moneyInside);
        System.out.println();
    }

    public void takeMoney() {
        Scanner scanner = new Scanner(System.in);
        String password = "password";
        System.out.println("Enter a password!");
        String userInput = scanner.nextLine();

        int count = 3;
        while (!userInput.equals(password)) {
            count--;
            if (count <= 0) return;
            System.out.printf("Enter a valid password, %d attempts left! %n", count);
            userInput = scanner.nextLine();
        }
        System.out.printf("I gave you $%d %n", this.moneyInside);
        this.moneyInside = 0;
    }
}
// do sprawdzenia

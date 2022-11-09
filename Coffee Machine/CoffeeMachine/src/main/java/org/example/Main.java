package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);
        String userInput = null;
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            do {
                userInput = scanner.nextLine();
            } while (!userInput.equals("buy") && !userInput.equals("fill") && !userInput.equals("take") && !userInput.equals("remaining") && !userInput.equals("exit"));
            if (userInput.equals("exit")) break;
            machine.machineAction(userInput);
        }
    }
}
// do sprawdzenia

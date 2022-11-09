package org.example;

import java.util.Scanner;

public class Main {

    public static int totalTickets = 0;
    public static int currentIncome = 0;

    public static String[][] createCinemaRoom(int rows, int columns) {
        String[][] cinemaRoom = new String[rows + 1][columns + 1];

        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                if (i == 0) {
                    cinemaRoom[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    cinemaRoom[i][j] = String.valueOf(i);
                } else {
                    cinemaRoom[i][j] = "S";
                }
            }
        }
        cinemaRoom[0][0] = " ";
        return cinemaRoom;
    }

    public static void showTheSeats(String[][] cinemaRoom) {
        System.out.println("Cinema:");
        for (int i = 0; i < cinemaRoom.length; i++) {
            for (int j = 0; j < cinemaRoom[i].length; j++) {
                System.out.print(cinemaRoom[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void buyATicket(String[][] cinemaRoom, int rows, int columns) {
        Scanner scanner = new Scanner(System.in);
        int rowNumber;
        int columnNumber;
        int ticketCost;
        while (true) {
            System.out.println("Enter a row number:");
            if (scanner.hasNextInt()) {
                rowNumber = scanner.nextInt();
            } else {
                System.out.println("Wrong input");
                continue;
            }
            System.out.println("Enter a seat number in that row:");
            if (scanner.hasNextInt()) {
                columnNumber = scanner.nextInt();
            } else {
                System.out.println("Wrong input");
                continue;
            }
            if ((rowNumber >= 0 && rowNumber < cinemaRoom.length) && (columnNumber >= 0 && columnNumber < cinemaRoom[0].length)) {
                if ((cinemaRoom[rowNumber][columnNumber].equals("S"))) {
                    break;
                } else {
                    System.out.println("That ticket has already been purchased!");
                }
            } else {
                System.out.println("Wrong input!");
            }
        }

        if (rows * columns <= 60) {
            ticketCost = 10;
        } else {
            if (rowNumber <= rows / 2) {
                ticketCost = 10;
            } else {
                ticketCost = 8;
            }
        }

        System.out.print("Ticket price: ");
        System.out.println("$" + ticketCost);
        currentIncome += ticketCost;
        totalTickets++;

        cinemaRoom[rowNumber][columnNumber] = "B";
        System.out.println();
    }

    public static void showStats(String[][] cinemaRoom, int rows, int columns) {
        System.out.println("Number of purchased tickets: " + totalTickets);
        double percentage = (totalTickets / (double)((cinemaRoom.length - 1) * (cinemaRoom[0].length - 1))) * 100;
        System.out.printf("Percentage: %.2f%%%n", percentage);
        System.out.printf("Current income: $%d%n", currentIncome);

        int allSeatsIncome;
        if (rows * columns <= 60) {
            allSeatsIncome = (cinemaRoom.length - 1) * (cinemaRoom[0].length - 1) * 10;
        } else {
            int seatsFor10 = rows / 2 * columns;
            int seatsFor8 = (cinemaRoom.length - 1) * (cinemaRoom[0].length - 1) - seatsFor10;
            allSeatsIncome = seatsFor10 * 10 + seatsFor8 * 8;

        }
        System.out.printf("Total income: $%d%n", allSeatsIncome);
        System.out.println();
    }

    public static void main(String[] args) {
        int userChoice = 10;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();

        String[][] cinemaRoom = createCinemaRoom(rows, columns);

        while (userChoice != 0) {
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");

            if (scanner.hasNextInt()) userChoice = scanner.nextInt();
            switch (userChoice) {
                case 1 -> showTheSeats(cinemaRoom);
                case 2 -> buyATicket(cinemaRoom, rows, columns);
                case 3 -> showStats(cinemaRoom, rows, columns);
            }
        }
    }
}

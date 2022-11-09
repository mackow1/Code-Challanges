package org.example;

import java.util.Scanner;

public class Main {

    public static String checkRowsAndColumns(char[][] table) {

        int howManyX = 0;
        int howManyO = 0;

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 'X') {
                    howManyX++;
                } else if (table[i][j] == 'O') {
                    howManyO++;
                }
            }
        }

        if (Math.abs(howManyX - howManyO) > 1) return "Impossible";

        // Check cross

        if ((table[0][0] == 'X' && table[1][1] == 'X' && table[2][2] == 'X') || table[0][2] == 'X' && table[1][1] == 'X' && table[2][0] == 'X') return "X wins";
        if ((table[0][0] == 'O' && table[1][1] == 'O' && table[2][2] == 'O') || table[0][2] == 'O' && table[1][1] == 'O' && table[2][0] == 'O') return "O wins";

        // Check rows

        int rowX = 0;
        int rowO = 0;

        for (int i = 0; i < table.length; i++) {
            howManyX = 0;
            howManyO = 0;
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == 'X') {
                    howManyX++;
                } else if (table[i][j] == 'O') {
                    howManyO++;
                }
            }
            if (howManyX == 3) rowX++;
            if (howManyO == 3) rowO++;
        }

        if (rowX > 0 && rowO > 0) {
            return "Impossible";
        } else if (rowX > 0) {
            return "X wins";
        } else if (rowO > 0) {
            return "O wins";
        }

        // Check columns
        int columnX = 0;
        int columnO = 0;

        for (int o = 0; o < table[0].length; o++) {
            howManyX = 0;
            howManyO = 0;

            for (int i = 0; i < table.length; i++) {
                if (table[i][o] == 'X') {
                    howManyX++;
                } else if (table[i][o] == 'O') {
                    howManyO++;
                }
            }
            if (howManyO == 3) columnO++;
            if (howManyX == 3) columnX++;
        }

        if (columnX > 0 && columnO > 0) {
            return "Impossible";
        } else if (columnX > 0) {
            return "X wins";
        } else if (columnO > 0) {
            return "O wins";
        }

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == ' ') return "Game not finished";
            }
        }
        return "Draw";
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] ticTacToe = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

        for (int i = 0; i < ticTacToe.length; i++) {
            if (i == 0) System.out.println("---------");
            if (i == 0 || i == 1 || i == 2) System.out.print("|");
            for (int j = 0; j < ticTacToe[i].length; j++) {
                System.out.print(' ');
                System.out.print(' ');
            }
            if (i == 0 || i == 1 || i == 2) System.out.println(" |");
        }
        System.out.println("---------");

        System.out.println("Enter coordinates of the field! Valid numbers: 1, 2, 3");

        int row;
        int column;
        int counter = 1;
        char player;
        String result = "";

        while (true) {
            result = checkRowsAndColumns(ticTacToe);
            if ((result.equals("X wins")) || (result.equals("O wins")) || (result.equals("Draw"))) break;
            System.out.println(result);
            while (true) {
                if (counter % 2 == 1) {
                    System.out.println("player X");
                    player = 'X';
                    counter++;
                } else {
                    System.out.println("player O");
                    player = 'O';
                    counter++;
                }
                if (scanner.hasNextInt()) {
                    row = scanner.nextInt();
                    column = scanner.nextInt();
                    if ((row >= 1 && row <= 3) && (column >= 1 && column <= 3)) {
                        if (ticTacToe[row - 1][column - 1] == ' ') {
                            ticTacToe[row - 1][column - 1] = player;
                            break;
                        } else {
                            System.out.println("This cell is occupied! Choose another one!");
                            counter--;
                        }
                    } else {
                        System.out.println("Coordinates should be from 1 to 3!");
                        counter--;
                    }
                } else {
                    scanner.next();
                    System.out.println("You should enter numbers!");
                    counter--;
                }
            }

            for (int i = 0; i < ticTacToe.length; i++) {
                if (i == 0) System.out.println("---------");
                if (i == 0 || i == 1 || i == 2) System.out.print("|");
                for (int j = 0; j < ticTacToe[i].length; j++) {
                    System.out.print(" ");
                    System.out.print(ticTacToe[i][j]);
                }
                if (i == 0 || i == 1 || i == 2) System.out.println(" |");
            }
            System.out.println("---------");
        }
        System.out.println("Game finished, " + result);
    }
}

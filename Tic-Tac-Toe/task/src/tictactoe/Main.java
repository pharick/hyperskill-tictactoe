package tictactoe;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char[][] field = new char[3][3];

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';
            }
        }

        char c = 'X';
        boolean endGame = false;

        printField();

        while (!endGame) {
            boolean move = false;

            while (!move) {
                move = makeMove(c);
            }

            c = c == 'X' ? 'O' : 'X';

            printField();

            boolean winX = isWin('X');
            boolean winO = isWin('O');

            if (winX) {
                System.out.println("X wins");
                endGame = true;
            } else if (winO) {
                System.out.println("O wins");
                endGame = true;
            } else if (isFinished()) {
                System.out.println("Draw");
                endGame = true;
            }
        }
    }

    public static boolean makeMove(char c) {
        System.out.print("Enter the coordinates: ");

        if (!scanner.hasNextInt()) {
            System.out.println("You should enter numbers!");
            scanner.nextLine();
            return false;
        }

        int x = scanner.nextInt();

        if (x < 1 || x > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            scanner.nextLine();
            return false;
        }

        if (!scanner.hasNextInt()) {
            System.out.println("You should enter numbers!");
            scanner.nextLine();
            return false;
        }

        int y = scanner.nextInt();

        if (y < 1 || y > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            scanner.nextLine();
            return false;
        }

        if (field[3 - y][x - 1] != ' ') {
            System.out.println("This cell is occupied! Choose another one!");
            scanner.nextLine();
            return false;
        }

        field[3 - y][x - 1] = c;
        return true;
    }

    public static void printField() {
        System.out.println("---------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");

            for (int j = 0; j < 3; j++) {
                System.out.print(field[i][j] + " ");
            }

            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static boolean isWin(char c) {
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == c && field[i][1] == c && field[i][2] == c ||
                field[0][i] == c && field[1][i] == c && field[2][i] == c) {
                return true;
            }
        }

        return field[0][0] == c && field[1][1] == c && field[2][2] == c ||
                field[0][2] == c && field[1][1] == c && field[2][0] == c;
    }

    public static boolean isFinished() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public static int count(char c) {
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == c) {
                    count++;
                }
            }
        }

        return count;
    }
}

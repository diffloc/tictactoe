package tictactoe;

import java.util.Scanner;

public class Main {

    private static char[][] grid = new char[3][3];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        for (int i = 0; i < userInput.length(); i++) {
            grid[i / 3][i % 3] = userInput.charAt(i);
        }
        System.out.println("---------");
        for (char[] row : grid) {
            System.out.print("| ");
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        analyzeGame();
    }

    public static void analyzeGame() {
        char winner = getWinner();
        if (isImpossible() || winner == 'I') {
            System.out.println("Impossible");
        } else if (winner != 'N') {
            System.out.printf("%c wins", winner);
        } else if (!isFinished()) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }

    public static boolean isFinished() {
        for (char[] row: grid) {
            for (char c: row) {
                if (c == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    public static char getWinner() {
        int winCount = 0;
        char winner = 'N';

        // Check rows
        for (int row = 0; row < 3; row++) {
            if (grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2] && grid[row][0] != '_') {
                winner = grid[row][0];
                winCount++;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col] && grid[0][col] != '_') {
                winner = grid[0][col];
                winCount++;
            }
        }

        // Check diagonals
        if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '_') {
            winner = grid[0][0];
            winCount++;
        }
        if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != '_') {
            winner = grid[0][2];
            winCount++;
        }

        if (winCount > 1) {
            return 'I';
        }
        return winner;
    }

    public static boolean isImpossible() {
        int countX = 0;
        int countO = 0;
        for (char[] row: grid) {
            for (char c: row) {
                if (c == 'X') {
                    countX++;
                }
                if (c == 'O') {
                    countO++;
                }
            }
        }
        return countX >= countO + 2 || countO >= countX + 2;
    }
}
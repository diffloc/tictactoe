package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] grid = new char[3][3];
        String userInput = scanner.nextLine();

        for (int i = 0; i < userInput.length(); i++) {
            grid[i / 3][i % 3] = userInput.charAt(i);
        }

        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                System.out.println("---------");
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(grid[i][j] + " ");
                if (j == grid[i].length - 1) {
                    System.out.print("|");
                }
            }
            if (i == grid.length - 1) {
                System.out.println("\n---------");
            }
            System.out.println();
        }
    }
}

package tictactoe;

import java.util.Scanner;

public class UserInterface {

    private  final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        Game game = new Game();
        Player player1 = new Player("Player 1", 'X');
        Player player2 = new Player("Player 2", 'O');
        Player currentPlayer = player1;

        while (!game.isFull() && !game.hasWinner()) {
            System.out.println(game);
            System.out.println(currentPlayer.getName() + ", it's your move (row column): ");

            try {
                String input = getUserInput();
                String[] parts = input.split(" ");

                try {
                    int row = Integer.parseInt(parts[0]) - 1;
                    int col = Integer.parseInt(parts[1]) - 1;

                    if (game.getPlayerMove(row, col) != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }

                    game.setPlayerMove(row, col, currentPlayer.getSymbol());

                    if (game.hasWinner()) {
                        System.out.println(game);
                        System.out.println(currentPlayer.getSymbol() + " wins");
                        break;
                    }

                    if (game.isFull()) {
                        System.out.println(game);
                        System.out.println("Draw");
                        break;
                    }

                    if (currentPlayer == player1) {
                        currentPlayer = player2;
                    } else {
                        currentPlayer = player1;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
        }
    }

    public String getUserInput() {
        System.out.print("Enter location: ");
        return scanner.nextLine();
    }
}

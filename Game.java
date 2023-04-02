package tictactoe;

public class Game {

    private final char[][] board;

    public Game() {
        this.board = new char[3][3];
        buildGame();
    }

    public void buildGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.board[row][col] = ' ';
            }
        }
    }

    public void setPlayerMove(int row, int col, char player) {
        this.board[row][col] = player;
    }

    public char getPlayerMove(int row, int col) {
        return this.board[row][col];
    }

    public boolean isFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (this.board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean hasWinner() {
        for (int row = 0; row < 3; row++) {
            if (this.board[row][0] != ' ' && this.board[row][0] == this.board[row][1] && this.board[row][1] == this.board[row][2]) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (this.board[0][col] != ' ' && this.board[0][col] == this.board[1][col] && this.board[1][col] == this.board[2][col]) {
                return true;
            }
        }

        if (this.board[0][0] != ' ' && this.board[0][0] == this.board[1][1] && this.board[1][1] == this.board[2][2]) {
            return true;
        }

        if (this.board[0][2] != ' ' && this.board[0][2] == this.board[1][1] && this.board[1][1] == this.board[2][0]) {
            return true;
        }

        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (int row = 0; row < 3; row++) {
            sb.append("| ");
            for (int col = 0; col < 3; col++) {
                sb.append(this.board[row][col]).append(" ");
            }
            sb.append("|\n");
        }
        sb.append("---------");
        return sb.toString();
    }

}

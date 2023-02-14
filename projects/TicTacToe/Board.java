public class Board {
    private char[][] board;
    
    public Board() {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void draw() {
        // Draw tic tac toe board

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]);
                if (j < board.length - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-----");
            }
        }
    }

    public void setMark(int row, int col, char mark) {
        // Set mark on board. Used to mark board after valid input.

        board[row - 1][col - 1] = mark;
    }

    public boolean isFull() {
        // Check if board is full. Used to check for tie

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isWinner(char mark, int row, int col) {
        // Check rows and columns and diagonals (if position is located on diagonal) for win

        boolean rowWin = true;
        boolean colWin = true;
        boolean diagWin = true;
        boolean antiDiagWin = true;
        
        for (int i = 0; i < board.length; i++) {
            if (board[row - 1][i] != mark) {
                rowWin = false;
            }
            if (board[i][col - 1] != mark) {
                colWin = false;
            }
            if (row == col) {
                if (board[i][i] != mark) {
                    diagWin = false;
                }
            }
            else {
                diagWin = false;
            }
            if (row + col == board.length + 1) {
                if (board[i][board.length - 1 - i] != mark) {
                    antiDiagWin = false;
                }
            }
            else {
                antiDiagWin = false;
            }
        }

        return rowWin || colWin || diagWin || antiDiagWin;
    }
    
    public boolean isMarked(int row, int col) {
        // Check if a spot is marked

        return board[row - 1][col - 1] != ' ';
    }

    public boolean isValid(int row, int col) {
        // Check if a spot is on the board

        return row > 0 && row <= board.length && col > 0 && col <= board.length;
    }
}

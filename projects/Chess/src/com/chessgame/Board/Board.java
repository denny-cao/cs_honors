package Board;

import Pieces.*;

/**
 * Represents the chess board.
 */
public class Board {
    public static final int ROWS = 8;
    public static final int COLUMNS = 8;

    public Piece[][] board = new Piece[ROWS][COLUMNS];

    public Board() {
        initializeBoard();
    }

    /**
     * Creates a new board with the pieces in their starting positions.
     */
    public void initializeBoard() {
        // Initialize the board with empty spaces
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = null;
            }
        }

        // Initialize the board with pieces
        
        // Initialize the white pieces
        board[0][0] = new Rook(true);
        board[0][1] = new Knight(true);
        board[0][2] = new Bishop(true);
        board[0][3] = new Queen(true);
        board[0][4] = new King(true);
        board[0][5] = new Bishop(true);
        board[0][6] = new Knight(true);
        board[0][7] = new Rook(true);

        // Initialize the black pieces
        board[7][0] = new Rook(false);
        board[7][1] = new Knight(false);
        board[7][2] = new Bishop(false);
        board[7][3] = new Queen(false);
        board[7][4] = new King(false);
        board[7][5] = new Bishop(false);
        board[7][6] = new Knight(false);
        board[7][7] = new Rook(false);

        // Initialize the pawns
        for (int i = 0; i < COLUMNS; i++) {
            board[1][i] = new Pawn(true);
            board[6][i] = new Pawn(false);
        }
    }

    /**
     * Prints the board to the console. Includes the row and column labels. Even spacing based on piece name length.
     */
    public void printBoard() {
        // Print the column labels
        System.out.print("  ");
        for (int i = 0; i < COLUMNS; i++) {
            System.out.print(" " + (char) (i + 65) + " ");
        }
        System.out.println();

        // Print the board
        for (int i = 0; i < ROWS; i++) {
            // Print the row labels
            System.out.print(i + 1 + " ");

            // Print the pieces
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == null) {
                    System.out.print("[ ]");
                }
                else {
                    System.out.print("[" + board[i][j] + "]");
                }
            }
            System.out.println();
        }
    }
}

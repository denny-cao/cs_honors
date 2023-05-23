package Game;

import Pieces.*;
import Board.*;
import Player.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class to represent a game of chess
 */
public class Game {
    // Store graveyards for each player
    public static ArrayList<Piece> whiteGraveyard = new ArrayList<Piece>();
    public static ArrayList<Piece> blackGraveyard = new ArrayList<Piece>();

    Player whitePlayer;
    Player blackPlayer;

    private boolean isGameOver = false;

    public Game() {
        // Create board
        Board board = new Board();
        // Create players
        whitePlayer = new Player(true);
        blackPlayer = new Player(false);
        // Create scanner
        Scanner scanner = new Scanner(System.in);

        while (!isGameOver) {
            // Print the board
            board.printBoard();
            // Print whose turn it is
            if (whitePlayer.getIsTurn()) {
                System.out.println("White's turn");
            }
            else {
                System.out.println("Black's turn");
            }
            // Get the player's move
            System.out.println("Which piece would you like to move?");
            String start = scanner.nextLine();
            System.out.println("Where would you like to move it?");
            String end = scanner.nextLine();

            /*
             * Check if the move is legal
             */

            // Check if the start position is out of bounds
            if (convertPosition(start)[0] < 0 || convertPosition(start)[0] > Board.ROWS || convertPosition(start)[1] < 0 || convertPosition(start)[1] > Board.COLUMNS) {
                System.out.println("That position is out of bounds!");
            }

            // Check if there is a piece at the start position
            else if (board.board[convertPosition(start)[0]][convertPosition(start)[1]] == null) {
                System.out.println("There is no piece at that position!");
            }

            // Check if the piece at the start position is the player's piece
            else if (board.board[convertPosition(start)[0]][convertPosition(start)[1]].getIsWhite() != whitePlayer.getIsTurn()) {
                System.out.println("That is not your piece!");
            }
            
            // Check if the move puts the king in check
            Board testBoard = new Board(); // Create a new board to test the move

            // Copy the board
            for (int i = 0; i < Board.ROWS; i++) {
                for (int j = 0; j < Board.COLUMNS; j++) {
                    testBoard.board[i][j] = board.board[i][j];
                }
            }
            // Move the piece
            testBoard.board[convertPosition(start)[0]][convertPosition(start)[1]].move(testBoard.board, start, end);

            // Check if the move puts the king in check
            if (isCheck(testBoard.board, whitePlayer.getIsTurn())) {
                System.out.println("That move puts your king in check!");
            }

            // If not, move the piece
            else if (board.board[convertPosition(start)[0]][convertPosition(start)[1]].isLegalMove(board.board, convertPosition(start), convertPosition(end))) {
                board.board[convertPosition(start)[0]][convertPosition(start)[1]].move(board.board, start, end);

                // Check if checkmate
                if (isCheckmate(board.board, whitePlayer.getIsTurn())) {
                    System.out.println("Checkmate!");
                    isGameOver = true;
                }

                // Check if the move puts the opponent in check
                else if (isCheck(board.board, !whitePlayer.getIsTurn())) {
                    System.out.println("Check!");
                }

                // Switch turns
                whitePlayer.setIsTurn(!whitePlayer.getIsTurn());
                blackPlayer.setIsTurn(!blackPlayer.getIsTurn());
                }
                
                else {
                    System.out.println("Illegal move!");
                }
        }

        scanner.close();
    }

    /**
     * Method to change string representation of position of piece to row and column values
     * @param position String representation of position of piece
     * @return int[] array of row and column values of piece
     */
    public static int[] convertPosition(String position) {
        int[] positionArray = new int[2];
        positionArray[0] = Integer.parseInt(position.substring(1)) - 1; // Row
        // Normalize to lowercase to avoid case sensitivity
        positionArray[1] = position.toLowerCase().charAt(0) - 'a'; // Column
        return positionArray;
    }
    
    /**
     * Method to add a piece to the graveyard of the respective player
     * @param piece Piece to be added to the graveyard
     */
    public void capturePiece(Piece piece) {
        if (piece.getIsWhite()) {
            whiteGraveyard.add(piece);
        }
        else {
            blackGraveyard.add(piece);
        }
    }

    /**
     * Method to check if the king is in check
     * @param board Piece[][] array representing the board
     * @param isWhite boolean value to determine if the king is white or black
     * @return boolean value to determine if the king is in check
     */
    public boolean isCheck(Piece[][] board, boolean isWhite) {
        // Find the king
        int[] kingPos = new int[2];
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (board[i][j] instanceof King && board[i][j].getIsWhite() == isWhite) {
                    kingPos[0] = i;
                    kingPos[1] = j;
                }
            }
        }

        // Check if the king is in check
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (board[i][j] != null && board[i][j].getIsWhite() != isWhite && board[i][j].isLegalMove(board, new int[]{i, j}, kingPos)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Method to check if the king is in checkmate
     * @param board Piece[][] array representing the board
     * @param isWhite boolean value to determine if the king is white or black
     * @return boolean value to determine if the king is in checkmate
     */
    public boolean isCheckmate(Piece[][] board, boolean isWhite) {
        // Find the king
        int[] kingPos = new int[2];
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (board[i][j] instanceof King && board[i][j].getIsWhite() == isWhite) {
                    kingPos[0] = i;
                    kingPos[1] = j;
                }
            }
        }

        // Check if the king is in checkmate
        if (isCheck(board, isWhite)) {
            for (int i = kingPos[0] - 1; i <= kingPos[0] + 1; i++) {
                for (int j = kingPos[1] - 1; j <= kingPos[1] + 1; j++) {
                    if (i >= 0 && i < Board.ROWS && j >= 0 && j < Board.COLUMNS && board[i][j] == null && !isCheck(board, isWhite)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Method to check if the game is over
     * @param board Piece[][] array representing the board
     * @return boolean value to determine if the game is over
     */
    public void setIsGameOver(Piece[][] board) {
        if (isCheckmate(board, true) || isCheckmate(board, false)) {
            isGameOver = true;
        }
    }

    /**
     * Getter method for isGameOver
     * @return boolean value to determine if the game is over
     */
    public boolean getIsGameOver() {
        return isGameOver;
    }

    /**
     * Method to check if white player has won
     * @param board Piece[][] array representing the board
     * @return boolean value to determine if white player has won
     */
    public boolean isWhiteWin(Piece[][] board) {
        if (isCheckmate(board, false)) {
            return true;
        }
        return false;
    }

    /**
     * Method to check if black player has won
     * @param board Piece[][] array representing the board
     * @return boolean value to determine if black player has won
     */
    public boolean isBlackWin(Piece[][] board) {
        if (isCheckmate(board, true)) {
            return true;
        }
        return false;
    }

    /**
     * Method to change the turn
     */
    public void changeTurn(Player player1, Player player2) {
        if (player1.getIsTurn()) {
            player1.setIsTurn(false);
            player2.setIsTurn(true);
        }
        else {
            player1.setIsTurn(true);
            player2.setIsTurn(false);
        }
    }
}

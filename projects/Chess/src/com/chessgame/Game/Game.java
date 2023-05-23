package Game;

import Pieces.*;
import Board.*;
import java.util.ArrayList;

/**
 * Class to represent a game of chess
 */
public class Game {
    // Store graveyards for each player
    public static ArrayList<Piece> whiteGraveyard = new ArrayList<Piece>();
    public static ArrayList<Piece> blackGraveyard = new ArrayList<Piece>();

    public boolean isWhiteTurn = true;

    /**
     * Method to change string representation of position of piece to row and column values
     * @param position String representation of position of piece
     * @return int[] array of row and column values of piece
     */
    public static int[] convertPosition(String position) {
        int[] positionArray = new int[2];
        positionArray[0] = 8 - Integer.parseInt(position.substring(1)); // Row
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
     * Method to check if the game is a stalemate
     * @param board Piece[][] array representing the board
     * @param isWhite boolean value to determine if the king is white or black
     * @return boolean value to determine if the game is a stalemate
     */
    public boolean isStalemate(Piece[][] board, boolean isWhite) {
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

        // Check if the game is a stalemate
        if (!isCheck(board, isWhite)) {
            for (int i = kingPos[0] - 1; i <= kingPos[0] + 1; i++) {
                for (int j = kingPos[1] - 1; j <= kingPos[1] + 1; j++) {
                    if (i >= 0 && i < Board.ROWS && j >= 0 && j < Board.COLUMNS && board[i][j] == null) {
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
    public boolean isGameOver(Piece[][] board) {
        if (isCheckmate(board, true) || isCheckmate(board, false) || isStalemate(board, true) || isStalemate(board, false)) {
            return true;
        }
        return false;
    }

    /**
     * Method to change the turn
     */
    public void changeTurn() {
        isWhiteTurn = !isWhiteTurn;
    }
}

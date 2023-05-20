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

    public void capturePiece(Piece piece) {
        if (piece.getIsWhite()) {
            whiteGraveyard.add(piece);
        }
        else {
            blackGraveyard.add(piece);
        }
    }
}

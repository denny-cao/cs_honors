package Pieces;

import Game.*;
import Board.*;
import java.util.Arrays;

/**
 * Class for the piece
 */
public class Piece { 
    private boolean isWhite;

    /**
     * Constructor for Piece
     * @param isWhite boolean value to determine if the piece is white or black
     */
    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    /**
     * Getter for isWhite
     * @return boolean value to determine if the piece is white or black
     */
    public boolean getIsWhite() {
        return this.isWhite;
    }

    /**
     * Setter for isWhite
     * @param isWhite boolean value to determine if the piece is white or black
     */

    public void setIsWhite(boolean isWhite) {
        this.isWhite = isWhite;
    }
    
    public boolean isLegalMove(Piece[][] board, int[] startPos, int[] endPos) {

        // Check if the end position is out of bounds
        if (endPos[0] < 0 || endPos[0] > Board.ROWS || endPos[1] < 0 || endPos[1] > Board.COLUMNS) {
            return false;
        }

        // Check if the end position is the same as the start position
        else if (Arrays.equals(startPos, endPos)) {
            return false;
        }

        // Check if the end position is occupied by a piece of the same color
        else if (board[endPos[0]][endPos[1]] != null && board[endPos[0]][endPos[1]].getIsWhite() == this.getIsWhite()) {
            return false;
        }

        else {
            return true;
        }
    }

    public boolean move(Piece[][] board, String start, String end) {
        int[] startPos = Game.convertPosition(start);
        int[] endPos = Game.convertPosition(end);

        if (!this.isLegalMove(board, startPos, endPos)) {
            return false;
        }

        // If the end position is occupied by a piece of the opposite color, store it in the graveyard and replace
        // it with the current piece
        if (board[endPos[0]][endPos[1]] != null) {
            if (board[endPos[0]][endPos[1]].getIsWhite()) {
                Game.whiteGraveyard.add(board[endPos[0]][endPos[1]]);
            }
            else {
                Game.blackGraveyard.add(board[endPos[0]][endPos[1]]);
            }
        }
        board[endPos[0]][endPos[1]] = board[startPos[0]][startPos[1]];
        board[startPos[0]][startPos[1]] = null;
        return true;
    }
}

package Pieces;

/**
 * Class for the knight piece
 */
public class Knight extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    public boolean isLegalMove(Piece[][] board, int[] startPos, int[] endPos) {
        if (!super.isLegalMove(board, startPos, endPos)) {
            return false;
        }

        /*
         * Move Set:
         * 1. Move two spaces in any direction, then one space in a perpendicular direction
         */

        // Check if knight is moving two spaces in any direction, then one space in a perpendicular direction
        else if ((Math.abs(startPos[0] - endPos[0]) == 2 && Math.abs(startPos[1] - endPos[1]) == 1) || (Math.abs(startPos[0] - endPos[0]) == 1 && Math.abs(startPos[1] - endPos[1]) == 2)) {
            return true;
        }

        else {
            return false;
        }
        
    }

    public String toString() {
        if (getIsWhite()) {
            return "wKn";
        }
        else {
            return "bKn";
        }
    }
}

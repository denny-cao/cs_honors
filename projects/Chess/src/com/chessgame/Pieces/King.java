package Pieces;

/**
 * Class for the king piece
 */
public class King extends Piece {
    public King(boolean isWhite) {
        super(isWhite);
    }

    public boolean isLegalMove(Piece[][] board, int[] startPos, int[] endPos) {
        if (!super.isLegalMove(board, startPos, endPos)) {
            return false;
        }

        /*
         * Move Set:
         * 1. Move one space in any direction
         */

        // Check if king is moving one space in any direction
        else if (Math.abs(startPos[0] - endPos[0]) <= 1 && Math.abs(startPos[1] - endPos[1]) <= 1) {
            return true;
        }

        else {
            return false;
        }
        
    }

    public String toString() {
        if (getIsWhite()) {
            return "wK";
        }
        else {
            return "bK";
        }
    }
}

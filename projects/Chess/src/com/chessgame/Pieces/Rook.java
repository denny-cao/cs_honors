package Pieces;

/**
 * Class for the rook piece
 */
public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    public boolean isLegalMove(Piece[][] board, int[] startPos, int[] endPos) {
        if (!super.isLegalMove(board, startPos, endPos)) {
            return false;
        }

        /*
         * Move Set:
         * 1. Move horizontally any number of spaces
         * 2. Move vertically any number of spaces
         */
        // Check if rook is moving horizontally
        else if (startPos[0] == endPos[0]) {
            // Check if rook is moving left
            if (startPos[1] > endPos[1]) {
                // Check if there are any pieces in the way
                for (int i = startPos[1] - 1; i > endPos[1]; i--) {
                    if (board[startPos[0]][i] != null) {
                        return false;
                    }
                }
            }
            // Check if the rook is moving right; note we do not need to check if startPos[0] == endPos[0] because from the super call we know that the end position is not the same as the start position
            else {
                // Check if there are any pieces in the way
                for (int i = startPos[1] + 1; i < endPos[1]; i++) {
                    if (board[startPos[0]][i] != null) {
                        return false;
                    }
                }
            }
        }

        // Check if rook is moving vertically
        else if (startPos[1] == endPos[1]) {
            // Check if rook is moving down
            if (startPos[0] < endPos[0]) {
                // Check if there are any pieces in the way
                for (int i = startPos[0] - 1; i > endPos[0]; i--) {
                    if (board[i][startPos[1]] != null) {
                        return false;
                    }
                }
            }
            // Check if rook is moving up
            else {
                // Check if there are any pieces in the way
                for (int i = startPos[0] + 1; i < endPos[0]; i++) {
                    if (board[i][startPos[1]] != null) {
                        return false;
                    }
                }
            }
        }

        // If the rook is not moving horizontally or vertically, then the move is illegal
        else {
            return false;
        }

        return true;
    }

    public String toString() {
        if (getIsWhite()) {
            return "wR";
        }
        else {
            return "bR";
        }
    }
}

package Pieces;

/**
 * Class for the bishop piece
 */
public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
        super(isWhite);
    }

    public boolean isLegalMove(Piece[][] board, int[] startPos, int[] endPos) {
        if (!super.isLegalMove(board, startPos, endPos)) {
            return false;
        }
        
        /*
         * Move Set:
         * 1. Move diagonally any number of spaces
         */
        
        // Check if bishop is moving diagonally
        else if (Math.abs(startPos[0] - endPos[0]) == Math.abs(startPos[1] - endPos[1])) {
            // Check if bishop is moving up and to the right
            if (startPos[0] < endPos[0] && startPos[1] < endPos[1]) {
                // Check if there are any pieces in the way
                for (int i = startPos[0] + 1, j = startPos[1] + 1; i < endPos[0] && j < endPos[1]; i++, j++) {
                    if (board[i][j] != null) {
                        return false;
                    }
                }
            }
            // Check if bishop is moving up and to the left
            else if (startPos[0] < endPos[0] && startPos[1] > endPos[1]) {
                // Check if there are any pieces in the way
                for (int i = startPos[0] + 1, j = startPos[1] - 1; i < endPos[0] && j > endPos[1]; i++, j--) {
                    if (board[i][j] != null) {
                        return false;
                    }
                }
            }
            // Check if bishop is moving down and to the right
            else if (startPos[0] > endPos[0] && startPos[1] < endPos[1]) {
                // Check if there are any pieces in the way
                for (int i = startPos[0] - 1, j = startPos[1] + 1; i > endPos[0] && j < endPos[1]; i--, j++) {
                    if (board[i][j] != null) {
                        return false;
                    }
                }
            }
            // Check if bishop is moving down and to the left
            else {
                // Check if there are any pieces in the way
                for (int i = startPos[0] - 1, j = startPos[1] - 1; i > endPos[0] && j > endPos[1]; i--, j--) {
                    if (board[i][j] != null) {
                        return false;
                    }
                }
            }
        }

        else {
            return false;
        }

        return true;
    }

    public String toString() {
        if (getIsWhite()) {
            return "wB";
        }
        else {
            return "bB";
        }
    }
}

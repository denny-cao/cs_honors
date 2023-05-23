package Pieces;

/**
 * Class for the queen piece
 */
public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    public boolean isLegalMove(Piece[][] board, int[] startPos, int[] endPos) {
        if (!super.isLegalMove(board, startPos, endPos)) {
            return false;
        }

        /*
         * Move Set:
         * 1. Move any number of spaces horizontally or vertically
         * 2. Move any number of spaces diagonally
         */
        // Check if queen is moving horizontally
        else if (startPos[0] == endPos[0]) {
            // Check if queen is moving left
            if (startPos[1] > endPos[1]) {
                // Check if there are any pieces in the way
                for (int i = startPos[1] - 1; i > endPos[1]; i--) {
                    if (board[startPos[0]][i] != null) {
                        return false;
                    }
                }
            }
            // Check if the queen is moving right; note we do not need to check if startPos[0] == endPos[0] because from the super call we know that the end position is not the same as the start position
            else {
                // Check if there are any pieces in the way
                for (int i = startPos[1] + 1; i < endPos[1]; i++) {
                    if (board[startPos[0]][i] != null) {
                        return false;
                    }
                }
            }
        }

        // Check if queen is moving vertically
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
            // Check if queen is moving up
            else {
                // Check if there are any pieces in the way
                for (int i = startPos[0] + 1; i < endPos[0]; i++) {
                    if (board[i][startPos[1]] != null) {
                        return false;
                    }
                }
            }
        }

        // Check if queen is moving diagonally
        else if (Math.abs(startPos[0] - endPos[0]) == Math.abs(startPos[1] - endPos[1])) {
            // Check if queen is moving up and to the right
            if (startPos[0] < endPos[0] && startPos[1] < endPos[1]) {
                // Check if there are any pieces in the way
                for (int i = startPos[0] + 1, j = startPos[1] + 1; i < endPos[0] && j < endPos[1]; i++, j++) {
                    if (board[i][j] != null) {
                        return false;
                    }
                }
            }
            // Check if queen is moving up and to the left
            else if (startPos[0] < endPos[0] && startPos[1] > endPos[1]) {
                // Check if there are any pieces in the way
                for (int i = startPos[0] + 1, j = startPos[1] - 1; i < endPos[0] && j > endPos[1]; i++, j--) {
                    if (board[i][j] != null) {
                        return false;
                    }
                }
            }
            // Check if queen is moving down and to the right
            else if (startPos[0] > endPos[0] && startPos[1] < endPos[1]) {
                // Check if there are any pieces in the way
                for (int i = startPos[0] - 1, j = startPos[1] + 1; i > endPos[0] && j < endPos[1]; i--, j++) {
                    if (board[i][j] != null) {
                        return false;
                    }
                }
            }
            // Check if queen is moving down and to the left
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
            return "wQ";
        }
        else {
            return "bQ";
        }
    }
}

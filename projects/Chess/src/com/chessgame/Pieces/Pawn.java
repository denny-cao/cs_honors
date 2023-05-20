package Pieces;

/**
 * Class for the pawn piece
 */
public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    public boolean isLegalMove(Piece[][] board, int[] startPos, int[] endPos) {
        if (!super.isLegalMove(board, startPos, endPos)) {
            return false;
        }

        /*
         * Move Set:
         * 1. Move forward one space
         * 2. Move forward two spaces if in starting position
         */
        // Check if pawn is moving forward
        else if (startPos[1] == endPos[1]) {
            // Check if pawn is moving forward one space
            if (Math.abs(startPos[0] - endPos[0]) == 1) {
                // Check if pawn is moving forward one space and is white
                if (startPos[0] - endPos[0] == 1 && getIsWhite()) {
                    return true;
                }
                // Check if pawn is moving forward one space and is black
                else if (startPos[0] - endPos[0] == -1 && !getIsWhite()) {
                    return true;
                }
                else {
                    return false;
                }
            }
            // Check if pawn is moving forward two spaces
            else if (Math.abs(startPos[0] - endPos[0]) == 2) {
                // Check if pawn is moving forward two spaces and is white
                if (startPos[0] - endPos[0] == 2 && getIsWhite()) {
                    // Check if pawn is in starting position
                    if (startPos[0] == 6) {
                        // Check if there are any pieces in the way
                        for (int i = startPos[0] - 1; i > endPos[0]; i--) {
                            if (board[i][startPos[1]] != null) {
                                return false;
                            }
                        }
                    }
                    else {
                        return false;
                    }
                }
                // Check if pawn is moving forward two spaces and is black
                else if (startPos[0] - endPos[0] == -2 && !getIsWhite()) {
                    // Check if pawn is in starting position
                    if (startPos[0] == 1) {
                        // Check if there are any pieces in the way
                        for (int i = startPos[0] + 1; i < endPos[0]; i++) {
                            if (board[i][startPos[1]] != null) {
                                return false;
                            }
                        }
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        // Check if pawn is moving diagonally
        else if (Math.abs(startPos[1] - endPos[1]) == 1) {
            // Check if pawn is moving diagonally and is white
            if (startPos[0] - endPos[0] == 1 && getIsWhite()) {
                // Check if there is a piece in the way
                if (board[endPos[0]][endPos[1]] == null) {
                    return false;
                }
            }
            // Check if pawn is moving diagonally and is black
            else if (startPos[0] - endPos[0] == -1 && !getIsWhite()) {
                // Check if there is a piece in the way
                if (board[endPos[0]][endPos[1]] == null) {
                    return false;
                }
            }
            else {
                return false;
            }
        }

        else {
            return false;
        }

        return true;
    }
}

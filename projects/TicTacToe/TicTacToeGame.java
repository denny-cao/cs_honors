/* Write a program that plays tic-tac-toe. The tic-tac-toe
game is played on a 3 × 3 grid as in the photo at right. The
game is played by two players, who take turns. The first
player marks moves with a circle, the second with a cross.

The player who has formed a horizontal, vertical, or diag-
onal sequence of three marks wins. Your program should

draw the game board, ask the user for the coordinates of
the next mark, change the players after every successful
move, and pronounce the winner. */

public class TicTacToeGame {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", 'O');
        Player player2 = new Player("Player 2", 'X');
        Board board = new Board();
        TicTacToe game = new TicTacToe(player1, player2, board);
        game.play();
    }
}


import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Board board;
    
    public TicTacToe(Player player1, Player player2, Board board) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
    }
    
    public void play() {
        Scanner in = new Scanner(System.in);

        board.draw();
        Player currentPlayer = player1;
        while (!board.isFull()) {
            
            // Get input from user
            System.out.print(currentPlayer.getName() + ", enter row and column: ");
            int row = in.nextInt();
            int col = in.nextInt();

            // Check if input can be used
            if (board.isValid(row, col) == false) {
                System.out.println("Invalid input. Try again.");
            }
            else if (board.isMarked(row, col) == true) {
                System.out.println("That spot is already marked. Try again.");
            }

            // If input is valid, mark the board and check for a winner
            else {
                board.setMark(row, col, currentPlayer.getMark());
                board.draw();
                if (board.isWinner(currentPlayer.getMark(), row, col)) {
                    System.out.println(currentPlayer.getName() + " wins!");
                    in.close();
                    return;
                }

                else if (board.isFull()) {
                    System.out.println("It's a tie!");
                    in.close();
                    return;
                }

                currentPlayer = currentPlayer == player1 ? player2 : player1;
            }
        }
    }
}
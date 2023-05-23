package Player;

public class Player {
    private boolean isWhite;
    private boolean isTurn;
    
    public Player(boolean isWhite) {
        this.isWhite = isWhite;
        this.isTurn = isWhite;
    }
    
    public boolean isWhite() {
        return isWhite;
    }
    
    public boolean isTurn() {
        return isTurn;
    }
    
    public void setTurn(boolean isTurn) {
        this.isTurn = isTurn;
    }
    
    public String toString() {
        if (isWhite) {
            return "White";
        } else {
            return "Black";
        }
    }    
}

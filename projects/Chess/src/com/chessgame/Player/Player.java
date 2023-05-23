package Player;

public class Player {
    private boolean isWhite;
    private boolean isTurn;
    
    public Player(boolean isWhite) {
        this.isWhite = isWhite;
        this.isTurn = isWhite;
    }
    
    public boolean getIsWhite() {
        return isWhite;
    }
    
    public boolean getIsTurn() {
        return isTurn;
    }
    
    public void setIsTurn(boolean isTurn) {
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

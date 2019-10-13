
package wormgame.domain;

/**
 *
 * @author ardianbsyla
 */
public class Piece {
    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public boolean runsInto(Piece piece){
        if(this.x == piece.getX() && this.y == piece.getY()) return true;
        return false;
    }
    
    public String toString(){
        return "(" + this.x + "," + y + ")";
    }
}


package wormgame.domain;

import java.util.List;
import java.util.ArrayList;
import wormgame.Direction;

/**
 *
 * @author ardianbsyla
 */
public class Worm {
    private int originalX;
    private int originalY;
    private Direction originalDirection;
    private List<Piece> pieces;
    private boolean wasGrown = false;
    
    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.originalX = originalX;
        this.originalY = originalY;
        this.originalDirection = originalDirection;
        pieces  = new ArrayList<Piece>();
        pieces.add(new Piece(originalX, originalY));
    }

    public Direction getDirection() {
        return originalDirection;
    }

    public void setDirection(Direction originalDirection) {
        this.originalDirection = originalDirection;
    }
    
    public int getLength(){
        return this.getPieces().size();
    }
    
    public List<Piece> getPieces(){
        return pieces;
    }
    
    public void move(){
            if(getDirection() == Direction.RIGHT) {
                originalX++;
            } else  if(getDirection() == Direction.DOWN){
                originalY++;
            } else if(getDirection() == Direction.UP){
                originalY--;
            } else if(getDirection() == Direction.LEFT){
                originalX--;
            }
           if(pieces.size()<3 || wasGrown) {
               pieces.add(new Piece(originalX, originalY));
               wasGrown = false;
           }
           else {
               pieces.add(new Piece(originalX, originalY));
               pieces.remove(0);
           }
    }
    
    public void grow(){
        wasGrown = true;
    }
    public boolean runsInto(Piece piece){
        for(Piece p : pieces){
            if(p.getX() == piece.getX() && p.getY() == piece.getY()) return true;
        }
        return false;
    }
    
    public boolean runsIntoItself(){
        for(int i = 0; i<pieces.size()-1; i++){
            if(pieces.get(i).getX() == originalX && pieces.get(i).getY() == originalY) return true;
        }
        return false;
    }
    
}

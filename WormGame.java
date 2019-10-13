package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    
    
    public WormGame(int width, int height) {
        super(1000, null);

        this.continues = true;
        
        this.width = width;
        this.height = height;
        this.worm = new Worm(width/2, height/2, Direction.DOWN);
        int xLocation = new Random().nextInt(width);
        int yLocation = new Random().nextInt(height);
        
        this.apple = new Apple(xLocation, yLocation);
        while(worm.runsInto(apple)){
            xLocation = new Random().nextInt(width);
            yLocation = new Random().nextInt(height);
            apple = new Apple(xLocation, yLocation);
        }
        
        addActionListener(this);
        setInitialDelay(5000);
 
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) { return; }
        
        this.getWorm().move();
        

        if(this.worm.runsInto(apple)){
            this.worm.grow();
            int xLocation = new Random().nextInt(width);
            int yLocation = new Random().nextInt(height);
        
            this.apple = new Apple(xLocation, yLocation); 
        }
        for(Piece p : worm.getPieces()){
            if(p.getX() > width || p.getY()>height || p.getX()<0 || p.getY() < 0){
                this.continues = false;
            }
        }
        if(worm.runsIntoItself()){
            this.continues = false;
        }
        
        this.updatable.update();
        super.setDelay(1000 / worm.getLength());

    }

}


package wormgame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wormgame.Direction;
import wormgame.domain.Worm;

/**
 *
 * @author ardianbsyla
 */
public class KeyboardListener implements KeyListener {
    
    private Worm worm;

    public KeyboardListener(Worm worm) {
        this.worm = worm;
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            worm.setDirection(Direction.UP);
            
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            worm.setDirection(Direction.DOWN);
            
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            worm.setDirection(Direction.LEFT);
            
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            worm.setDirection(Direction.RIGHT);
            
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }
    
}

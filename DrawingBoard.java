
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.domain.Piece;
import wormgame.game.WormGame;

/**
 *
 * @author ardianbsyla
 */
public class DrawingBoard extends JPanel implements Updatable{
    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        super();
        super.setBackground(Color.GRAY);
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }
    
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.setColor(Color.black);
        for(Piece p : wormGame.getWorm().getPieces()){
            graphics.fill3DRect(p.getX()*pieceLength, p.getY()*pieceLength, pieceLength, pieceLength, true);
        }
        graphics.setColor(Color.red);
        graphics.fillOval(wormGame.getApple().getX() * pieceLength, wormGame.getApple().getY() * pieceLength, pieceLength, pieceLength);
    }

    @Override
    public void update() {
        this.repaint();
    }
    
    
}

package app;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.Block;
import view.BlockDisplay;

public class BlockPanel extends JPanel implements BlockDisplay {

    private Block block;
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
        
        int d = Block.MAX*100;
        g.setColor(Color.black);
        for (int i = 0; i <= Block.MAX; i++) {
            int c = i*100;
            g.drawLine(0, c, d, c);
            g.drawLine(c, 0, d, c);
        }
        
        if(block == null) return;
        g.setColor(Color.red);
        g.fillRect((block.x()-1)*100, (Block.MAX - block.y())*100, 100, 100);
    }
    
    public void display(Block block){
        this.block = block;
        repaint();
    }
    
    public void changed(){
        repaint();
    }
}

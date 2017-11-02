package boardgameproject;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

public class BoardGameProject extends JFrame implements Runnable {


    boolean animateFirstTime = true;
    Image image;
    static Graphics2D g;
    static int NUM_RESOURCE_TYPES = 5;


    public static void main(String[] args) {
        BoardGameProject frame = new BoardGameProject();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        
 
        
    }

    public BoardGameProject() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
   
                if (e.BUTTON1 == e.getButton() ) {
                    System.out.println("Help Me");
                        
                    
                }

                if (e.BUTTON3 == e.getButton()) {
                    
                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                repaint();
            }
        });
        init();
        start();
    }
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.black);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        Board.drawBoard(g);
        
        
        
//        Dice dice = new Dice();
               
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {
        for(int i = 0; i < 20; i++)
        {    Tile tempTile = (Tile) Tile.getTiles().get(i);
            tempTile.doRandomAssignment();
            }
        
        
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
                
        Tile tile1 = new Tile(Tile.tileType.Sheep, g);
        Tile tile2 = new Tile(Tile.tileType.Sheep, g);
        Tile tile3 = new Tile(Tile.tileType.Sheep,g );
        Tile tile4 = new Tile(Tile.tileType.Sheep, g);
        Tile tile5 = new Tile(Tile.tileType.Wheat, g);
        Tile tile6 = new Tile(Tile.tileType.Wheat, g);
        Tile tile7 = new Tile(Tile.tileType.Wheat, g);
        Tile tile8 = new Tile(Tile.tileType.Wheat, g);
        Tile tile9 = new Tile(Tile.tileType.Brick, g);
        Tile tile10 = new Tile(Tile.tileType.Brick, g);
        Tile tile11 = new Tile(Tile.tileType.Brick, g);
        Tile tile12 = new Tile(Tile.tileType.Desert, g);
        Tile tile13 = new Tile(Tile.tileType.Wood, g);
        Tile tile14 = new Tile(Tile.tileType.Wood, g);
        Tile tile15 = new Tile(Tile.tileType.Wood, g);
        Tile tile16 = new Tile(Tile.tileType.Ore, g);
        Tile tile17 = new Tile(Tile.tileType.Ore, g);
        Tile tile18 = new Tile(Tile.tileType.Ore, g);
        Tile tile19 = new Tile(Tile.tileType.Wood, g);
        Tile tile20 = new Tile(Tile.tileType.Gold, g);
        for(int i = 0; i < 20; i++)
        {    Tile tempTile = (Tile) Tile.getTiles().get(i);
            tempTile.doRandomAssignment();
            }
        }
            
        
        reset();

        }

        
        
        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
/////////////////////////////////////////////////////////////////////////

}





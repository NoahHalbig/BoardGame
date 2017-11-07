package boardgameproject;

import static boardgameproject.BoardGameProject.clientValue;
import static boardgameproject.BoardGameProject.g;
import static boardgameproject.BoardGameProject.gameStarted;
import static boardgameproject.BoardGameProject.isClient;
import static boardgameproject.BoardGameProject.serverValue;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class Board {
    final static int NUM_ROWS = 4;
    final static int NUM_COLUMNS = 5;  
    private static Tile hexBoard[][] = new Tile[NUM_ROWS][NUM_COLUMNS];

    
    Board(){
        
            
        
    }
    public static void drawBoard(Graphics2D g){
        int ydelta = Window.getHeight2()/NUM_ROWS;
        int xdelta = Window.getWidth2()/NUM_COLUMNS;
        
        g.setColor(Color.black);
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(0),Window.getY(zi*ydelta),
                    Window.getX(Window.getWidth2()),Window.getY(zi*ydelta));
            
            
        }
        
        for (int zi = 1;zi<NUM_COLUMNS;zi++)
        {
            g.drawLine(Window.getX(zi*xdelta),Window.getY(0),
                    Window.getX(zi*xdelta),Window.getY(Window.getHeight2()));
            
        }
        for (int zi = 0;zi<NUM_ROWS;zi++)
            for (int xi = 0;xi<NUM_COLUMNS;xi++)
            {   
                if(hexBoard[zi][xi] != null)
                    hexBoard[zi][xi].drawTile(zi, xi, g);     
            }
        
     
        
    }
    public static void randomAssignment(Tile thisTile){
        boolean keepLooping = true;
        while(keepLooping)
        {   int row = (int) (Math.random() * NUM_ROWS);
            int column = (int) (Math.random() * NUM_COLUMNS);
            if(hexBoard[row][column] == null)
            {    hexBoard[row][column] = thisTile;
                keepLooping = false;}
        }
    }
    public static Tile[][] getHexBoard(){
        return hexBoard;
    }
    
    
    
    
    public static void drawPhaseOne(Graphics2D g, String host){
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, Window.getWidth2() + Window.XBORDER * 2, Window.getHeight2() + Window.YBORDER * 2 + Window.YTITLE);
        if (!gameStarted)
        {
            g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
            g.setColor(Color.black);
            g.drawString("Not Connected",Window.getX(Window.getWidth2())/2,Window.getHeight2()/2);
            
        }
        else if (isClient)
        {
            g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
            g.setColor(Color.black);
            g.drawString("The Client",Window.getX(Window.getWidth2())/2,Window.getHeight2()/2);
        }
        else
        {
            g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
            g.setColor(Color.black);
            g.drawString("The Server",Window.getX(Window.getWidth2())/2,Window.getHeight2()/2);
        }           
        
            try
            {
                g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
                g.setColor(Color.black);
                g.drawString("Your IP address: " + InetAddress.getLocalHost().getHostAddress(), Window.getX(Window.getWidth2())/2, Window.getY(20));
                g.drawString("Enter IP address: " + host, Window.getX(Window.getWidth2())/2, Window.getY(60));
            }
            catch (UnknownHostException e)
            {
                e.printStackTrace();
            }
            g.drawString("The Player that will host the game will type in their IP Address and hit 'S' ", Window.getWidth2()/3 , 400);
            g.drawString("The Player that will join the host will type in the hosts IP Adress and hit 'C' ", Window.getWidth2()/3, 450);
        
        
        
    }
    public static void showRoll(Graphics2D g)
    {
        g.setColor(Color.white);
        g.fillRect(Window.getX(Window.getWidth2()/2-75), Window.getY(Window.getHeight2() + 50), Window.XBORDER, Window.YBORDER/2);
        g.setColor(Color.black);
        g.drawString("Roll Dice", Window.getX(Window.getWidth2()/2-50), Window.getY(Window.getHeight2() + 100));
        
    }        
    
    
    
    
    
    
}

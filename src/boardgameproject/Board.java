package boardgameproject;

import java.awt.Color;
import java.awt.Graphics2D;


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
    }
    public static void randomAssignment(Tile thisTile){
        boolean keepLooping = true;
        for(;keepLooping;)
        {   int row = (int) Math.random() * NUM_ROWS;
            int column = (int) Math.random() * NUM_COLUMNS;
            if(hexBoard[row][column] == null)
            {    hexBoard[row][column] = thisTile;
                thisTile.changeRow(row);
                thisTile.changeColumn(column);
                keepLooping = false;}
        }
    }
    public static Tile[][] getHexBoard(){
        return hexBoard;
    }
    
    
    
    
    
    
}

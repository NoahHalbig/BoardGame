package boardgameproject;

import java.awt.Color;
import java.awt.Graphics2D;

public class Tile {
    public static enum tileType{
        Sheep, Wheat, Wood, Brick, Ore, Desert, Gold
    };
    private int value;
    private tileType thisTileType;
    private static Graphics2D g;
    private int row;
    private int column;
    
    Tile(tileType _tileType){
        thisTileType = _tileType;
        value = (int) Math.random() *11 + 1;
        Board.randomAssignment(this);
//        drawTile();
    }
    public void drawTile(){
    
        g.fillRect(Window.getX(0)+column*Window.getWidth2()/Board.NUM_COLUMNS, Window.getY(0)+row*Window.getHeight2()/Board.NUM_ROWS, Window.getWidth2()/Board.NUM_COLUMNS, Window.getHeight2()/Board.NUM_ROWS);
        
        g.fillOval(Window.getX(0)+column*Window.getWidth2()/Board.NUM_COLUMNS, Window.getY(0)+row*Window.getHeight2()/Board.NUM_ROWS, Window.getWidth2()/Board.NUM_COLUMNS, Window.getHeight2()/Board.NUM_ROWS);
        g.setColor(Color.WHITE);
        g.drawString("" + value, (Window.getX(0)+(column*(Window.getWidth2()/Board.NUM_COLUMNS))) + Window.getWidth2()/Board.NUM_COLUMNS/2, Window.getY(0)+row*(Window.getHeight2()/Board.NUM_ROWS) + Window.getHeight2()/Board.NUM_ROWS/2);
        
    }
    public void changeRow(int _row){
        row = _row;
    }
    public void changeColumn(int _column){
        column = _column;
    }
   
}

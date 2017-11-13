package boardgameproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Tile {
    public static enum tileType{
        Sheep, Wheat, Wood, Brick, Ore, Desert, Gold
    };
    private int value;
    private tileType thisTileType;
    private Color thisColor;
    static private ArrayList<Tile> tiles = new ArrayList<Tile>();
    static private Graphics2D g;
    boolean robberOnTile;
    
    Tile(tileType _tileType, Graphics2D g){
        thisTileType = _tileType; 
        value = (int) (Math.random() * 12 + 1);
        if(thisTileType == tileType.Sheep)
            thisColor = Color.WHITE;
        else if(thisTileType == tileType.Wheat)
            thisColor = Color.CYAN;
        else if(thisTileType == tileType.Wood)
            thisColor = Color.GREEN;
        else if(thisTileType == tileType.Brick)
            thisColor = Color.RED;
        else if(thisTileType == tileType.Ore)
            thisColor = Color.GRAY;
        else if(thisTileType == tileType.Desert)
        {    thisColor = Color.ORANGE;
            robberOnTile = true;}
        else
            thisColor = Color.YELLOW;
        Tile obj = this;
        tiles.add(obj);
    }
    public static ArrayList getTiles(){
        return tiles;
    }
    public void drawTile(int row, int column, Graphics2D g){
        g.setColor(thisColor);
        g.fillRect(Window.getX(0)+column*Window.getWidth2()/Board.NUM_COLUMNS, Window.getY(0)+row*Window.getHeight2()/Board.NUM_ROWS, Window.getWidth2()/Board.NUM_COLUMNS, Window.getHeight2()/Board.NUM_ROWS);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.setColor(Color.BLACK);
        if(thisTileType != tileType.Desert)
            g.drawString("" + value, Window.getX(0)+column*(Window.getWidth2()/Board.NUM_COLUMNS) + Window.getWidth2()/Board.NUM_COLUMNS/2, Window.getY(0)+row*(Window.getHeight2()/Board.NUM_ROWS) + Window.getHeight2()/Board.NUM_ROWS/2);
        if(robberOnTile)
            g.drawOval(Window.getX(0)+column*Window.getWidth2()/Board.NUM_COLUMNS, Window.getY(0)+row*Window.getHeight2()/Board.NUM_ROWS, Window.getWidth2()/Board.NUM_COLUMNS/4, Window.getHeight2()/Board.NUM_ROWS/4);
        
        
        
        
    }
//    public int getColumn(){
//        return column;
//    }
//    public int getRow(){
//        return row;
//    }
    public void doRandomAssignment() {
        Board.randomAssignment(this);
    }
    public tileType getTileType(){
        return thisTileType;
    }
    public static int conevertTileToInt(tileType boardTile){
        if(boardTile == tileType.Sheep)
            return 1;
        else if(boardTile == tileType.Wheat)
            return 2;
        else if(boardTile == tileType.Wood)
            return 3;
        else if(boardTile == tileType.Brick)
            return 4;
        else if(boardTile == tileType.Ore)
            return 5;
        else if(boardTile == tileType.Desert)
            return 6;
        else
           return 7;
    }
    public static tileType convertIntToTile(int tileNumber){
        if(tileNumber == 1)
            return tileType.Sheep;
        else if(tileNumber == 2)
            return tileType.Wheat;
        else if(tileNumber == 3)
            return tileType.Wood;
        else if(tileNumber == 4)
            return tileType.Brick;
        else if(tileNumber == 5)
            return tileType.Ore;
        else if(tileNumber == 6)
            return tileType.Desert;
        else
           return tileType.Gold;
    }
   
}

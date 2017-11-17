package boardgameproject;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class Settlements extends Building{
    private static int width = 60;
    private static int height = 40; 
    static int pointValue = 1;
    PlayerThings player1 = new PlayerThings();
    PlayerThings player2 = new PlayerThings();
    //one brick, one log
    
    protected static ArrayList<Corner> corners = new ArrayList<Corner>();  
    protected static ArrayList<Settlements> settlements = new ArrayList<Settlements>();  
    int xPos = 0;
    int yPos = 0;
    
    public static void Draw(Graphics2D g) {
        for (int i=0;i<settlements.size();i++) {
            for (int o=0;0<BoardGameProject.me.ownedSettlements.size();o++)
                if (settlements.get(i) == BoardGameProject.me.ownedSettlements.get(o))
                    g.setColor(BoardGameProject.me.playerColor);
                else if(BoardGameProject.me.playerColor == Color.MAGENTA)
                    g.setColor(Color.DARK_GRAY);
                else
                    g.setColor(Color.MAGENTA);
                settlements.get(i).drawSettlements(g);
        }        
    } 
//    Settlements(){
//    }
    Settlements(int _xpos, int _ypos){
        xPos = _xpos;
        yPos = _ypos;
    }
    public void drawSettlements(Graphics2D g)
    {
        g.fillRect(xPos, yPos, width, height);    
    }
    public static void placeSettlements(MouseEvent e){
        Settlements obj = new Settlements(0, 0); 
        
        int mouseXPos = e.getX();
        int mouseYPos = e.getY();
        for(int i = Window.getX(0); i <= Window.getX(Window.getWidth2()); i += Window.getWidth2() / Board.NUM_COLUMNS)
        {  
            for(int j = Window.getY(0); j <= Window.getY(Window.getHeight2()); j += Window.getHeight2() / Board.NUM_ROWS)
            {   
                if(mouseXPos > i - width/3 && mouseXPos < i + width/3 && mouseYPos > j - height/3 && mouseYPos < j + height/3){
                    if(checkEmptiness(i, j, obj, mouseXPos, mouseYPos))
                    {    settlements.add(obj);  
                        Player.addSettlement(obj);
                        if(BoardGameProject.isClient)
                            ClientHandler.sendBuilding(1, obj.xPos, obj.yPos);
                        else
                            ServerHandler.sendBuilding(1, obj.xPos, obj.yPos);
                    }
                    
                }
            }           
        }
        
        
    }
    public static boolean checkEmptiness(int i, int j, Settlements obj, int mouseXPos, int mouseYPos){
        boolean returnTrue = true;
        if(settlements.isEmpty())
        {   obj.xPos = mouseXPos - width / 2;
            obj.yPos = mouseYPos - height / 2;  
            returnTrue = true;
        }     
        else
            for(int k = 0; k < settlements.size(); k++) 
            {   if(settlements.get(k).xPos + width/2 > i - width/2 && settlements.get(k).xPos - width/2 < i + width/2
                && settlements.get(k).yPos + height/2 > j - height/2 && settlements.get(k).yPos - height/2 < j + height/2)
                {returnTrue = false;}
                else{
                    obj.xPos = mouseXPos - width / 2;
                    obj.yPos = mouseYPos - height / 2;  
                    
                }
            }
        if(!returnTrue)
            return false;
        else
            return true;
    }
}

package boardgameproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class Roads extends Building{
    private static int width = 20;
    private static int height = 80;

    protected static ArrayList<Roads> roads = new ArrayList<Roads>();  
    protected static ArrayList<Settlements> settlements = new ArrayList<Settlements>(); 
    
    int xPos = Window.getWidth2()/2 + 100;
    int yPos = Window.getY(Window.getHeight2()) + Window.XBORDER/2 - 30;
    
    public static void drawAllRoads(Graphics2D g)
    {
        for (int i=0;i<roads.size();i++) {
            roads.get(i).drawRoads(g);
        }    
    }
    public void drawRoads(Graphics2D g)
    {
        g.setColor(Color.MAGENTA);
        g.fillRect(xPos, yPos, width, height);    
    }
    public static void placeRoad(MouseEvent e){
        Roads obj = new Roads();
        
         int mouseXPos = e.getX();
        int mouseYPos = e.getY();
        for(int i = Window.getX(0); i <= Window.getX(Window.getWidth2()); i += Window.getWidth2() / Board.NUM_COLUMNS)
        {  
            for(int j = Window.getY(0); j <= Window.getY(Window.getHeight2()); j += Window.getHeight2() / Board.NUM_ROWS)
            {   
                if(mouseXPos > i - width/2 && mouseXPos < i + width/2 && mouseYPos > j - height/2 && mouseYPos < j + height/2){
                    if(checkEmptiness(i, j, obj, mouseXPos, mouseYPos))
                        roads.add(obj);  
                }
            }           
        }
    }
     public static boolean checkEmptiness(int i, int j, Roads obj, int mouseXPos, int mouseYPos){
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

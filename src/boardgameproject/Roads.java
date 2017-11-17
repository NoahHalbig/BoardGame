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
    private int width = 20;
    private int height = 80;

    protected static ArrayList<Roads> roads = new ArrayList<Roads>();  
    protected static ArrayList<Settlements> settlements = new ArrayList<Settlements>(); 
    
    int xPos = 0;
    int yPos = 0;
    
    public static void drawAllRoads(Graphics2D g)
    {
        for (int i=0;i<roads.size();i++) {
            roads.get(i).drawRoads(g);
        }    
    }
    Roads(int _xpos, int _ypos){
        xPos = _xpos;
        yPos = _ypos;
    }
    public void drawRoads(Graphics2D g)
    {
        g.setColor(Color.MAGENTA);
        g.fillRect(xPos, yPos, width, height);    
    }
    public static void placeRoad(MouseEvent e){
        Roads obj = new Roads(0, 0);
        
        int mouseXPos = e.getX();
        int mouseYPos = e.getY();
        for(int i = Window.getX(0); i <= Window.getX(Window.getWidth2()); i += Window.getWidth2() / Board.NUM_COLUMNS)
        {  
            for(int j = Window.getY(Window.getHeight2() / Board.NUM_ROWS/2); j <= Window.getY(Window.getHeight2()); j += Window.getHeight2() / Board.NUM_ROWS)
            {   
                if(mouseXPos > i - obj.width/2 && mouseXPos < i + obj.width/2 && mouseYPos > j - obj.height/5 && mouseYPos < j + obj.height/5){
                    obj.width = 20;
                    obj.height = 80;
                    if(checkEmptinessVertical(i, j, obj, mouseXPos, mouseYPos))
                        roads.add(obj);  
                }
            }           
        }
        for(int i = Window.getX(Window.getWidth2()/ Board.NUM_COLUMNS / 2); i <= Window.getX(Window.getWidth2()); i += Window.getWidth2() / Board.NUM_COLUMNS)
        {  
            for(int j = Window.getY(0); j <= Window.getY(Window.getHeight2()); j += Window.getHeight2() / Board.NUM_ROWS)
            {   
                if(mouseXPos > i - obj.width/5 && mouseXPos < i + obj.width/5 && mouseYPos > j - obj.height/2 && mouseYPos < j + obj.height/2){
                    obj.width = 80;
                    obj.height = 20;
                    if(checkEmptinessHorizontal(i, j, obj, mouseXPos, mouseYPos))
                        roads.add(obj);  
                }
            }           
        }
    }
     public static boolean checkEmptinessVertical(int i, int j, Roads obj, int mouseXPos, int mouseYPos){
        boolean returnTrue = true;
        if(roads.isEmpty())
        {   obj.xPos = mouseXPos - obj.width / 2;
            obj.yPos = mouseYPos - obj.height / 2;  
            returnTrue = true;
        }     
        else
            for(int k = 0; k < roads.size(); k++) 
            {   if(roads.get(k).xPos + obj.width/2 > i - obj.width/2 && roads.get(k).xPos - obj.width/2 < i + obj.width/2
                && roads.get(k).yPos + obj.height/2 > j - obj.height/2 && roads.get(k).yPos - obj.height/2 < j + obj.height/2)
                {returnTrue = false;}
                else{
                    obj.xPos = mouseXPos - obj.width / 2;
                    obj.yPos = mouseYPos - obj.height / 2;  
                    
                }
            }
        if(!returnTrue)
            return false;
        else
            return true;
    }
    public static boolean checkEmptinessHorizontal(int i, int j, Roads obj, int mouseXPos, int mouseYPos){
        boolean returnTrue = true;
        if(roads.isEmpty())
        {   obj.xPos = mouseXPos - obj.width / 2;
            obj.yPos = mouseYPos - obj.height / 2;  
            returnTrue = true;
        }     
        else
            for(int k = 0; k < roads.size(); k++) 
            {   if(roads.get(k).xPos + obj.width/2 > i - obj.width/2 && roads.get(k).xPos - obj.width/2 < i + obj.width/2
                && roads.get(k).yPos + obj.height > j - obj.height && roads.get(k).yPos - obj.height < j + obj.height)
                {returnTrue = false;}
                else{
                    obj.xPos = mouseXPos - obj.width / 2;
                    obj.yPos = mouseYPos - obj.height / 2;  
                    
                }
            }
        if(!returnTrue)
            return false;
        else
            return true;
    }
}

package boardgameproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Cities extends Building{
    static int pointValue = 2;
    private static int width = 60;
    private static int height = 40; 
    int xPos = Window.getWidth2()/2 + 200;
    int yPos = Window.getY(Window.getHeight2()) + Window.XBORDER/2;
    protected static ArrayList<Cities> cities = new ArrayList<Cities>();  
    
    public static void drawAllCities(Graphics2D g)
    {
        for (int i=0;i<cities.size();i++) {
            cities.get(i).drawCities(g);
        }    
    }
    public void drawCities(Graphics2D g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(xPos, yPos, width -10, height);    
        g.fillRect(xPos, yPos, height - 20, width);   
    }

public static void placeCities(MouseEvent e){
        Cities obj = new Cities();
        
        int mouseXPos = e.getX();
        int mouseYPos = e.getY();
        for(int i = Window.getX(0); i <= Window.getX(Window.getWidth2()); i += Window.getWidth2() / Board.NUM_COLUMNS)
        {  
            for(int j = Window.getY(0); j <= Window.getY(Window.getHeight2()); j += Window.getHeight2() / Board.NUM_ROWS)
            {   
                if(mouseXPos > i - width/2 && mouseXPos < i + width/2 && mouseYPos > j - height/2 && mouseYPos < j + height/2){
                    if(checkEmptiness(i, j, obj, mouseXPos, mouseYPos))
                        cities.add(obj);  
                }
            }           
        }
    }
    public static boolean checkEmptiness(int i, int j, Cities obj, int mouseXPos, int mouseYPos){
        boolean returnTrue = true;
        if(cities.isEmpty())
        {   obj.xPos = mouseXPos - width / 2;
            obj.yPos = mouseYPos - height / 2;  
            returnTrue = true;
        }     
        else
            for(int k = 0; k < cities.size(); k++) 
            {   if(cities.get(k).xPos + width/2 > i - width/2 && cities.get(k).xPos - width/2 < i + width/2
                && cities.get(k).yPos + height/2 > j - height/2 && cities.get(k).yPos - height/2 < j + height/2)
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

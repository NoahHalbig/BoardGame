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
        obj.xPos = mouseXPos - width/2;
        obj.yPos = mouseYPos - height/2;  
       roads.add(obj);
    }
}

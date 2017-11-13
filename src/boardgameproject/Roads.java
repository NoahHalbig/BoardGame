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
    
    static int xPos = Window.getWidth2()/2 + 100;
    static int yPos = Window.getY(Window.getHeight2()) + Window.XBORDER/2 - 30;
    
    public static void drawRoads(Graphics2D g)
    {
        g.setColor(Color.MAGENTA);
        g.fillRect(xPos, yPos, width, height);    
    }
    public static void placeRoad(MouseEvent e){
        int mouseXPos = e.getX();
        int mouseYPos = e.getY();
        xPos = mouseXPos;
        yPos = mouseYPos;  
    }
}

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


public class Cities extends Building{
    static int pointValue = 2;
    private static int width = 60;
    private static int height = 40; 
    static int xPos = Window.getWidth2()/2 + 200;
    static int yPos = Window.getY(Window.getHeight2()) + Window.XBORDER/2;
    
    public static void drawCities(Graphics2D g)
    {
        g.setColor(Color.MAGENTA);
        g.fillRect(xPos, yPos, width -10, height );    
        g.fillRect(xPos, yPos, height - 20, width);   
    }
    public static void placeCities(MouseEvent e){
        int mouseXPos = e.getX();
            int mouseYPos = e.getY();
            xPos = mouseXPos;
            yPos = mouseYPos;  
    }
}

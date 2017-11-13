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

public class Settlements extends Building{
    private static int width = 60;
    private static int height = 40; 
    static int pointValue = 1;
    static boolean settlementTime = true;
    protected static ArrayList<Corner> corners = new ArrayList<Corner>();  
    protected static ArrayList<Settlements> settlements = new ArrayList<Settlements>();  
    static int xPos = Window.getWidth2()/2;
    static int yPos = Window.getY(Window.getHeight2()) + Window.XBORDER/2;
    
    public static void Draw(Graphics2D g) {
        for (int i=0;i<settlements.size();i++) {
            settlements.get(i).drawSettlements(g);
        }        
    } 
    public void drawSettlements(Graphics2D g)
    {
        g.setColor(Color.MAGENTA);
        g.fillRect(xPos, yPos, width, height);    
    }
    public static void placeSettlements(MouseEvent e){
        if(settlementTime)
        {
            int mouseXPos = e.getX();
            int mouseYPos = e.getY();
            xPos = mouseXPos;
            yPos = mouseYPos;  
            
        }    
    }
}

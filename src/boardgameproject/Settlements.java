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
    
    protected static ArrayList<Corner> corners = new ArrayList<Corner>();  
    protected static ArrayList<Settlements> settlements = new ArrayList<Settlements>();  
    int xPos = Window.getWidth2()/2;
    int yPos = Window.getY(Window.getHeight2()) + Window.XBORDER/2;
    
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
        Settlements obj = new Settlements();
        
        int mouseXPos = e.getX();
        int mouseYPos = e.getY();
        for(int i = Window.getX(0); i <= Window.getX(Window.getWidth2()); i += Window.getWidth2() / Board.NUM_COLUMNS)
        {  
            for(int j = Window.getY(0); j <= Window.getY(Window.getHeight2()); j += Window.getHeight2() / Board.NUM_ROWS)
            {
                boolean placeSettlement = true;
                for(int k = 0; k < settlements.size(); k++)
                {
                    if(settlements.get(k).xPos > mouseXPos - width/2 && settlements.get(k).xPos < mouseXPos + width/2
                    && settlements.get(k).yPos > mouseYPos - height/2 && settlements.get(k).yPos < mouseYPos + height/2)
                    {
                        placeSettlement = false;
                    }    
                }    
                if(placeSettlement)//get rid of this
                {    
                    if(mouseXPos > i - width/2 && 
                    mouseXPos < i + width/2 && 
                    mouseYPos > j - height/2 && 
                    mouseYPos < j + height/2)
                    {    //put settlement locator inside this if statement, use the i and j variables to determine if there is already a settlement there in same way as Mousexpos/ypos
                        obj.xPos = mouseXPos - width / 2;
                        obj.yPos = mouseYPos - height / 2;  

                        settlements.add(obj);
                    }
                }
                
            }
        }    
        
    }
}

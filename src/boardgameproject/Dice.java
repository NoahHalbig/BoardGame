
package boardgameproject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Dice {
    public static int num1 = (int)(Math.random()*6+1);
    public static int num2 = (int)(Math.random()*6+1);
    private boolean rollDice;
    
    Dice(){        
        
    } 
    public static void drawDice(Graphics2D g)
    {
        int dotSize = 20;
        g.setColor(Color.RED);
        g.fillRoundRect(0, Window.getY(Window.getHeight2()),Window.XBORDER, Window.YBORDER, 10, 10);
       
        
        g.setColor(Color.BLACK);
        if(num1 == 1)
        {     
           g.fillOval(Window.getX(0) - Window.XBORDER/2 - dotSize/2, Window.getY(Window.getHeight2()) + Window.YBORDER/2 - dotSize/2, dotSize, dotSize);     
        }
        else if(num1 == 2)
        {     
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize);  
        }
        else if(num1 == 3)
        {     
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(0) - Window.XBORDER/2 - dotSize/2, Window.getY(Window.getHeight2()) + Window.YBORDER/2 - dotSize/2, dotSize, dotSize);     
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
        }
        else if(num1 == 4)
        {     
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
        }
        else if(num1 == 5)
        {     
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(0) - Window.XBORDER/2 - dotSize/2, Window.getY(Window.getHeight2()) + Window.YBORDER/2 - dotSize/2, dotSize, dotSize);   
            
        }
        else if(num1 == 6)
        {     
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(0) - Window.XBORDER/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/2 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(0) - Window.XBORDER*3/4 - dotSize/2, Window.getY(Window.getHeight2()) + Window.XBORDER/2 - dotSize/2, dotSize, dotSize);  
            
        }
        
        g.setColor(Color.YELLOW);
        g.fillRoundRect(Window.getX(Window.getWidth2()), Window.getY(-Window.YBORDER), Window.XBORDER, Window.YBORDER, 10, 10);
       
        
        g.setColor(Color.BLACK);
        if(num2 == 1)
        {     
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/2 - dotSize/2, Window.getY(0) - Window.YBORDER/2 - dotSize/2, dotSize, dotSize);   
        }
        else if(num2 == 2)
        {     
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize);  
        }
        else if(num2 == 3)
        {     
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/2 - dotSize/2, Window.getY(0) - Window.YBORDER/2 - dotSize/2, dotSize, dotSize);     
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize);    
        }
        else if(num2 == 4)
        {   g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
        }
        else if(num2 == 5)
        {     
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/2 - dotSize/2, Window.getY(0) - Window.YBORDER/2 - dotSize/2, dotSize, dotSize);   
            
        }
        else if(num2 == 6)
        {     
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER/4 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER*3/4 - dotSize/2, dotSize, dotSize); 
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/4 - dotSize/2, Window.getY(0) - Window.XBORDER/2 - dotSize/2, dotSize, dotSize);   
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER*3/4 - dotSize/2, Window.getY(0) - Window.XBORDER/2 - dotSize/2, dotSize, dotSize);   
            
        }
        
    }   
    public void buttonPressed(MouseEvent e)
    {
        if(e.getX() > Window.getY(Window.getHeight2())&&
            e.getX() > Window.getY(Window.getHeight2()) &&
            e.getX() > Window.getY(Window.getHeight2()) &&
            e.getX() > Window.getY(Window.getHeight2()))
        {
            rollDice = true;
        }    
    }        
    public static void setRandomNum()
    {
        num1 = (int)(Math.random()*6+1);
        num2 = (int) (Math.random()*6+1);
    }        
}
    

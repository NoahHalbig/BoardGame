
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
    public static int num1 = setRandomNum();
    Dice()
    {        
    }
    public static void drawDice(Graphics2D g)
    {
        int dotSize = 20;
        g.setColor(Color.WHITE);
        g.fillRoundRect(0, Window.getY(Window.getHeight2()),Window.XBORDER, Window.YBORDER, 10, 10);
       
        
        g.setColor(Color.BLACK);
        if(num1 == 1)
        {     
            g.fillOval(Window.getX(-75),Window.getY(605), dotSize, dotSize);   
        }
        else if(num1 == 2)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);   
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);  
        }
        else if(num1 == 3)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-75),Window.getY(605), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);  
        }
        else if(num1 == 4)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);   
            g.fillOval(Window.getX(-45),Window.getY(655), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);   
        }
        else if(num1 == 5)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-75),Window.getY(605), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);  
            g.fillOval(Window.getX(-45),Window.getY(655), dotSize, dotSize);  
            
        }
        else if(num1 == 6)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);   
            g.fillOval(Window.getX(-45),Window.getY(605), dotSize, dotSize); 
            g.fillOval(Window.getX(-45),Window.getY(655), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(605), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);  
            
        }
        
        g.setColor(Color.WHITE);
        g.fillRoundRect(Window.getX(Window.getWidth2()), Window.getY(-Window.YBORDER), Window.XBORDER, Window.YBORDER, 10, 10);
       
        
        g.setColor(Color.BLACK);
        
        {     
            g.fillOval(Window.getX(Window.getWidth2()) + Window.XBORDER/2 - dotSize/2, Window.getY(0) - Window.YBORDER/2 - dotSize/2, dotSize, dotSize);   
        }
       if(num1 == 2)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);   
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);  
        }
        else if(num1 == 3)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-75),Window.getY(605), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);  
        }
        else if(num1 == 4)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);   
            g.fillOval(Window.getX(-45),Window.getY(655), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);   
        }
        else if(num1 == 5)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-75),Window.getY(605), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);  
            g.fillOval(Window.getX(-45),Window.getY(655), dotSize, dotSize);  
            
        }
        else if(num1 == 6)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), dotSize, dotSize);   
            g.fillOval(Window.getX(-45),Window.getY(605), dotSize, dotSize); 
            g.fillOval(Window.getX(-45),Window.getY(655), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(555), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(605), dotSize, dotSize);  
            g.fillOval(Window.getX(-105),Window.getY(655), dotSize, dotSize);  
            
        }
        
    }   
    public static int setRandomNum()
    {
        num1 = (int)(Math.random()*6+1);
        return(num1);
    }        
}
    


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
        g.setColor(Color.WHITE);
        g.fillRoundRect(Window.getX(-140),Window.getY(550),150, 150, 10, 10);
       
        
        g.setColor(Color.BLACK);
        if(num1 == 1)
        {     
            g.fillOval(Window.getX(-75),Window.getY(605), 20, 20);   
        }
        else if(num1 == 2)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);   
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);  
        }
        else if(num1 == 3)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-75),Window.getY(605), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);  
        }
        else if(num1 == 4)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);   
            g.fillOval(Window.getX(-45),Window.getY(655), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);   
        }
        else if(num1 == 5)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-75),Window.getY(605), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);  
            g.fillOval(Window.getX(-45),Window.getY(655), 20, 20);  
            
        }
        else if(num1 == 6)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);   
            g.fillOval(Window.getX(-45),Window.getY(605), 20, 20); 
            g.fillOval(Window.getX(-45),Window.getY(655), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(605), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);  
            
        }
        
        g.setColor(Color.WHITE);
        g.fillRoundRect(Window.getX(-140),Window.getY(550),150, 150, 10, 10);
       
        
        g.setColor(Color.BLACK);
        if(num1 == 1)
        {     
            g.fillOval(Window.getX(-75),Window.getY(605), 20, 20);   
        }
        else if(num1 == 2)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);   
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);  
        }
        else if(num1 == 3)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-75),Window.getY(605), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);  
        }
        else if(num1 == 4)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);   
            g.fillOval(Window.getX(-45),Window.getY(655), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);   
        }
        else if(num1 == 5)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-75),Window.getY(605), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);  
            g.fillOval(Window.getX(-45),Window.getY(655), 20, 20);  
            
        }
        else if(num1 == 6)
        {     
            g.fillOval(Window.getX(-45),Window.getY(555), 20, 20);   
            g.fillOval(Window.getX(-45),Window.getY(605), 20, 20); 
            g.fillOval(Window.getX(-45),Window.getY(655), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(555), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(605), 20, 20);  
            g.fillOval(Window.getX(-105),Window.getY(655), 20, 20);  
            
        }
        
    }   
    public static int setRandomNum()
    {
        num1 = (int)(Math.random()*6+1);
        return(num1);
    }        
}
    

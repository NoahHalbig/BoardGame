package boardgameproject;

import java.io.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.awt.image.BufferedImage;

public class BoardGameProject extends JFrame implements Runnable {


    boolean animateFirstTime = true;
    Image image;
    static Graphics2D g;
    static int NUM_RESOURCE_TYPES = 5;
    int phaseOfGame = 0;
    
    
    final int portNumber = 5657;
    public static boolean gameStarted = false;
    public static boolean myTurn;
    public static int serverValue = 0;
    public static int clientValue = 0;
    
    String host = new String();
 
    public static boolean isConnecting = false;
    public static boolean isClient;
    Thread relaxer;


    public static void main(String[] args) {
        BoardGameProject frame = new BoardGameProject();
        frame.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Network");
        frame.setResizable(false);
        
 
        
    }

    public BoardGameProject() {
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                
   
                if (e.BUTTON1 == e.getButton() ) {
                    Dice.setRandomNum();
                        
                    
                }

                if (e.BUTTON3 == e.getButton()) {
                    
                }
                repaint();
            }
        });
            

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {

        repaint();
      }
    });

    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {

        repaint();
      }
    });

        addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.VK_UP == e.getKeyCode()) {
                } else if (e.VK_DOWN == e.getKeyCode()) {
                } else if (e.VK_LEFT == e.getKeyCode()) {
                } else if (e.VK_RIGHT == e.getKeyCode()) {
                } else if (e.VK_ESCAPE == e.getKeyCode()) {
                    reset();
                }
                if (e.getKeyCode() == KeyEvent.VK_1 && gameStarted)
                {
                    if (isClient)
                    {
                        System.out.println("sending from client");
                        clientValue++;

                    }
                    else
                    {
                        System.out.println("sending from server");
                        serverValue++;

                    }			                    
                }  
                else if (e.getKeyCode() == KeyEvent.VK_2 && gameStarted)
                {
                    if (isClient)
                    {
                        System.out.println("sending from client");
                        clientValue+=2;
                            
                    }
                    else
                    {
                        System.out.println("sending from server");
                        serverValue+=2;
                            
                    }	
			                    
                }                        
                else if (e.getKeyCode() == KeyEvent.VK_S)
                {
                    if (!isConnecting)
                    {                    
                        try {     

                            isConnecting = true;
                            System.out.println("is connecting true");
                            ServerHandler.recieveConnect(portNumber);   //5657
                            System.out.println("after recieveConnect");
                            if (ServerHandler.connected)
                            {
                                isClient = false;
                                myTurn = false;
                                gameStarted = true;
                                isConnecting = false;
                            }                        
                        }
                        catch (IOException ex)
                        {
                            System.out.println("Cannot host server: " + ex.getMessage());
                            isConnecting = false;
                        }  
                     
                    }

                }
                else if (e.getKeyCode() == KeyEvent.VK_C)
                {
                    if (!isConnecting)
                    {
                    
                            try
                            {
                   
                                isConnecting = true;
                                ClientHandler.connect(host, portNumber);
                                if (ClientHandler.connected)
                                {
                                    isClient = true;
                                    myTurn = true;
                                    gameStarted = true;
                                    isConnecting = false;
                                }
                            }
                            catch (IOException ex)
                            {
                                System.out.println("Cannot join server: " + ex.getMessage());
                                isConnecting = false;
                            }                    
                    }
                    
                }                
                else
                {
                    if (!gameStarted)
                    {
                        if (e.getKeyCode() == KeyEvent.VK_0)
                        {
                            host += "0";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_1)
                        {
                            host += "1";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_2)
                        {
                            host += "2";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_3)
                        {
                            host += "3";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_4)
                        {
                            host += "4";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_5)
                        {
                            host += "5";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_6)
                        {
                            host += "6";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_7)
                        {
                            host += "7";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_8)
                        {
                            host += "8";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_9)
                        {
                            host += "9";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_PERIOD)
                        {
                            host += ".";
                        }
                        else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && host.length() > 0)
                        {
                            host=host.substring(0, host.length()-1);
                        }
                    }
                }
                
                if (gameStarted || isConnecting)
                {
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE && !isConnecting)
                    {
                        if (gameStarted)

                            if (isClient)
                            {
                                ClientHandler.sendDisconnect();
                                ClientHandler.disconnect();
                            }
                            else
                            {
                                ServerHandler.sendDisconnect();
                                ServerHandler.disconnect();
                            }
                        gameStarted = false;
                        reset();
                    }
                }                
                repaint();
            }
        });
        init();
        start();
    }
    
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, Window.xsize, Window.ysize);

        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.black);
        g.drawPolyline(x, y, 5);

        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
        
        //Board.drawBoard(g);
//        Dice.drawDice(g);
if (!gameStarted)
        {
            g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
            g.setColor(Color.black);
            g.drawString("Not Connected",100,150);
            
        }
        else if (isClient)
        {
            g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
            g.setColor(Color.black);
            g.drawString("The Client",100,150);
        }
        else
        {
            g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
            g.setColor(Color.black);
            g.drawString("The Server",100,150);
        }            


        {
            g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
            g.setColor(Color.black);
            g.drawString("Client value " + clientValue,100,200);
        }

        {
            g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
            g.setColor(Color.black);
            g.drawString("Server value " + serverValue,100,300);
            
        }
        
            try
            {
                g.setFont(new Font("Comic Sans", Font.ROMAN_BASELINE, 20));
                g.setColor(Color.black);
                g.drawString("Your IP address: " + InetAddress.getLocalHost().getHostAddress(), Window.getX(10), Window.getY(20));
                g.drawString("Enter IP address: " + host, Window.getX(10), Window.getY(60));
            }
            catch (UnknownHostException e)
            {
                e.printStackTrace();
            }
        if(phaseOfGame == 0)
            Board.drawPhaseOne(g);
            
        
      
               
        gOld.drawImage(image, 0, 0, null);
    }

////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = .1;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    static public void reset() {
        for(int i = 0; i < 20; i++)
        {    Tile tempTile = (Tile) Tile.getTiles().get(i);
            tempTile.doRandomAssignment();
            }
        
        
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {

        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
                
        Tile tile1 = new Tile(Tile.tileType.Sheep, g);
        Tile tile2 = new Tile(Tile.tileType.Sheep, g);
        Tile tile3 = new Tile(Tile.tileType.Sheep,g );
        Tile tile4 = new Tile(Tile.tileType.Sheep, g);
        Tile tile5 = new Tile(Tile.tileType.Wheat, g);
        Tile tile6 = new Tile(Tile.tileType.Wheat, g);
        Tile tile7 = new Tile(Tile.tileType.Wheat, g);
        Tile tile8 = new Tile(Tile.tileType.Wheat, g);
        Tile tile9 = new Tile(Tile.tileType.Brick, g);
        Tile tile10 = new Tile(Tile.tileType.Brick, g);
        Tile tile11 = new Tile(Tile.tileType.Brick, g);
        Tile tile12 = new Tile(Tile.tileType.Desert, g);
        Tile tile13 = new Tile(Tile.tileType.Wood, g);
        Tile tile14 = new Tile(Tile.tileType.Wood, g);
        Tile tile15 = new Tile(Tile.tileType.Wood, g);
        Tile tile16 = new Tile(Tile.tileType.Ore, g);
        Tile tile17 = new Tile(Tile.tileType.Ore, g);
        Tile tile18 = new Tile(Tile.tileType.Ore, g);
        Tile tile19 = new Tile(Tile.tileType.Wood, g);
        Tile tile20 = new Tile(Tile.tileType.Gold, g);
        for(int i = 0; i < 20; i++)
        {    Tile tempTile = (Tile) Tile.getTiles().get(i);
            tempTile.doRandomAssignment();
            }
        
        }
            
        
        reset();

        }
        
        
        
        
        
        
        
        
        
    }

////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();
        }
        relaxer = null;
    }
/////////////////////////////////////////////////////////////////////////

}





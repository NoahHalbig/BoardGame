/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgameproject;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author 155004377
 */
public class ResourceCards {
    private static enum resourceType{
        sheep, lumber, bricks, rocks, wheat, gold
    };
    private static Image imageSheep = Toolkit.getDefaultToolkit().getImage("./Sheep.PNG");
    private static Image imageLumber = Toolkit.getDefaultToolkit().getImage("./Wood.PNG");
    private static Image imageBrick = Toolkit.getDefaultToolkit().getImage("./Brick.PNG");
    private static Image imageRock = Toolkit.getDefaultToolkit().getImage("./Ore.PNG");
    private static Image imageWheat = Toolkit.getDefaultToolkit().getImage("./Wheat.PNG");
    private static Image imageGold = Toolkit.getDefaultToolkit().getImage("./rocket.PNG");
    private static Image resourceCard = Toolkit.getDefaultToolkit().getImage("./Baukosten_M.JPG");
    
    public static void draw(Graphics2D g,BoardGameProject obj) {
        drawCard(g,obj,Window.getX(Window.getWidth2() + Window.XBORDER/2),Window.getYNormal(Window.getHeight2()/2),0.0,0.2,0.2 );    
    }
    public static void drawCard(Graphics2D g, BoardGameProject obj, int xpos,int ypos,double rot,double xscale,
            double yscale){
        
        int widthShe = imageSheep.getWidth(obj);
        int heightShe = imageSheep.getHeight(obj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(imageSheep,-widthShe/2,-heightShe/2-heightShe,
        widthShe,heightShe,obj);


        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
        
        int widthLum = imageLumber.getWidth(obj);
        int heightLum = imageLumber.getHeight(obj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(imageLumber,-widthLum/2,-heightLum/2+heightLum,
        widthLum,heightLum,obj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
        
        int widthBri = imageBrick.getWidth(obj);
        int heightBri = imageBrick.getHeight(obj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(imageBrick,-widthBri/2,-heightBri/2+(heightBri*2),
        widthBri,heightBri,obj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
        
        int widthRock = imageRock.getWidth(obj);
        int heightRock = imageRock.getHeight(obj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(imageRock,-widthRock/2,-heightRock/2-(heightRock*2),
        widthRock,heightRock,obj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
        
        int widthWheat = imageWheat.getWidth(obj);
        int heightWheat = imageWheat.getHeight(obj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(imageWheat,-widthWheat/2,-heightWheat/2,
        widthWheat,heightWheat,obj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    public static void drawCard(Graphics2D g,BoardGameProject obj) {
        drawResourceCard(g,obj,Window.getX(Window.getWidth2() + Window.XBORDER/2),Window.getYNormal(Window.getHeight2()/2),0.0, 0.75, 0.75);    
    }
     public static void drawResourceCard(Graphics2D g, BoardGameProject obj, int xpos,int ypos,double rot,double xscale,
            double yscale){
        int width = resourceCard.getWidth(obj);
        int height = resourceCard.getHeight(obj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(resourceCard,-width/2,-height/2,
        width,height,obj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
     }    
}

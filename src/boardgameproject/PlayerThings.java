package boardgameproject;

import java.awt.Color;
import java.util.ArrayList;

public class PlayerThings {
    ArrayList<Building> ownedBuildings = new ArrayList<Building>();
    int[] resources = new int[BoardGameProject.NUM_RESOURCE_TYPES];
    int numPoints;
    Color playerColor;
    int order = 0;
    boolean player1Turn = true;
    ArrayList<Player> players = new ArrayList<Player>();
    
    int numWheat = 1;
    int numSheep = 1;
    int numBrick = 1;
    int numWood = 1;
    int numRock;
    int numGold;
    
    public int getNumBrick()
    {
        return(numBrick);
    }  
    public int getNumWood()
    {
        return(numWood);
    }
    public int getNumSheep()
    {
        return(numSheep);
    }  
    public int getNumWheat()
    {
        return(numWheat);
    }
    public int getNumRock()
    {
        return(numRock);
    }  
    public int getNumGold()
    {
        return(numGold);
    }
    
    public static void Reset(){
        
    }
    
}

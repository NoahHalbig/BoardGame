package boardgameproject;

import java.awt.Color;
import java.util.ArrayList;

public class PlayerThings {
    protected ArrayList<Roads> ownedRoads = new ArrayList<Roads>();
    protected ArrayList<Settlements> ownedSettlements = new ArrayList<Settlements>();
    protected ArrayList<Cities> ownedCities = new ArrayList<Cities>();
    int[] resources = new int[BoardGameProject.NUM_RESOURCE_TYPES];
    int numPoints;
    public Color playerColor;
    int order = 0;
    boolean player1Turn = true;
    ArrayList<Player> players = new ArrayList<Player>();
    
    static int numWheat = 1;
    static int numSheep = 1;
    static int numBrick = 1;
    static int numWood = 1;
    static int numRock;
    static int numGold;
    
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
    
    public static void addBrick()
    {
        numBrick++;
    }  
    public static void addWood()
    {
        numWood++;
    }
    public static void addSheep()
    {
        numSheep++;
    }  
    public static void addWheat()
    {
        numWheat++;
    }
    public static void addRock()
    {
        numRock++;
    }  
    public static void addGold()
    {
        numGold++;
    }
    public static void Reset(){
        
    }
    
}

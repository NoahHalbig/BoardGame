package boardgameproject;

import java.awt.Color;
import java.util.ArrayList;

public abstract class PlayerThings {
    ArrayList<Building> ownedBuildings = new ArrayList<Building>();
    int[] resources = new int[BoardGameProject.NUM_RESOURCE_TYPES];
    int numPoints;
    Color playerColor;
    int order = 0;
        
    
    
    public static void Reset(){
        
    }
    
}

package boardgameproject;

import java.awt.Color;
import java.util.ArrayList;

public class PlayerThings {
    ArrayList<Building> ownedBuildings = new ArrayList<Building>();
    int[] resources = new int[BoardGameProject.NUM_RESOURCE_TYPES];
    int numPoints;
    Color playerColor;
        
    
    
    public static void Reset(){
        
    }
    
}
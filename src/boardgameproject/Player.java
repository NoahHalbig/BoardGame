package boardgameproject;

import java.util.ArrayList;


public class Player extends PlayerThings{
    
    
    Player(){
        for(int i = 0; i < BoardGameProject.NUM_RESOURCE_TYPES; i++)
            resources[i] = 0;
    }
    public static void addSettlement(Settlements obj){
        BoardGameProject.me.ownedSettlements.add(obj);
    }
    public static void addCity(Cities obj){
        BoardGameProject.me.ownedCities.add(obj);
    }
    public static void addRoad(Roads obj){
        BoardGameProject.me.ownedRoads.add(obj);
    }
    
    
    
}

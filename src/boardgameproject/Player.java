package boardgameproject;

import java.util.ArrayList;


public class Player extends PlayerThings{
    
    
    Player(){
        for(int i = 0; i < BoardGameProject.NUM_RESOURCE_TYPES; i++)
            resources[i] = 0;
    }
    
    
    
}

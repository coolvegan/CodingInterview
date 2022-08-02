package Implementation;

import Controller.Game;
import Entity.GameElement;
import Interface.IGameContext;

import java.util.HashMap;

public class StandardGameContext implements IGameContext {

    @Override
    public void setup(HashMap<Integer, GameElement> gameElementHashMap) {
        gameElementHashMap.put(1,new GameElement(1, "Stein") );
        gameElementHashMap.put(2,new GameElement(2, "Schere") );
        gameElementHashMap.put(3,new GameElement(3, "Papier") );
        gameElementHashMap.get(1).addWeakerElement(gameElementHashMap.get(2));
        gameElementHashMap.get(3).addWeakerElement(gameElementHashMap.get(1));
        gameElementHashMap.get(2).addWeakerElement(gameElementHashMap.get(3));
    }

    @Override
    public void run(Game game) {
        System.out.println("Standard Controller.Game Edition");
    }
}

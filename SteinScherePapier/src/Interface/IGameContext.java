package Interface;

import Controller.Game;
import Entity.GameElement;

import java.util.HashMap;

public interface IGameContext {
    public void setup(HashMap<Integer, GameElement> gameElementHashMap);
    public void run(Game game);
}

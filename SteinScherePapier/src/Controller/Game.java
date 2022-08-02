package Controller;

import Entity.CompareEnum;
import Entity.GameElement;
import Interface.IGameContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    HashMap<Integer, GameElement> gameElementHashMap = new HashMap<>();

    public void setGameContext(IGameContext iGameContext) {
        this.iGameContext = iGameContext;
    }

    private IGameContext iGameContext;
    public Game(IGameContext iGameContext) {
        this.iGameContext = iGameContext;
    }

    public HashMap<Integer, GameElement> getPlayerInput(){
        HashMap<Integer, GameElement> auswahl = new HashMap<>();
        for (int i = 1; i <= 2; i++) {
            System.out.println("Bitte Spieler "+i + " wähle dein Element.");
            for (Map.Entry<Integer, GameElement> entry : gameElementHashMap.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue().getId();
                System.out.println(value + " " + entry.getValue().getName());
            }
            Scanner sc = new Scanner(System.in);
            auswahl.put(i,this.gameElementHashMap.get(sc.nextInt()));
        }
        return auswahl;
    }

    public void run(){
        this.iGameContext.setup(gameElementHashMap);
        this.iGameContext.run(this);

        HashMap<Integer, GameElement> input = getPlayerInput();
        GameElement p1 = input.get(1);
        GameElement p2 = input.get(2);
        if (p1.compare(p2) == CompareEnum.equal){
            System.out.println("Unentschieden!");
        } else if (p1.compare(p2) == CompareEnum.stronger) {
            System.out.println("Player 1 gewinnt");
        } else{
            System.out.println("Player 2 gewinnt");
        }
    }
}

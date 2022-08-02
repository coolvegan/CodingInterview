package Entity;

import java.util.ArrayList;

public class GameElement {
    private int id;
    private String name;
    private ArrayList<GameElement> weakerElements = new ArrayList<>();

    public GameElement addWeakerElement(GameElement gameElement)
    {
        this.weakerElements.add(gameElement);
        return this;
    }

    public CompareEnum compare(GameElement gameElement){
        if(gameElement == this){
            return CompareEnum.equal;
        }
        for (GameElement element: weakerElements) {
            if(gameElement == element){
                return CompareEnum.stronger;
            }
        }
        return CompareEnum.weaker;
    }


    public GameElement(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

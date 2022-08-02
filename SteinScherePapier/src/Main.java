import Controller.Game;
import Implementation.BigBangTheoryGameContext;
import Implementation.StandardGameContext;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new StandardGameContext());
        game.run();
        game.setGameContext(new BigBangTheoryGameContext());
        System.out.println("\n\n");
        game.run();
    }
}

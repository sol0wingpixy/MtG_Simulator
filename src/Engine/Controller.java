package Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Family on 6/6/17.
 */
public class Controller {
    private Exile exile;
    private Stack stack;
    private Battlefield battlefield;
    private List<Player> players;

    public Controller(int playerNum)
    {
        exile = new Exile();

        stack = new Stack();
        battlefield = new Battlefield();
        players = new ArrayList<>();
        for(int i=0;i<playerNum;i++)
        {
            if(i==0)
                players.add(new Player(this,"MyDeck.txt",i));
            else
                players.add(new Player(this,"MyOtherDeck.txt",i));
            players.get(i).shuffle();
            players.get(i).draw(7);
        }

    }

    public Exile getExile() {
        return exile;
    }

    public Stack getStack() {
        return stack;
    }

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getOpponent(Player p)
    {
        if(p==players.get(0))
            return players.get(1);
        return players.get(0);
    }
}

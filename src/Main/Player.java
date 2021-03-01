package Main;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> cardsOfPlayer = new ArrayList<Card>();
    private boolean doesPlayerPlay = false;

    public Player(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setCard(Card card){
        cardsOfPlayer.add(card);
    }
    public Card getCard(int i){
        return cardsOfPlayer.get(i);
    }
    public int getArrayOfCardsLength(){
        return cardsOfPlayer.size();
    }
    public boolean getDoesPlayerPlay(){
        return doesPlayerPlay;
    }
    public void setDoesPlayerPlay(boolean doesPlayerPlay){
        this.doesPlayerPlay = doesPlayerPlay;
    }
}

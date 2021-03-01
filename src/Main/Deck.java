package Main;

import java.time.Period;
import java.util.ArrayList;

public class Deck {
    private int numberOfCards = 36;
    private ArrayList<Card> deckOfCards = new ArrayList<Card>();
    private String[] numbers = {"Шесть", "Семь", "Восемь", "Девять", "Десять", "Валет", "Дама", "Король", "Туз"};
    private String[] suits = {"Бубен", "Черв", "Треф", "Пик"};
    private int numberOfPlayers;

    public Deck(){
        setDeck();

    }
    private void setDeck(){
        for(int i = 0; i < suits.length; i++){
            for(int j = 0; j < numbers.length; j++){
                deckOfCards.add(new Card(numbers[j], suits[i]));
            }
        }
    }
    public ArrayList<Card> getDeckOfCards(){
        return deckOfCards;
    }
    public void shuffleDeck(){
        System.out.println("Тасуем карты...");
        int cardReplace1;
        int cardReplace2;
        Card cardReplace;
        for(int i = 0; i < 100; i++){
            cardReplace1 = (int)(Math.random() * 36);
            cardReplace2 = (int)(Math.random() * 36);
            cardReplace = deckOfCards.get(cardReplace1);
            deckOfCards.set(cardReplace1, deckOfCards.get(cardReplace2));
            deckOfCards.set(cardReplace2, cardReplace);

        }
    }
    public void showDeck(){
        int count = 0;
        for(Card i: getDeckOfCards()){
            if(count == 6){
                System.out.println();
                count = 0;
            }
            System.out.printf("/%s %s/    ", i.getValue(), i.getSuit());
            count++;
        }
    }
    public void giveCardToPlayer(Player player, int cards){
        for(int i = 0; i < cards; i++){
            player.setCard(deckOfCards.get(0));
            deckOfCards.remove(0);
        }

    }
    public void giveCardToPlayer(Player player){
            player.setCard(deckOfCards.get(0));
            deckOfCards.remove(0);
    }


}

package Main;

public class Card {
    private String value;
    private String suit;
    private String card;

    public Card(String value, String suit){
        this.value = value;
        this.suit = suit;
        this.card = value + " " + suit;
    }
    public String getValue(){
        return value;
    }
    public String getSuit(){
        return suit;
    }
    public String getCardName() {return card; }

    public static int getPointOfCard(Card card) {
        if (card.value.equals("Шесть")) return 6;
        else if (card.value.equals("Семь")) return 7;
        else if (card.value.equals("Восемь")) return 8;
        else if (card.value.equals("Девять")) return 9;
        else if (card.value.equals("Восемь")) return 8;
        else if (card.value.equals("Девять")) return 9;
        else if (card.value.equals("Десять")) return 10;
        else if (card.value.equals("Валет")) return 2;
        else if (card.value.equals("Дама")) return 3;
        else if (card.value.equals("Король")) return 4;
        else if (card.value.equals("Туз")) return 1;
        else return 0;
    }
}

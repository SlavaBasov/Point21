package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Players {
    private ArrayList<Player> players = new ArrayList<Player>();
    private int numberOfPlayers;

    public void setPlayersName(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.printf("Имя игрока №%d: ", i + 1);
            Scanner scan = new Scanner(System.in);
            players.add(new Player(scan.nextLine()));
        }
        this.numberOfPlayers = numberOfPlayers;
    }

    public Player getPlayers(int i) {
        return players.get(i);
    }

    public int getNumberOfPlayers(){
        return numberOfPlayers;
    }
    public void getCardOnHandAll() {
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("Карты на руках у игрока %s: ", players.get(i).getName());
            for (int j = 0; j < players.get(i).getArrayOfCardsLength(); j++) {
                System.out.printf("/%s/   ", players.get(i).getCard(j).getCardName());
            }
            System.out.println();
        }
    }
    public void getCardOnHand(Player player) {
        System.out.printf("Карты на руках у игрока %s: ", player.getName());
        for (int j = 0; j < player.getArrayOfCardsLength(); j++) {
            System.out.printf("/%s/   ", player.getCard(j).getCardName());
        }
        System.out.println();
    }
    public int getPlayerIndex(Player player){
        return players.indexOf(player);
    }
}


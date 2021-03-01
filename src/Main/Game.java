package Main;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.print("21 очко\nКоличество игроков от 1 до 5\nСколько человек играет? -  ");
        Scanning scan = new Scanning();
        int numberOfPlayers = scan.getScannerNumOfPlayersInt();

        Players players = new Players();
        players.setPlayersName(numberOfPlayers);
        Deck deck = new Deck();
        deck.shuffleDeck();
        System.out.println("Раздаем на руки по 2 карты...");
        int countOfCardsOnHands = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            for(int j = 0; j < 2; j++) {
                deck.giveCardToPlayer(players.getPlayers(i));
                countOfCardsOnHands++;
            }
        }

        ProcessOfGame processOfGame = new ProcessOfGame(players, deck);
        processOfGame.hwoIsFirst();

        processOfGame.game(processOfGame.getFirstPlayer());






    }
}

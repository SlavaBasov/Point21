package Main;

public class ProcessOfGame {
    Players players;
    Deck deck;
    private String hwoIsFirst;
    private Player firstPlayer;
    private Player currentPlayer = firstPlayer;
    private int variantOfGame;
    private int points = 0;
    private boolean doesAllPlayersPlay = false;
    private boolean gameIsContinue = true;
    private int maxPoints = 0;
    private Player winner = null;


    public ProcessOfGame(Players players, Deck deck){
        this.players = players;
        this.deck = deck;
    }
    public void hwoIsFirst(){
        System.out.println("Кто ходит первый? Нажмите цифру напротив имени игрока, игроки ходят по очереди, или же дать волю случаю и пусть решит рандом?");
        for(int i = 0; i < players.getNumberOfPlayers(); i++){
            System.out.print(players.getPlayers(i).getName() + "-" + (i + 1) + "  ");
        }
        System.out.print("Определить рандомно-R");
        System.out.println();
        hwoIsFirst = Scanning.getScannerResultHwoISFirst(players);
        if(hwoIsFirst.equals("r") || hwoIsFirst.equals("R")){
            hwoIsFirst = Integer.toString((int) (Math.random() * players.getNumberOfPlayers() + 1));
        }
        System.out.println("Первым ходит " + players.getPlayers(Integer.parseInt(hwoIsFirst) - 1).getName());
        firstPlayer = players.getPlayers(Integer.parseInt(hwoIsFirst) - 1);

    }
    public String getHwoIsFirst(){
        return hwoIsFirst;
    }
    public Player getFirstPlayer(){
        return firstPlayer;
    }

    public void gameVariations(Player player){
        currentPlayer = player;
        currentPlayer.setDoesPlayerPlay(true);
        for(int i = 0; i < players.getNumberOfPlayers(); i++){
            if(players.getPlayers(i).getDoesPlayerPlay() == true){
                doesAllPlayersPlay = true;
            }
            else {
                doesAllPlayersPlay = false;
                break;
            }
        }
        System.out.println("Варианты хода - 1.Посмотреть карты на руках | 2.Набрать одну карту | 3.Показать количество очков | 4.Хватит");
        System.out.print(currentPlayer.getName() + ", ваш ход - ");
        variantOfGame = Scanning.getScannerResultVariantsOfGame(players);
        if(variantOfGame == 1){
            players.getCardOnHand(currentPlayer);
            System.out.println("Всего очков: " + pointCounter(currentPlayer));
            game(currentPlayer);
        }
        else if(variantOfGame == 2){
            deck.giveCardToPlayer(currentPlayer, 1);
            System.out.printf("Игрок %s вытащил карту %s", currentPlayer.getName(), currentPlayer.getCard(player.getArrayOfCardsLength() - 1).getCardName());
            System.out.println(" Всего очков: " + pointCounter(currentPlayer));
            if(pointCounter(currentPlayer) > 21){
                System.out.println("Перебор!");

                System.out.println("-------------------------------------------------------\n" +
                        "Игрок " + currentPlayer.getName() + " закончил ход.");
                if(players.getPlayerIndex(currentPlayer) == players.getNumberOfPlayers() - 1 || doesAllPlayersPlay == true) {
                    if(!doesAllPlayersPlay){
                        currentPlayer = players.getPlayers(0);
                        game(currentPlayer);
                    }
                    else{
                        System.out.println("Все игроки сделали свои ходы");
                        endGame();
                    }
                }
                else {
                    currentPlayer = players.getPlayers(players.getPlayerIndex(currentPlayer) + 1);
                    System.out.println("Следующий игрок - " + currentPlayer.getName());
                    game(currentPlayer);
                }
            }
            else game(currentPlayer);
        }
        else if(variantOfGame == 3){
            System.out.println("Всего очков у игрока " + currentPlayer.getName() + ": " + pointCounter(currentPlayer));
            game(currentPlayer);
        }
        else if(variantOfGame == 4){
            System.out.println("-------------------------------------------------------\n" +
                    "Игрок " + currentPlayer.getName() + " закончил ход.");
            if(players.getPlayerIndex(currentPlayer) == players.getNumberOfPlayers() - 1 || doesAllPlayersPlay == true) {
                if(!doesAllPlayersPlay){
                    currentPlayer = players.getPlayers(0);
                    game(currentPlayer);
                }
                else{
                System.out.println("Все игроки сделали свои ходы");
                endGame();
                }
            }
             else {
                currentPlayer = players.getPlayers(players.getPlayerIndex(currentPlayer) + 1);
                System.out.println("Следующий игрок - " + currentPlayer.getName());
                game(currentPlayer);
            }
        }
    }
    public void game(Player player){
            gameVariations(player);
    }

    public void endGame(){
        System.out.println("Подсчет результатов...\n");
        for(int i = 0; i < players.getNumberOfPlayers(); i++){
            System.out.print("Игрок " + players.getPlayers(i).getName() + " набрал " + pointCounter(players.getPlayers(i)) + " очков");
            if(pointCounter(players.getPlayers(i)) > 21) System.out.println(" - Перебор");
            else System.out.println();
            if(pointCounter(players.getPlayers(i)) <= 21){
                winner = players.getPlayers(i);
            }
        }
        if(players.getNumberOfPlayers() > 1) {
            for (int i = 0; i < players.getNumberOfPlayers(); i++) {
                if (pointCounter(winner) < pointCounter(players.getPlayers(i)) && pointCounter(players.getPlayers(i)) <= 21) {
                    maxPoints = maxPoints = pointCounter(players.getPlayers(i));
                    winner = players.getPlayers(i);
                }
            }
        }
        if(winner != null) {
            System.out.println("Выиграл игрок " + winner.getName());
            System.out.println("Конец игры.");
        }
        else System.out.println("Ничья!");
    }
    public int pointCounter(Player player){
        int points = 0;
        for(int i = 0; i < player.getArrayOfCardsLength(); i++){
            points += Card.getPointOfCard(player.getCard(i));
        }
        return points;
    }
}

package Main;

import java.util.Scanner;

public class Scanning {
    private static String scannerResultHwoISFirst;
    private int scannerNumOfPlayers;
    private static int scannerNumVariantOfGame = 1;
    private static int scannerNum;

    private void checkNumOfPlayers(){
        Scanner scan = new Scanner(System.in);
        if(scan.hasNextInt()){
            int num = Integer.parseInt(scan.nextLine());
            if(num > 5) {
                System.out.print("Игроков не может быть больше 5, попробуйте еще раз  - ");
                checkNumOfPlayers();
            }
            else if(num <= 0){
                System.out.print("Недопустимое количество игроков, попробуйте еще раз  - ");
                checkNumOfPlayers();
            }
            else {
                scannerNumOfPlayers = num;
            }
        }
        else {
            System.out.print("Вы ввели не число, попробуйте еще раз -  ");
            checkNumOfPlayers();
        }
    }
    public int getScannerNumOfPlayersInt(){
        checkNumOfPlayers();
        return scannerNumOfPlayers;
    }

    private static void checkHwoIsFirst(Players players){
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] array = new String[players.getNumberOfPlayers() + 2];
        array[array.length - 1] = "r";
        array[array.length - 2] = "R";
        for(int i = 0; i < players.getNumberOfPlayers(); i++){
            array[i] = Integer.toString(i + 1);
        }
        boolean check = false;
        for(String i: array){
            if(str.equals(i)){
                scannerResultHwoISFirst = i;
                check = true;
                break;
            }
        }
        if(!check){
            System.out.print("Некорректный ввод, попробуйте еще раз - ");
            checkHwoIsFirst(players);
        }
    }
    public static String getScannerResultHwoISFirst(Players players){
        checkHwoIsFirst(players);
        return scannerResultHwoISFirst;
    }
    private static void checkVariantsOfGame(Players players) {
        try {
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            int num = Integer.parseInt(str);
            if (num == 1 || num == 2 || num == 3 || num == 4) {
                scannerNumVariantOfGame = num;
            } else {
                System.out.print("Некорректный ввод, попробуйте еще раз - ");
                checkVariantsOfGame(players);
            }
        }
        catch (Exception ex){
            System.out.print("Некорректный ввод, попробуйте еще раз - ");
            checkVariantsOfGame(players);
        }
    }

    public static int getScannerResultVariantsOfGame(Players players){
        checkVariantsOfGame(players);
        return scannerNumVariantOfGame;
    }
    public static int scannerOfNums(){
        checkScannerOfNums();
        return scannerNum;
    }
    private static void checkScannerOfNums() {
        try {
            Scanner scan = new Scanner(System.in);
            String str = scan.nextLine();
            int num = Integer.parseInt(str);
            scannerNum = num;
        }
        catch (Exception ex){
            System.out.print("Некорректный ввод, попробуйте еще раз - ");
            checkScannerOfNums();
        }
    }





}

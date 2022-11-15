package Facade;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static String style = "0.20/0.40";
    private static boolean isShooter = true;
    private static double startMoney = 21.40;
    private static boolean isGameOver = false;

    private static final HashMap<String, double[]> payOff = new HashMap<>();
    private static final HashMap<Integer, Player> players = new HashMap<>();
    private static final ArrayList <Player> playerList = new ArrayList<>();
    private static final String[] family = {" ", "Dad", "Mum", "Joel", "Jillian", "Joshua", "Sze"};
    private static final String[] NCMU8 = {" ", "Elgin", "Jerry", "Joshua", "Jun Xiong", "Sze", "Tarasvin", "Victoria"};
    private static final String[] listOfPlayers = NCMU8;
    private static final String[] styles = {"0.20/0.40", "3/6 half", "3/6"};

    private static Player playerOne;
    private static Player playerTwo;
    private static Player playerThree;
    private static Player playerFour;

    public static void setIsGameOver() {
        isGameOver = true;
    }

    public static boolean getIsGameOver() {
        return isGameOver;
    }

    public static void setIsShooter(int choice) {
        isShooter = choice == 1;
    }

    public static boolean getIsShooter() {
        return isShooter;
    }

    public static void setStyle(String choice) {
        style = choice;
    }

    public static void setStartMoney(double choice) {
        startMoney = choice;
    }

    public static double getStartMoney() {
        return startMoney;
    }

    public static void setUp(){
        //Store lists of money won for each tai
        double[] lst1 = {0.20, 0.40, 0.80, 1.60, 3.20, 6.40};
        payOff.put("0.20/0.40", lst1);
        double[] lst2 = {0.5, 1, 1.50, 2.50, 5, 10};
        payOff.put("3/6 half", lst2);
        double[] lst3 = {1, 2, 3, 5, 10, 20};
        payOff.put("3/6", lst3);
        Ledger.addToLedger(1, 1, 0);
        playerList.addAll(players.values());
        WindControl.currentWind = 1;
    }

    public static boolean isValid() {
        for (int i = 1; i < 5; i++) {
            if (players.get(i).getName().equals(" ")) {
                return false;
            }
            for (int j = i + 1; j < 5; j++) {
                if (players.get(i).getName().equals(players.get(j).getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static String[] getListOfPlayers(){
        return listOfPlayers;
    }

    public static String[] getStyles() {
        return styles;
    }

    public static double payOut(int tai) {
        return payOff.get(style)[tai];
    }

    public static ArrayList<Player> getPlayers() {
        return playerList;
    }

    //Player setters
    public static void setPlayerOne(String name){
        playerOne = new Player(name, 1, startMoney);
        players.put(1, playerOne);
    }
    public static void setPlayerTwo(String name){
        playerTwo = new Player(name, 2, startMoney);
        players.put(2, playerTwo);
    }
    public static void setPlayerThree(String name){
        playerThree = new Player(name, 3, startMoney);
        players.put(3, playerThree);
    }
    public static void setPlayerFour(String name){
        playerFour = new Player(name, 4, startMoney);
        players.put(4, playerFour);
    }

    //Player getters
    public static Player getPlayerOne() {
        return playerOne;
    }
    public static Player getPlayerTwo() {
        return playerTwo;
    }
    public static Player getPlayerThree() {
        return playerThree;
    }
    public static Player getPlayerFour() {
        return playerFour;
    }
}

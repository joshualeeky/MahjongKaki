package Facade;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class WindControl {
    private static ImageIcon scaleImage(String img) {
        ImageIcon imageIcon = new ImageIcon(img);
        Image image = imageIcon.getImage(); //
        Image newImg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    static final ImageIcon dongFeng = scaleImage("imgs/Dong.jpg");
    static final ImageIcon nanFeng = scaleImage("imgs/Nan.jpg");
    static final ImageIcon xiFeng = scaleImage("imgs/Xi.jpg");
    static final ImageIcon beiFeng = scaleImage("imgs/Bei.jpg");
    static final HashMap<Integer, ImageIcon> wind = new HashMap<>() {{
        put(1, dongFeng);
        put(2, nanFeng);
        put(3, xiFeng);
        put(4, beiFeng);
    }};
    static final HashMap<Integer, String> windChar = new HashMap<>() {{
        put(1, "東");
        put(2, "南");
        put(3, "西");
        put(4, "北");
    }};
    static int playerCount = 1;
    static int stay = 0;
    static int currentWind;

    public static ImageIcon getWind(int windNumber){
        return wind.get(windNumber);
    }

    public static int getCurrentWind(){
        return currentWind;
    }

    public static void prevPlayer() {
        if (Transaction.getWinner() != null && !Transaction.getDidWindChange()) {
            return;
        }
        Storage.getPlayerOne().reverseWind();
        Storage.getPlayerTwo().reverseWind();
        Storage.getPlayerThree().reverseWind();
        Storage.getPlayerFour().reverseWind();

        playerCount--;
        if (playerCount == 0) {
            playerCount = 4;
            currentWind--;
        }
    }

    public static String getWindChar(int wind) {
        return windChar.get(wind);
    }

    public static void nextPlayer() {
        if (Transaction.getWinner() != null && Transaction.getWinner().getWind() == 1) {
            stay++;
            Ledger.addToLedger(currentWind, playerCount, stay);
            return;
        }
        stay = 0;
        playerCount++;
        Storage.getPlayerOne().changeWind();
        Storage.getPlayerTwo().changeWind();
        Storage.getPlayerThree().changeWind();
        Storage.getPlayerFour().changeWind();

        if (playerCount == 5) {
            playerCount = 1;
            currentWind++;
        }
        Ledger.addToLedger(currentWind, playerCount, stay);
    }
}

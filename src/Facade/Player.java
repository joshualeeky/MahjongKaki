package Facade;

import java.util.ArrayList;

public class Player {
    final String name;
    int wind;
    double money;
    final ArrayList<Double> history = new ArrayList<>();

    public Player(String name, int wind, double money) {
        this.name = name;
        this.wind = wind;
        this.money = money;
    }

    public String getName(){
        return name;
    }

    public int getWind(){
        return wind;
    }

    public String getNettDifference(){
        double diff = money - Storage.getStartMoney();
        if (diff > 0.000) {
            return "+" + String.format("%.2f", diff);
        } else {
            return String.format("%.2f", diff);
        }
    }

    public String getMoney(){
        return String.format("%.2f", money);
    }

    public void decreaseMoney(double amt){
        money -= amt;
        history.add(-amt);
        if (money <= 0.000) {
            Storage.setIsGameOver();
        }
    }

    public void increaseMoney(double amt){
        money += amt;
        history.add(amt);
    }

    public void undoMoney() {
        int lastIndex = history.size() - 1;
        money -= history.get(lastIndex);
        history.remove(lastIndex);
    }

    public ArrayList<Double> getHistory() {
        return history;
    }

    public void reverseWind() {
        wind++;
        if (wind == 5) {
            wind = 1;
        }
    }

    public void changeWind(){
        wind--;
        if (wind == 0) {
            wind = 4;
        }
    }

}

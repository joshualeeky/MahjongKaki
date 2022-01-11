package Facade;

import java.util.ArrayList;

public class Ledger {
    static final ArrayList<String> ledger = new ArrayList<>();

    public static void addToLedger(Player winner, Player shooter, int tai, ArrayList<Player> lastTransactionPlayers, String win) {
        StringBuilder entry = new StringBuilder(winner.getName() + " won $");
        if (tai == -1) {
            entry.append(String.format("%.2f", Storage.payOut(1)));
        } else if (tai == -2) {
            entry.append(String.format("%.2f", Storage.payOut(0)));
        } else if (winner == shooter) {
            entry.append(String.format("%.2f", Storage.payOut(tai) * 3));
        } else {
            entry.append(String.format("%.2f", Storage.payOut(tai - 1) * 4));
        }
        entry.append(" from ");
        lastTransactionPlayers.remove(winner);
        for (Player player : lastTransactionPlayers) {
            if (lastTransactionPlayers.indexOf(player) == lastTransactionPlayers.size() - 1) {
                entry.append(player.getName()).append(" ($").append(String.format("%.2f", player.getHistory().get(player.getHistory().size() - 1))).append("). ");
            } else {
                entry.append(player.getName()).append(" ($").append(String.format("%.2f",player.getHistory().get(player.getHistory().size() - 1))).append("), ");
            }
        }
        if (win.equals("tai")) {
            entry.append("[").append(tai).append("台").append("]");
        } else {
            entry.append("[").append(win).append("]");
        }

        ledger.add(entry.toString());
        lastTransactionPlayers.add(winner);
    }

    public static void addToLedger(int wind, int windPart, int stay) {
        if (stay == 0) {
            ledger.add(WindControl.getWindChar(wind) + " - " + windPart);
        } else {
            ledger.add(WindControl.getWindChar(wind) + " - " + windPart + " (" + stay + ")");
        }
    }

    public static void printLedger() {
        for (String entry : ledger) {
            System.out.println(entry);
        }
    }

    public static ArrayList<String> getLedger() {
        return ledger;
    }

    public static void removeFromLedger() {
        if (ledger.get(ledger.size() - 1).contains("$")) {
            ledger.remove(ledger.size() - 1);
        } else {
            ledger.remove(ledger.size() - 1);
            ledger.remove(ledger.size() - 1);
        }
    }


}

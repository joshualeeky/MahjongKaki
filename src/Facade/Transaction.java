package Facade;

import java.util.ArrayList;

public class Transaction {

    private static final int AN_YAO = 0;
    private static final int MING_YAO = -1;
    private static final int GANG = -2;
    private static final int AN_GANG = -3;
    private static final int MING_GANG = -4;

    private static Player winner;
    private static Player shooter;
    private static int winAmount;
    private static ArrayList <Player> lastTransactionPlayers;
    private static boolean didWindChange;


    public static boolean getDidWindChange() {
        return didWindChange;
    }

    public static void setWinAmount(int amount) {
        winAmount = amount;
    }

    public static int getWinAmount() {
        return winAmount;
    }

    public static void setShooter(Player player) {
        shooter = player;
    }

    public static Player getShooter() {
        return shooter;
    }

    public static void setWinner(Player player) {
        winner = player;
    }

    public static Player getWinner() {
        return winner;
    }

    public static void undoPayment() {
        WindControl.prevPlayer();
        Ledger.removeFromLedger();
        if (winner != null && shooter != null) {
            for (Player player : lastTransactionPlayers) {
                player.undoMoney();
            }
        }
    }

    private static void setLastTransactionPlayers() {
        lastTransactionPlayers = Storage.getPlayers();
    }

    private static void setLastTransactionPlayers(Player shooter, Player winner) {
        lastTransactionPlayers = new ArrayList<>();
        lastTransactionPlayers.add(shooter);
        lastTransactionPlayers.add(winner);
    }

    public static void giveMoney() {
        if (Storage.getIsShooter()) {
            shooterStyle();
        } else {
            normalStyle();
        }
    }

    private static void shooterStyle() {
        if (winAmount == GANG) {
            winner.increaseMoney(Storage.payOut(0) * 4);
            shooter.decreaseMoney(Storage.payOut(0) * 4);
            didWindChange = false;
            setLastTransactionPlayers(shooter, winner);
            Ledger.addToLedger(winner, shooter, 1, lastTransactionPlayers, "杠");

        } else if(winAmount == AN_GANG) {
            for (Player player : Storage.getPlayers()) {
                if (player == winner) {
                    player.increaseMoney(Storage.payOut(1) * 3);
                } else {
                    player.decreaseMoney(Storage.payOut(1));
                }
            }
            didWindChange = false;
            setLastTransactionPlayers();
            Ledger.addToLedger(winner, winner, 1, lastTransactionPlayers, "暗杠");

        } else if(winAmount == MING_GANG) {
            for (Player player : Storage.getPlayers()) {
                if (player == winner) {
                    player.increaseMoney(Storage.payOut(0) * 3);
                } else {
                    player.decreaseMoney(Storage.payOut(0));
                }
            }
            didWindChange = false;
            setLastTransactionPlayers();
            Ledger.addToLedger(winner, winner, 0, lastTransactionPlayers, "明杠");

        } else if(winAmount == AN_YAO) {
            if (winner == shooter) {
                for (Player player : Storage.getPlayers()) {
                    if (player == winner) {
                        player.increaseMoney(Storage.payOut(1) * 3);
                    } else {
                        player.decreaseMoney(Storage.payOut(1));
                    }
                }
                setLastTransactionPlayers();
                Ledger.addToLedger(winner, winner, 1, lastTransactionPlayers, "暗咬自己");

            } else {
                winner.increaseMoney(Storage.payOut(1));
                shooter.decreaseMoney(Storage.payOut(1));
                setLastTransactionPlayers(shooter, winner);
                Ledger.addToLedger(winner, shooter, -1, lastTransactionPlayers, "暗咬");
            }
            didWindChange = false;

        } else if (winAmount == MING_YAO) {
            if (winner == shooter) {
                for (Player player : Storage.getPlayers()) {
                    if (player == winner) {
                        player.increaseMoney(Storage.payOut(0) * 3);
                    } else {
                        player.decreaseMoney(Storage.payOut(0));
                    }
                }
                setLastTransactionPlayers();
                Ledger.addToLedger(winner, shooter, 0, lastTransactionPlayers, "明咬自己");

            } else {
                winner.increaseMoney(Storage.payOut(0));
                shooter.decreaseMoney(Storage.payOut(0));
                setLastTransactionPlayers(shooter, winner);
                Ledger.addToLedger(winner, shooter, -2, lastTransactionPlayers, "明咬");
            }
            didWindChange = false;

        } else {
            if (shooter == winner) {
                for (Player player : Storage.getPlayers()) {
                    if (player == winner) {
                        player.increaseMoney(Storage.payOut(winAmount) * 3);
                    } else {
                        player.decreaseMoney(Storage.payOut(winAmount));
                    }
                }
                setLastTransactionPlayers();

            } else {
                winner.increaseMoney(Storage.payOut(winAmount - 1) * 4);
                shooter.decreaseMoney(Storage.payOut(winAmount - 1) * 4);
                setLastTransactionPlayers(shooter, winner);
            }
            Ledger.addToLedger(winner, shooter, winAmount, lastTransactionPlayers, "tai");
            didWindChange = winner.getWind() != 1;
            WindControl.nextPlayer();
        }
    }

    private static void normalStyle() {
        if (winAmount == GANG) {
            for (Player player : Storage.getPlayers()) {
                if (player == winner) {
                    player.increaseMoney(Storage.payOut(0) * 4);
                } else if (player == shooter) {
                    player.decreaseMoney(Storage.payOut(0) * 2);
                } else {
                    player.decreaseMoney(Storage.payOut(0));
                }
            }
            didWindChange = false;
            setLastTransactionPlayers();
            Ledger.addToLedger(winner, shooter, 1, lastTransactionPlayers, "杠");

        } else if(winAmount == AN_GANG) {
            for (Player player : Storage.getPlayers()) {
                if (player == winner) {
                    player.increaseMoney(Storage.payOut(1) * 3);
                } else {
                    player.decreaseMoney(Storage.payOut(1));
                }
            }
            didWindChange = false;
            setLastTransactionPlayers();
            Ledger.addToLedger(winner, winner, 1, lastTransactionPlayers, "暗杠");

        } else if(winAmount == MING_GANG) {
            for (Player player : Storage.getPlayers()) {
                if (player == winner) {
                    player.increaseMoney(Storage.payOut(0) * 3);
                } else {
                    player.decreaseMoney(Storage.payOut(0));
                }
            }
            didWindChange = false;
            setLastTransactionPlayers();
            Ledger.addToLedger(winner, winner, 0, lastTransactionPlayers, "明杠");

        } else if(winAmount == AN_YAO) {
            if (winner == shooter) {
                for (Player player : Storage.getPlayers()) {
                    if (player == winner) {
                        player.increaseMoney(Storage.payOut(1) * 3);
                    } else {
                        player.decreaseMoney(Storage.payOut(1));
                    }
                }
                setLastTransactionPlayers();
                Ledger.addToLedger(winner, winner, 1, lastTransactionPlayers, "暗咬自己");

            } else {
                winner.increaseMoney(Storage.payOut(1));
                shooter.decreaseMoney(Storage.payOut(1));
                setLastTransactionPlayers(shooter, winner);
                Ledger.addToLedger(winner, shooter, -1, lastTransactionPlayers, "暗咬");
            }
            didWindChange = false;

        } else if (winAmount == MING_YAO) {
            if (winner == shooter) {
                for (Player player : Storage.getPlayers()) {
                    if (player == winner) {
                        player.increaseMoney(Storage.payOut(0) * 3);
                    } else {
                        player.decreaseMoney(Storage.payOut(0));
                    }
                }
                setLastTransactionPlayers();
                Ledger.addToLedger(winner, winner, 0, lastTransactionPlayers, "明咬自己");

            } else {
                winner.increaseMoney(Storage.payOut(0));
                shooter.decreaseMoney(Storage.payOut(0));
                setLastTransactionPlayers(shooter, winner);
                Ledger.addToLedger(winner, shooter, -2, lastTransactionPlayers, "明咬");
            }
            didWindChange = false;

        } else {
            if (shooter == winner) {
                for (Player player : Storage.getPlayers()) {
                    if (player == winner) {
                        player.increaseMoney(Storage.payOut(winAmount) * 3);
                    } else {
                        player.decreaseMoney(Storage.payOut(winAmount));
                    }
                }
            } else {
                for (Player player : Storage.getPlayers()) {
                    if (player == winner) {
                        player.increaseMoney(Storage.payOut(winAmount - 1) * 4);
                    } else if (player == shooter){
                        player.decreaseMoney(Storage.payOut(winAmount - 1) * 2);
                    } else {
                        player.decreaseMoney(Storage.payOut(winAmount - 1));
                    }
                }
            }
            didWindChange = winner.getWind() != 1;
            setLastTransactionPlayers();
            Ledger.addToLedger(winner, shooter, winAmount, lastTransactionPlayers, "tai");
            WindControl.nextPlayer();
        }
    }
}

package UI;

import Facade.Ledger;
import Facade.Player;
import Facade.Storage;

import javax.swing.*;
import java.awt.*;

public interface GameOverInterface extends GUI {
    static void GUI() {
        JPanel gameOverPanel = new JPanel(new GridBagLayout());

        //Text Area of all transactions
        JLabel gameOverHeader = new JLabel("GAME OVER", SwingConstants.CENTER);
        gameOverHeader.setFont(fontBig);
        StringBuilder ledgerString = new StringBuilder();
        for (Player player : Storage.getPlayers()) {
            ledgerString.append(player.getName()).append(": $").append(player.getMoney()).append(" (")
                    .append(player.getNettDifference()).append(")").append(System.lineSeparator());
        }
        ledgerString.append("______________________________________________________________");
        ledgerString.append(System.lineSeparator());
        for (String entry : Ledger.getLedger()) {
            ledgerString.append(entry).append(System.lineSeparator());
        }
        JTextArea ledger = new JTextArea(15, 40);
        ledger.append(ledgerString.toString());
        ledger.setEditable(false);
        ledger.setFont(fontMedium2);
        JScrollPane scroll = new JScrollPane(ledger);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);


        GridBagConstraints cGameOverHeader = new GridBagConstraints();
        GridBagConstraints cScroll = new GridBagConstraints();

        cGameOverHeader.fill = GridBagConstraints.HORIZONTAL;
        cGameOverHeader.gridx = 0;
        //cGameOverHeader.gridwidth = 3;
        cGameOverHeader.gridy = 0;
        cGameOverHeader.insets = new Insets(10, 0, 0 ,0);
        gameOverPanel.add(gameOverHeader, cGameOverHeader);

        cScroll.fill = GridBagConstraints.HORIZONTAL;
        cScroll.gridx = 0;
        //cScroll.gridwidth = 3;
        cScroll.gridy = 1;
        cScroll.insets = new Insets(15, 100, 50 ,100);
        gameOverPanel.add(scroll, cScroll);


        frame.add(gameOverPanel);
        frame.setVisible(true);
    }
}


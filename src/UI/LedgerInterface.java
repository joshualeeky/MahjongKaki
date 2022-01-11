package UI;

import Facade.Ledger;
import Facade.Player;
import Facade.Storage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface LedgerInterface extends GUI {
    static void GUI(boolean isUndo) {
        JPanel ledgerPanel = new JPanel(new GridBagLayout());

        //Text Area of all transactions
        JLabel ledgerLabel = new JLabel("Ledger", SwingConstants.CENTER);
        ledgerLabel.setFont(fontBig);
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


        JButton back = new JButton("Back");
        back.setVerticalTextPosition(SwingConstants.NORTH);
        back.setHorizontalTextPosition(SwingConstants.CENTER);
        back.setPreferredSize(new Dimension(100, 20));
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(ledgerPanel);
                MainInterface.GUI(isUndo);
            }
        });

        GridBagConstraints cLedgerLabel = new GridBagConstraints();
        GridBagConstraints cScroll = new GridBagConstraints();
        GridBagConstraints cBack = new GridBagConstraints();

        cBack.fill = GridBagConstraints.HORIZONTAL;
        cBack.gridx = 3;
        cBack.gridy = 0;
        cBack.insets = new Insets(10, 30, 0 ,40);
        ledgerPanel.add(back, cBack);

        cLedgerLabel.fill = GridBagConstraints.HORIZONTAL;
        cLedgerLabel.gridx = 0;
        cLedgerLabel.gridwidth = 3;
        cLedgerLabel.gridy = 0;
        cLedgerLabel.insets = new Insets(10, 0, 0 ,0);
        ledgerPanel.add(ledgerLabel, cLedgerLabel);

        cScroll.fill = GridBagConstraints.HORIZONTAL;
        cScroll.gridx = 0;
        cScroll.gridwidth = 3;
        cScroll.gridy = 1;
        cScroll.insets = new Insets(15, 25, 50 ,0);
        ledgerPanel.add(scroll, cScroll);


        frame.add(ledgerPanel);
        frame.setVisible(true);
    }
}

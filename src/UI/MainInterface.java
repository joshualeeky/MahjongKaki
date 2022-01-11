package UI;

import Facade.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface MainInterface extends GUI {
    static void GUI(boolean isUndo) {
        JPanel buttonPanel = new JPanel(new GridBagLayout());

        if (Storage.getIsGameOver()){
            frame.remove(buttonPanel);
            GameOverInterface.GUI();
        }

        //Wind Indicator
        JLabel commonWind = new JLabel("Common Wind", WindControl.getWind(WindControl.getCurrentWind()), SwingConstants.CENTER);
        commonWind.setFont(fontMedium);
        commonWind.setVerticalTextPosition(SwingConstants.NORTH);
        commonWind.setHorizontalTextPosition(SwingConstants.CENTER);

        //Player wind indicator
        JLabel headerLabel = new JLabel("Who won money?", SwingConstants.CENTER);
        headerLabel.setFont(fontMedium);
        headerLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Player Buttons
        JButton player1 = new JButton(Storage.getPlayerOne().getName(), WindControl.getWind(Storage.getPlayerOne().getWind()));
        player1.setFont(fontMedium);
        player1.setVerticalTextPosition(SwingConstants.NORTH);
        player1.setHorizontalTextPosition(SwingConstants.CENTER);
        player1.setPreferredSize(new Dimension(180, 180));
        player1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(buttonPanel);
                Transaction.setWinner(Storage.getPlayerOne());
                ChooseTaiInterface.GUI();
            }
        });

        JButton player2 = new JButton(Storage.getPlayerTwo().getName(), WindControl.getWind(Storage.getPlayerTwo().getWind()));
        player2.setFont(fontMedium);
        player2.setVerticalTextPosition(SwingConstants.NORTH);
        player2.setHorizontalTextPosition(SwingConstants.CENTER);
        player2.setPreferredSize(new Dimension(180, 180));
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(buttonPanel);
                Transaction.setWinner(Storage.getPlayerTwo());
                ChooseTaiInterface.GUI();
            }
        });

        JButton player3 = new JButton(Storage.getPlayerThree().getName(), WindControl.getWind(Storage.getPlayerThree().getWind()));
        player3.setFont(fontMedium);
        player3.setVerticalTextPosition(SwingConstants.NORTH);
        player3.setHorizontalTextPosition(SwingConstants.CENTER);
        player3.setPreferredSize(new Dimension(180, 180));
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(buttonPanel);
                Transaction.setWinner(Storage.getPlayerThree());
                ChooseTaiInterface.GUI();
            }
        });

        JButton player4 = new JButton(Storage.getPlayerFour().getName(), WindControl.getWind(Storage.getPlayerFour().getWind()));
        player4.setFont(fontMedium);
        player4.setVerticalTextPosition(SwingConstants.NORTH);
        player4.setHorizontalTextPosition(SwingConstants.CENTER);
        player4.setPreferredSize(new Dimension(180, 180));
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(buttonPanel);
                Transaction.setWinner(Storage.getPlayerFour());
                ChooseTaiInterface.GUI();
            }
        });

        JButton next = new JButton("Draw with Kang");
        next.setVerticalTextPosition(SwingConstants.NORTH);
        next.setHorizontalTextPosition(SwingConstants.CENTER);
        next.setPreferredSize(new Dimension(20, 20));
        next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(buttonPanel);
                Transaction.setWinner(null);
                Transaction.setShooter(null);
                WindControl.nextPlayer();
                GUI(false);
            }
        });

        JButton ledger = new JButton("Ledger");
        ledger.setVerticalTextPosition(SwingConstants.NORTH);
        ledger.setHorizontalTextPosition(SwingConstants.CENTER);
        ledger.setPreferredSize(new Dimension(20, 20));
        ledger.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(buttonPanel);
                LedgerInterface.GUI(isUndo);
            }
        });

        if (!isUndo) {
            JButton undo = new JButton("Undo");
            undo.setVerticalTextPosition(SwingConstants.NORTH);
            undo.setHorizontalTextPosition(SwingConstants.CENTER);
            undo.setPreferredSize(new Dimension(20, 20));
            undo.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.remove(buttonPanel);
                    Transaction.undoPayment();
                    GUI(true);
                }
            });
            GridBagConstraints cUndo = new GridBagConstraints();
            cUndo.fill = GridBagConstraints.HORIZONTAL;
            cUndo.gridx = 0;
            cUndo.gridwidth = 1;
            cUndo.gridy = 1;
            cUndo.insets = new Insets(10, 10, 20 ,10);
            buttonPanel.add(undo, cUndo);
        }

        String lastEntryString = "";
        if (Ledger.getLedger().size() != 1) {
            for (int i = Ledger.getLedger().size() - 1; i >= 0; i--) {
                if (Ledger.getLedger().get(i).contains("$")) {
                    lastEntryString = Ledger.getLedger().get(i);
                    break;
                }
            }
        }
        JLabel lastEntry = new JLabel(lastEntryString, SwingConstants.CENTER);
        lastEntry.setVerticalAlignment(SwingConstants.BOTTOM);
        lastEntry.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints cCommonWind = new GridBagConstraints();
        GridBagConstraints cHeader = new GridBagConstraints();
        GridBagConstraints cNext = new GridBagConstraints();
        GridBagConstraints cLedger = new GridBagConstraints();
        GridBagConstraints cLastEntry = new GridBagConstraints();

        GridBagConstraints cPlayer1 = new GridBagConstraints();
        GridBagConstraints cPlayer2 = new GridBagConstraints();
        GridBagConstraints cPlayer3 = new GridBagConstraints();
        GridBagConstraints cPlayer4 = new GridBagConstraints();

        cCommonWind.fill = GridBagConstraints.HORIZONTAL;
        cCommonWind.gridx = 1;
        cCommonWind.gridwidth = 2;
        cCommonWind.gridy = 0;
        cCommonWind.insets = new Insets(10, 0, 20 ,0);
        buttonPanel.add(commonWind, cCommonWind);

        cHeader.fill = GridBagConstraints.HORIZONTAL;
        cHeader.gridx = 1;
        cHeader.gridwidth = 2;
        cHeader.gridy = 1;
        cHeader.insets = new Insets(10, 0, 20 ,0);
        buttonPanel.add(headerLabel, cHeader);

        cNext.fill = GridBagConstraints.HORIZONTAL;
        cNext.gridx = 3;
        cNext.gridwidth = 1;
        cNext.gridy = 1;
        cNext.insets = new Insets(10, 10, 20 ,10);
        buttonPanel.add(next, cNext);

        cLedger.fill = GridBagConstraints.HORIZONTAL;
        cLedger.gridx = 3;
        cLedger.gridwidth = 1;
        cLedger.gridy = 0;
        cLedger.insets = new Insets(10, 10, 20 ,10);
        buttonPanel.add(ledger, cLedger);

        cLastEntry.fill = GridBagConstraints.HORIZONTAL;
        cLastEntry.gridx = 1;
        cLastEntry.gridwidth = 2;
        cLastEntry.gridy = 3;
        cLastEntry.insets = new Insets(0, 0, 20 ,0);
        buttonPanel.add(lastEntry, cLastEntry);

        cPlayer1.fill = GridBagConstraints.HORIZONTAL;
        cPlayer1.gridx = 0;
        cPlayer1.gridy = 2;
        cPlayer1.insets = new Insets(10, 10, 10 ,10);
        buttonPanel.add(player1, cPlayer1);

        cPlayer2.fill = GridBagConstraints.HORIZONTAL;
        cPlayer2.gridx = 1;
        cPlayer2.gridy = 2;
        cPlayer2.insets = new Insets(10, 10, 10 ,10);
        buttonPanel.add(player2, cPlayer2);

        cPlayer3.fill = GridBagConstraints.HORIZONTAL;
        cPlayer3.gridx = 2;
        cPlayer3.gridy = 2;
        cPlayer3.insets = new Insets(10, 10, 10 ,10);
        buttonPanel.add(player3, cPlayer3);

        cPlayer4.fill = GridBagConstraints.HORIZONTAL;
        cPlayer4.gridx = 3;
        cPlayer4.gridy = 2;
        cPlayer4.insets = new Insets(10, 10, 10 ,10);
        buttonPanel.add(player4, cPlayer4);

        frame.add(buttonPanel);
        frame.setVisible(true);
    }
}

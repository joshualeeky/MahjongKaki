package UI;

import Facade.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ShooterInterface extends GUI {
    int KANG = -2;
    static void GUI(){
        JPanel shooterPanel = new JPanel(new GridBagLayout());

        //Player wind indicator
        JLabel headerLabel = new JLabel("Who shot?", SwingConstants.CENTER);
        headerLabel.setFont(fontBig);
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
                if (Transaction.getWinAmount() != KANG || Transaction.getWinner() != Storage.getPlayerOne()) {
                    Transaction.setShooter(Storage.getPlayerOne());
                    Transaction.giveMoney();
                    frame.remove(shooterPanel);
                    MainInterface.GUI(false);
                }
            }
        });

        JButton player2 = new JButton(Storage.getPlayerTwo().getName(), WindControl.getWind(Storage.getPlayerTwo().getWind()));
        player2.setFont(fontMedium);
        player2.setVerticalTextPosition(SwingConstants.NORTH);
        player2.setHorizontalTextPosition(SwingConstants.CENTER);
        player2.setPreferredSize(new Dimension(180, 180));
        player2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Transaction.getWinAmount() != KANG || Transaction.getWinner() != Storage.getPlayerTwo()) {
                    Transaction.setShooter(Storage.getPlayerTwo());
                    Transaction.giveMoney();
                    frame.remove(shooterPanel);
                    MainInterface.GUI(false);
                }
            }
        });

        JButton player3 = new JButton(Storage.getPlayerThree().getName(), WindControl.getWind(Storage.getPlayerThree().getWind()));
        player3.setFont(fontMedium);
        player3.setVerticalTextPosition(SwingConstants.NORTH);
        player3.setHorizontalTextPosition(SwingConstants.CENTER);
        player3.setPreferredSize(new Dimension(180, 180));
        player3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Transaction.getWinAmount() != KANG || Transaction.getWinner() != Storage.getPlayerThree()) {
                    Transaction.setShooter(Storage.getPlayerThree());
                    Transaction.giveMoney();
                    frame.remove(shooterPanel);
                    MainInterface.GUI(false);
                }
            }
        });

        JButton player4 = new JButton(Storage.getPlayerFour().getName(), WindControl.getWind(Storage.getPlayerFour().getWind()));
        player4.setFont(fontMedium);
        player4.setVerticalTextPosition(SwingConstants.NORTH);
        player4.setHorizontalTextPosition(SwingConstants.CENTER);
        player4.setPreferredSize(new Dimension(180, 180));
        player4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Transaction.getWinAmount() != KANG || Transaction.getWinner() != Storage.getPlayerFour()) {
                    Transaction.setShooter(Storage.getPlayerFour());
                    Transaction.giveMoney();
                    frame.remove(shooterPanel);
                    MainInterface.GUI(false);
                }
            }
        });

        GridBagConstraints cHeader = new GridBagConstraints();
        GridBagConstraints cPlayer1 = new GridBagConstraints();
        GridBagConstraints cPlayer2 = new GridBagConstraints();
        GridBagConstraints cPlayer3 = new GridBagConstraints();
        GridBagConstraints cPlayer4 = new GridBagConstraints();

        cHeader.fill = GridBagConstraints.HORIZONTAL;
        cHeader.gridx = 1;
        cHeader.gridwidth = 2;
        cHeader.gridy = 1;
        cHeader.insets = new Insets(10, 0, 20 ,0);
        shooterPanel.add(headerLabel, cHeader);

        cPlayer1.fill = GridBagConstraints.HORIZONTAL;
        cPlayer1.gridx = 0;
        cPlayer1.gridy = 2;
        cPlayer1.insets = new Insets(10, 10, 200 ,10);
        shooterPanel.add(player1, cPlayer1);

        cPlayer2.fill = GridBagConstraints.HORIZONTAL;
        cPlayer2.gridx = 1;
        cPlayer2.gridy = 2;
        cPlayer2.insets = new Insets(10, 10, 200 ,10);
        shooterPanel.add(player2, cPlayer2);

        cPlayer3.fill = GridBagConstraints.HORIZONTAL;
        cPlayer3.gridx = 2;
        cPlayer3.gridy = 2;
        cPlayer3.insets = new Insets(10, 10, 200 ,10);
        shooterPanel.add(player3, cPlayer3);

        cPlayer4.fill = GridBagConstraints.HORIZONTAL;
        cPlayer4.gridx = 3;
        cPlayer4.gridy = 2;
        cPlayer4.insets = new Insets(10, 10, 200 ,10);
        shooterPanel.add(player4, cPlayer4);

        frame.add(shooterPanel);
        frame.setVisible(true);
    }
}

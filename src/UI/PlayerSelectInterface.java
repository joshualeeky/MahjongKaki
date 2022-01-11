package UI;

import Facade.Storage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public interface PlayerSelectInterface extends GUI{
    static void GUI(){
        JPanel initPanel = new JPanel(new GridBagLayout());

        //Player 1
        JLabel choosePlayerOne = new JLabel("Who is 東風?", SwingConstants.CENTER);
        choosePlayerOne.setFont(fontMedium);
        JComboBox<String> playerOneOptions = new JComboBox<>(Storage.getListOfPlayers());
        playerOneOptions.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Storage.setPlayerOne(Objects.requireNonNull(playerOneOptions.getSelectedItem()).toString());
                choosePlayerOne.setText("東風: ");
            }
        });

        //Player 2
        JLabel choosePlayerTwo = new JLabel("Who is 南風?", SwingConstants.CENTER);
        choosePlayerTwo.setFont(fontMedium);
        JComboBox<String> playerTwoOptions = new JComboBox<>(Storage.getListOfPlayers());
        playerTwoOptions.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Storage.setPlayerTwo(Objects.requireNonNull(playerTwoOptions.getSelectedItem()).toString());
                choosePlayerTwo.setText("南風: ");
            }
        });

        //Player 3
        JLabel choosePlayerThree = new JLabel("Who is 西風?", SwingConstants.CENTER);
        choosePlayerThree.setFont(fontMedium);
        JComboBox<String> playerThreeOptions = new JComboBox<>(Storage.getListOfPlayers());
        playerThreeOptions.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Storage.setPlayerThree(Objects.requireNonNull(playerThreeOptions.getSelectedItem()).toString());
                choosePlayerThree.setText("西風: ");
            }
        });

        //Player 4
        JLabel choosePlayerFour = new JLabel("Who is 北風?", SwingConstants.CENTER);
        choosePlayerFour.setFont(fontMedium);
        JComboBox<String> playerFourOptions = new JComboBox<>(Storage.getListOfPlayers());
        playerFourOptions.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Storage.setPlayerFour(Objects.requireNonNull(playerFourOptions.getSelectedItem()).toString());
                choosePlayerFour.setText("北風: ");
            }
        });

        //Error Label
        JLabel errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Confirm
        JButton confirm = new JButton("Confirm");
        confirm.setVerticalTextPosition(SwingConstants.NORTH);
        confirm.setHorizontalTextPosition(SwingConstants.CENTER);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!Storage.isValid()) {
                    errorLabel.setText("Invalid input");
                } else {
                    Storage.setUp();
                    frame.remove(initPanel);
                    MainInterface.GUI(true);
                }
            }
        });

        //Layout
        GridBagConstraints cChoosePlayerOne = new GridBagConstraints();
        GridBagConstraints cChoosePlayerTwo = new GridBagConstraints();
        GridBagConstraints cChoosePlayerThree = new GridBagConstraints();
        GridBagConstraints cChoosePlayerFour = new GridBagConstraints();
        GridBagConstraints cPlayerOneOptions = new GridBagConstraints();
        GridBagConstraints cPlayerTwoOptions = new GridBagConstraints();
        GridBagConstraints cPlayerThreeOptions = new GridBagConstraints();
        GridBagConstraints cPlayerFourOptions = new GridBagConstraints();
        GridBagConstraints cErrorLabel = new GridBagConstraints();
        GridBagConstraints cConfirm = new GridBagConstraints();

        //Player 1
        cChoosePlayerOne.fill = GridBagConstraints.HORIZONTAL;
        cChoosePlayerOne.gridx = 0;
        cChoosePlayerOne.gridy = 0;
        cChoosePlayerOne.insets = new Insets(48, 0, 24 ,20);
        initPanel.add(choosePlayerOne, cChoosePlayerOne);

        cPlayerOneOptions.fill = GridBagConstraints.HORIZONTAL;
        cPlayerOneOptions.gridx = 1;
        cPlayerOneOptions.gridy = 0;
        cPlayerOneOptions.insets = new Insets(48, 0, 24 ,0);
        initPanel.add(playerOneOptions, cPlayerOneOptions);

        //Player 2
        cChoosePlayerTwo.fill = GridBagConstraints.HORIZONTAL;
        cChoosePlayerTwo.gridx = 0;
        cChoosePlayerTwo.gridy = 1;
        cChoosePlayerTwo.insets = new Insets(24, 0, 24 ,20);
        initPanel.add(choosePlayerTwo, cChoosePlayerTwo);

        cPlayerTwoOptions.fill = GridBagConstraints.HORIZONTAL;
        cPlayerTwoOptions.gridx = 1;
        cPlayerTwoOptions.gridy = 1;
        cPlayerTwoOptions.insets = new Insets(24, 0, 24 ,0);
        initPanel.add(playerTwoOptions, cPlayerTwoOptions);

        //Player 3
        cChoosePlayerThree.fill = GridBagConstraints.HORIZONTAL;
        cChoosePlayerThree.gridx = 0;
        cChoosePlayerThree.gridy = 2;
        cChoosePlayerThree.insets = new Insets(24, 0, 24 ,20);
        initPanel.add(choosePlayerThree, cChoosePlayerThree);

        cPlayerThreeOptions.fill = GridBagConstraints.HORIZONTAL;
        cPlayerThreeOptions.gridx = 1;
        cPlayerThreeOptions.gridy = 2;
        cPlayerThreeOptions.insets = new Insets(24, 0, 24 ,0);
        initPanel.add(playerThreeOptions, cPlayerThreeOptions);

        //Player 4
        cChoosePlayerFour.fill = GridBagConstraints.HORIZONTAL;
        cChoosePlayerFour.gridx = 0;
        cChoosePlayerFour.gridy = 3;
        cChoosePlayerFour.insets = new Insets(24, 0, 48 ,20);
        initPanel.add(choosePlayerFour, cChoosePlayerFour);

        cPlayerFourOptions.fill = GridBagConstraints.HORIZONTAL;
        cPlayerFourOptions.gridx = 1;
        cPlayerFourOptions.gridy = 3;
        cPlayerFourOptions.insets = new Insets(24, 0, 48 ,0);
        initPanel.add(playerFourOptions, cPlayerFourOptions);

        //Confirm
        cConfirm.fill = GridBagConstraints.HORIZONTAL;
        cConfirm.gridx = 1;
        cConfirm.gridy = 4;
        cConfirm.insets = new Insets(0, 0, 10 ,0);
        initPanel.add(confirm, cConfirm);

        //Error Label
        cErrorLabel.fill = GridBagConstraints.HORIZONTAL;
        cErrorLabel.gridx = 1;
        cErrorLabel.gridy = 5;
        cConfirm.insets = new Insets(0, 0, 100 ,0);
        initPanel.add(errorLabel, cErrorLabel);

        frame.add(initPanel);
        frame.setVisible(true);
    }
}

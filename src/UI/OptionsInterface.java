package UI;

import Facade.Storage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

public interface OptionsInterface extends GUI {
    static void GUI() {
        JPanel optionsPanel = new JPanel(new GridBagLayout());

        //Shooter Select
        JCheckBox selectShooter = new JCheckBox("Shooter?", true);
        selectShooter.setFont(fontMedium);
        selectShooter.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Storage.setIsShooter(e.getStateChange());
            }
        });

        //Starting Money
        JLabel startingMoneyLabel = new JLabel("Starting amount:", SwingConstants.CENTER);
        startingMoneyLabel.setFont(fontMedium);
        JTextField startingMoney = new JTextField("21.40");
        startingMoney.setFont(fontMedium);

        //Style of play
        JLabel styleLabel = new JLabel("Style of play:", SwingConstants.CENTER);
        styleLabel.setFont(fontMedium);
        JComboBox<String> styleOptions = new JComboBox<>(Storage.getStyles());
        styleOptions.setFont(fontMedium);
        styleOptions.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Storage.setStyle(Objects.requireNonNull(styleOptions.getSelectedItem()).toString());
            }
        });

        //Confirm
        JButton confirm = new JButton("Confirm");
        confirm.setVerticalTextPosition(SwingConstants.NORTH);
        confirm.setHorizontalTextPosition(SwingConstants.CENTER);
        confirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Storage.setStartMoney(Double.parseDouble(startingMoney.getText()));
                frame.remove(optionsPanel);
                PlayerSelectInterface.GUI();
            }
        });

        GridBagConstraints cSelectShooter = new GridBagConstraints();
        GridBagConstraints cStartingMoneyLabel = new GridBagConstraints();
        GridBagConstraints cStartingMoney = new GridBagConstraints();
        GridBagConstraints cStyleLabel = new GridBagConstraints();
        GridBagConstraints cStyleOptions = new GridBagConstraints();
        GridBagConstraints cConfirm = new GridBagConstraints();

        //Shooter Select
        cSelectShooter.fill = GridBagConstraints.HORIZONTAL;
        cSelectShooter.gridx = 1;
        cSelectShooter.gridy = 0;
        cSelectShooter.insets = new Insets(25, 15, 0 ,0);
        optionsPanel.add(selectShooter, cSelectShooter);

        //Starting Money
        cStartingMoneyLabel.fill = GridBagConstraints.HORIZONTAL;
        cStartingMoneyLabel.gridx = 1;
        cStartingMoneyLabel.gridy = 1;
        cStartingMoneyLabel.insets = new Insets(50, 0, 0 ,0);
        optionsPanel.add(startingMoneyLabel, cStartingMoneyLabel);

        cStartingMoney.fill = GridBagConstraints.HORIZONTAL;
        cStartingMoney.gridx = 1;
        cStartingMoney.gridy = 2;
        cStartingMoney.insets = new Insets(10, 0, 0 ,0);
        optionsPanel.add(startingMoney, cStartingMoney);

        //Style of play
        cStyleLabel.fill = GridBagConstraints.HORIZONTAL;
        cStyleLabel.gridx = 1;
        cStyleLabel.gridy = 3;
        cStyleLabel.insets = new Insets(50, 0, 0 ,0);
        optionsPanel.add(styleLabel, cStyleLabel);

        cStyleOptions.fill = GridBagConstraints.HORIZONTAL;
        cStyleOptions.gridx = 1;
        cStyleOptions.gridy = 4;
        cStyleOptions.insets = new Insets(10, 0, 0 ,0);
        optionsPanel.add(styleOptions, cStyleOptions);

        //Confirm
        cConfirm.fill = GridBagConstraints.HORIZONTAL;
        cConfirm.gridx = 1;
        cConfirm.gridy = 5;
        cConfirm.insets = new Insets(50, 0,0,0);
        optionsPanel.add(confirm, cConfirm);

        frame.add(optionsPanel);
        frame.setVisible(true);
    }
}

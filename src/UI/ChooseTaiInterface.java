package UI;

import Facade.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface ChooseTaiInterface extends GUI {
    int AN_YAO = 0;
    int MING_YAO = -1;
    int GANG = -2;
    int AN_GANG = -3;
    int MING_GANG = -4;

    static void GUI(){
        JPanel taiPanel = new JPanel(new GridBagLayout());

        //Header
        JLabel headerLabel = new JLabel("How many tai?", SwingConstants.CENTER);
        headerLabel.setFont(fontBig);
        headerLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //An Yao
        JButton anYao = new JButton("暗咬");
        anYao.setFont(fontMedium);
        anYao.setVerticalTextPosition(SwingConstants.NORTH);
        anYao.setHorizontalTextPosition(SwingConstants.CENTER);
        anYao.setPreferredSize(new Dimension(120, 120));
        anYao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(AN_YAO);
                frame.remove(taiPanel);
                ShooterInterface.GUI();
            }
        });

        //Ming Yao
        JButton mingYao = new JButton("明咬");
        mingYao.setFont(fontMedium);
        mingYao.setVerticalTextPosition(SwingConstants.NORTH);
        mingYao.setHorizontalTextPosition(SwingConstants.CENTER);
        mingYao.setPreferredSize(new Dimension(120, 120));
        mingYao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(MING_YAO);
                frame.remove(taiPanel);
                ShooterInterface.GUI();
            }
        });

        //Gang
        JButton gang = new JButton("杠");
        gang.setFont(fontMedium);
        gang.setVerticalTextPosition(SwingConstants.NORTH);
        gang.setHorizontalTextPosition(SwingConstants.CENTER);
        gang.setPreferredSize(new Dimension(120, 120));
        gang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(GANG);
                frame.remove(taiPanel);
                ShooterInterface.GUI();
            }
        });

        //An Gang
        JButton anGang = new JButton("暗杠");
        anGang.setFont(fontMedium);
        anGang.setVerticalTextPosition(SwingConstants.NORTH);
        anGang.setHorizontalTextPosition(SwingConstants.CENTER);
        anGang.setPreferredSize(new Dimension(120, 120));
        anGang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(AN_GANG);
                Transaction.giveMoney();
                frame.remove(taiPanel);
                MainInterface.GUI(false);
            }
        });

        //Ming Gang
        JButton mingGang = new JButton("明杠");
        mingGang.setFont(fontMedium);
        mingGang.setVerticalTextPosition(SwingConstants.NORTH);
        mingGang.setHorizontalTextPosition(SwingConstants.CENTER);
        mingGang.setPreferredSize(new Dimension(120, 120));
        mingGang.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(MING_GANG);
                Transaction.giveMoney();
                frame.remove(taiPanel);
                MainInterface.GUI(false);
            }
        });

        //1 tai
        JButton tai_1 = new JButton("1台");
        tai_1.setFont(fontMedium);
        tai_1.setVerticalTextPosition(SwingConstants.NORTH);
        tai_1.setHorizontalTextPosition(SwingConstants.CENTER);
        tai_1.setPreferredSize(new Dimension(120, 120));
        tai_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(1);
                frame.remove(taiPanel);
                ShooterInterface.GUI();
            }
        });

        //2 tai
        JButton tai_2 = new JButton("2台");
        tai_2.setFont(fontMedium);
        tai_2.setVerticalTextPosition(SwingConstants.NORTH);
        tai_2.setHorizontalTextPosition(SwingConstants.CENTER);
        tai_2.setPreferredSize(new Dimension(120, 120));
        tai_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(2);
                frame.remove(taiPanel);
                ShooterInterface.GUI();
            }
        });

        //3 tai
        JButton tai_3 = new JButton("3台");
        tai_3.setFont(fontMedium);
        tai_3.setVerticalTextPosition(SwingConstants.NORTH);
        tai_3.setHorizontalTextPosition(SwingConstants.CENTER);
        tai_3.setPreferredSize(new Dimension(120, 120));
        tai_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(3);
                frame.remove(taiPanel);
                ShooterInterface.GUI();
            }
        });

        //4 tai
        JButton tai_4 = new JButton("4台");
        tai_4.setFont(fontMedium);
        tai_4.setVerticalTextPosition(SwingConstants.NORTH);
        tai_4.setHorizontalTextPosition(SwingConstants.CENTER);
        tai_4.setPreferredSize(new Dimension(120, 120));
        tai_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(4);
                frame.remove(taiPanel);
                ShooterInterface.GUI();
            }
        });

        //5 tai
        JButton tai_5 = new JButton("5台");
        tai_5.setFont(fontMedium);
        tai_5.setVerticalTextPosition(SwingConstants.NORTH);
        tai_5.setHorizontalTextPosition(SwingConstants.CENTER);
        tai_5.setPreferredSize(new Dimension(120, 120));
        tai_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Transaction.setWinAmount(5);
                frame.remove(taiPanel);
                ShooterInterface.GUI();
            }
        });

        GridBagConstraints cHeader = new GridBagConstraints();
        GridBagConstraints cAnYao = new GridBagConstraints();
        GridBagConstraints cMingYao = new GridBagConstraints();
        GridBagConstraints cGang = new GridBagConstraints();
        GridBagConstraints cAnGang = new GridBagConstraints();
        GridBagConstraints cMingGang = new GridBagConstraints();
        GridBagConstraints cTai_1 = new GridBagConstraints();
        GridBagConstraints cTai_2 = new GridBagConstraints();
        GridBagConstraints cTai_3 = new GridBagConstraints();
        GridBagConstraints cTai_4 = new GridBagConstraints();
        GridBagConstraints cTai_5 = new GridBagConstraints();

        cHeader.fill = GridBagConstraints.HORIZONTAL;
        cHeader.gridx = 0;
        cHeader.gridwidth = 5;
        cHeader.gridy = 0;
        cHeader.insets = new Insets(0, 0, 20 ,0);
        taiPanel.add(headerLabel, cHeader);

        cAnYao.fill = GridBagConstraints.HORIZONTAL;
        cAnYao.gridx = 0;
        cAnYao.gridy = 1;
        cAnYao.insets = new Insets(10, 70, 20 ,0);
        taiPanel.add(anYao, cAnYao);

        cMingYao.fill = GridBagConstraints.HORIZONTAL;
        cMingYao.gridx = 1;
        cMingYao.gridy = 1;
        cMingYao.insets = new Insets(10, 15, 20 ,0);
        taiPanel.add(mingYao, cMingYao);

        cGang.fill = GridBagConstraints.HORIZONTAL;
        cGang.gridx = 2;
        cGang.gridy = 1;
        cGang.insets = new Insets(10, 15, 20 ,0);
        taiPanel.add(gang, cGang);

        cAnGang.fill = GridBagConstraints.HORIZONTAL;
        cAnGang.gridx = 3;
        cAnGang.gridy = 1;
        cAnGang.insets = new Insets(10, 15, 20 ,0);
        taiPanel.add(anGang, cAnGang);

        cMingGang.fill = GridBagConstraints.HORIZONTAL;
        cMingGang.gridx = 4;
        cMingGang.gridy = 1;
        cMingGang.insets = new Insets(10, 15, 20 ,70);
        taiPanel.add(mingGang, cMingGang);


        cTai_1.fill = GridBagConstraints.HORIZONTAL;
        cTai_1.gridx = 0;
        cTai_1.gridy = 2;
        cTai_1.insets = new Insets(10, 70, 100 ,0);
        taiPanel.add(tai_1, cTai_1);

        cTai_2.fill = GridBagConstraints.HORIZONTAL;
        cTai_2.gridx = 1;
        cTai_2.gridy = 2;
        cTai_2.insets = new Insets(10, 15, 100 ,0);
        taiPanel.add(tai_2, cTai_2);

        cTai_3.fill = GridBagConstraints.HORIZONTAL;
        cTai_3.gridx = 2;
        cTai_3.gridy = 2;
        cTai_3.insets = new Insets(10, 15, 100 ,0);
        taiPanel.add(tai_3, cTai_3);

        cTai_4.fill = GridBagConstraints.HORIZONTAL;
        cTai_4.gridx = 3;
        cTai_4.gridy = 2;
        cTai_4.insets = new Insets(10, 15, 100 ,0);
        taiPanel.add(tai_4, cTai_4);

        cTai_5.fill = GridBagConstraints.HORIZONTAL;
        cTai_5.gridx = 4;
        cTai_5.gridy = 2;
        cTai_5.insets = new Insets(10, 15, 100 ,70);
        taiPanel.add(tai_5, cTai_5);

        frame.add(taiPanel);
        frame.setVisible(true);
    }
}

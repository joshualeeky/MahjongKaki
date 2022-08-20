package UI;

import javax.swing.*;
import java.awt.*;

public interface GUI{
    //Creating the Frame
    JFrame frame = new JFrame("Mahjong Time!");
    Font fontBig = new Font("SansSerif", Font.BOLD, 35);
    Font fontMedium = new Font("SansSerif", Font.BOLD, 20);
    Font fontMedium2 = new Font("SansSerif", Font.BOLD, 17);

    static void initGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(800, 480);
        frame.setSize(1112, 834);
        frame.setLayout(new FlowLayout());
        OptionsInterface.GUI();
    }
}



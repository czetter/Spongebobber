package com.company.UI;

import javax.swing.*;
import java.awt.*;

public class Window {
    private  int size = 300;    //Window.form-ban is at kell irni
    private JPanel panelMain;
    private JLabel pictureLabel;

    public Window() {
        init();
        setLabelPicture();
    }

    private void init() {
        JFrame frame = new JFrame("Spongebobber");
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void setLabelPicture() {
        ImageIcon imgSpongebob = new ImageIcon("src/com/company/images/spongebob.jpg");
        imgSpongebob = scaleImageIcon(imgSpongebob);
        pictureLabel.setIcon(imgSpongebob);
    }

    private ImageIcon scaleImageIcon(ImageIcon input) {
        Image inputToImage = input.getImage();
        Image scaledImage = inputToImage.getScaledInstance(size, size, java.awt.Image.SCALE_SMOOTH);
        ImageIcon output = new ImageIcon(scaledImage);
        return output;
    }
}

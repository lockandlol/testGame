package com.company;

import javax.swing.*;
import java.awt.*;

public class Window {

    public Window(int width, int height, String title, Game game){

        JFrame frame = new JFrame(title);

        Dimension dim = new Dimension(width, height);
        frame.setPreferredSize(dim);
        frame.setMaximumSize(dim);
        frame.setMinimumSize(dim);

        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);

    }
}

package com;

import javax.swing.*;
import java.awt.*;
// Класс содержащий изображение кнопок
public class FieldManagement {
    JButton resetButton,right,left,up,down;


    public JButton turnRight() {
        right = new JButton();
        right.setText("←");
        right.setBackground(new Color(47, 76, 166));
        right.setBounds(10, 500, 50, 20);
        right.setForeground(Color.WHITE);
        right.setVisible(true);
        return right;
    }

    public JButton turnLeft() {
        left = new JButton();
        left.setText("→");
        left.setBackground(new Color(47, 76, 166));
        left.setBounds(70, 500, 50, 20);
        left.setForeground(Color.WHITE);
        left.setVisible(true);
        return left;
    }

    public JButton goUp() {
        up = new JButton();
        up.setText("↑");
        up.setBackground(new Color(47, 76, 166));
        up.setBounds(40, 470, 45, 30);
        up.setForeground(Color.WHITE);
        up.setVisible(true);
        return up;
    }

    public JButton goDown() {
        down = new JButton();
        down.setText("↓");
        down.setBackground(new Color(47, 76, 166));
        down.setBounds(40, 520, 45, 30);
        down.setForeground(Color.WHITE);
        down.setVisible(true);
        return down;
    }

    public JButton reset() {
        resetButton = new JButton();
        resetButton.setText("Сброс");
        resetButton.setBackground(new Color(166, 25, 12));
        resetButton.setForeground(Color.WHITE);
        resetButton.setBounds(10, 300, 110, 30);
        resetButton.setVisible(true);
        return resetButton;
    }

}

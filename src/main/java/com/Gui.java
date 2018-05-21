package com;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Gui {
    public Gui() {
        JFrame window = new JFrame();
        window.setSize(850, 650);
        window.setLayout(null);
        window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        // Вызов диалогового окна, при закрытии программы
        window.addWindowListener(new WindowListener() {

            public void windowActivated(WindowEvent event) {

            }

            public void windowClosed(WindowEvent event) {

            }

            public void windowClosing(WindowEvent event) {
                Object[] options = {"Да", "Нет"};
                int n = JOptionPane
                        .showOptionDialog(event.getWindow(), "Закрыть окно?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    event.getWindow().setVisible(false);
                    System.exit(0);
                }
            }

            public void windowDeactivated(WindowEvent event) {

            }

            public void windowDeiconified(WindowEvent event) {

            }

            public void windowIconified(WindowEvent event) {

            }

            public void windowOpened(WindowEvent event) {

            }

        });
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setTitle("крестики-нолики на бесконечном поле");

        final Draw draw = new Draw();
        draw.setGameField(new Field());
        draw.setBounds(125, 0, 700, 600);
        draw.setVisible(true);
        window.add(draw);

        final JLabel label = new JLabel();
        label.setBounds(10, 100, 125, 30);
        label.setVisible(true);
        window.add(label);


        FieldManagement but = new FieldManagement();
        window.add(but.turnRight());
        window.add(but.turnLeft());
        window.add(but.goUp());
        window.add(but.goDown());
        window.add(but.reset());


        label.setText("Игрок: " + draw.getGameField().getGamer());

        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (draw.getGameField().getWinner() == null)
                    label.setText("Игрок: " + draw.getGameField().getGamer());
                else
                    label.setText("Победитель: " + draw.getGameField().getWinner());
            }
        });

        but.resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.getGameField().reset();
                draw.positionDefault();
                label.setText("Игрок: " + draw.getGameField().getGamer());
                draw.repaint();
            }
        });

        but.right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.buttonRight();
            }
        });
        but.left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.buttonLeft();
            }
        });

        but.up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.buttonUp();
            }
        });

        but.down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.buttonDown();
            }
        });

        window.setVisible(true);
    }
}
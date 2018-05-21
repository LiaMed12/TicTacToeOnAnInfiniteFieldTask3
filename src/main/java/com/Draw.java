package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Draw extends JPanel implements MouseListener {

    private Field gameField;
    private java.util.List<ActionListener> actionListeners = new ArrayList<>();
    private int startX;
    private int startY;

    public Draw() {
        super();

        this.addMouseListener(this);
    }

    public void addActionListener(ActionListener handler) {
        if (handler != null)
            actionListeners.add(handler);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (this.gameField == null) {
            return;
        }

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);

        this.paintField(g2d);
    }

    private void paintField(Graphics2D g) {
        float cellHeight = (this.getHeight() - 1.0f) / Constants.DEFAULT_SIZE;
        float cellWidth = (this.getWidth() - 1.0f) / Constants.DEFAULT_SIZE;
        // Прорисовка вертикали
        for (int i = 0; i <= Constants.DEFAULT_SIZE; i++)
            g.drawLine((int) (i * cellWidth), 0,
                    (int) (i * cellWidth), this.getHeight());
        // Прорисовка горизонтали
        for (int i = 0; i <= Constants.DEFAULT_SIZE; i++)
            g.drawLine(0, (int) (i * cellHeight), this.getWidth(),
                    (int) (i * cellHeight));

        // Прорисовка крестика или нолика
        for (int i = 0; i < Constants.DEFAULT_SIZE; i++) {
            for (int j = 0; j < Constants.DEFAULT_SIZE; j++) {
                Player field = gameField.get(i + startX, j + startY);

                if (field != null)
                    g.drawImage(field.getImage(), (int) (i * cellWidth),
                            (int) (j * cellHeight), (int) cellWidth, (int) cellHeight, null);
            }
        }
    }

    public Field getGameField() {
        return gameField;
    }

    public void setGameField(Field gameField) {
        this.gameField = gameField;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.gameField == null || this.gameField.getWinner() != null)
            return;

        int x = e.getX() * Constants.DEFAULT_SIZE / this.getWidth();
        int y = e.getY() * Constants.DEFAULT_SIZE / this.getHeight();

        this.gameField.set(x + startX, y + startY);
        repaint();

        for (ActionListener handler : actionListeners) {
            handler.actionPerformed(null);
        }

    }

    public void buttonRight() {
        if (startX > 0)
            startX--;
        else
            this.gameField.insertColumn();
        this.repaint();
    }

    public void buttonLeft() {
        startX++;
        if (this.gameField.getWidth() < startX + Constants.DEFAULT_SIZE)
            this.gameField.addColumn();

        this.repaint();
    }

    public void buttonDown() {
        startY++;
        if (this.gameField.getHeight() < startY + Constants.DEFAULT_SIZE)
            this.gameField.addRow();
        this.repaint();
    }

    public void buttonUp() {
        if (startY > 0)
            startY--;
        else
            this.gameField.insertRow();
        this.repaint();
    }

    public void positionDefault() {
        startY = startX = 0;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

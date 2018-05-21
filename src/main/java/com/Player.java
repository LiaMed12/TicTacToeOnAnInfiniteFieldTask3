package com;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public enum Player {
    X("/x.png"),
    O("/o.png");

    Image image;

    public Image getImage() {
        return image;
    }

    Player(String resources) {
        try {
            this.image = ImageIO.read(Player.class.getResource(resources));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

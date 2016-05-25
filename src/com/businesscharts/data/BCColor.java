package com.businesscharts.data;

import java.awt.*;

public class BCColor {
    /**
     * Returns randomly generated color
     * @return random color
     */
    public static Color getRandomColor() {
        return new Color(
                (int)(Math.random() * 255),
                (int)(Math.random() * 255),
                (int)(Math.random() * 255)
        );
    }
}

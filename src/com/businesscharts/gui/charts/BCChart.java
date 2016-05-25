package com.businesscharts.gui.charts;

import com.businesscharts.data.BCDimensions;

import javax.swing.*;
import java.awt.*;

public class BCChart extends JComponent {

    /**
     * Base chart-component height
     */
    protected int DEFAULT_HEIGHT = BCDimensions.SCREEN_SIZE.height / 2;

    /**
     * Base chart-component padding
     */
    protected int DEFAULT_PADDING = 50;

    /**
     * Base chart-component width
     */
    protected int DEFAULT_WIDTH = BCDimensions.SCREEN_SIZE.width / 2;

    /**
     * G2D object for drawing
     */
    protected Graphics2D g2d;

    /**
     * Draws string with right alignment
     * @param s - string to draw
     * @param y - right coordinate
     */
    protected void drawString(String s, float y) {
        FontMetrics fm = getFontMetrics(getFont());
        int width = fm.stringWidth(s) + 5;

        g2d.setPaint(Color.BLACK);
        g2d.drawString(s, DEFAULT_PADDING - width, y + getFont().getSize() / 2);
    }

    /**
     * Base setup of g2d-object and store object in class variable
     * @param g - Graphics object
     */
    public void paintComponent(Graphics g) {
        g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
    }

    /**
     * Returns preferred size for chart-component
     * @return charts preferred dimension
     */
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}

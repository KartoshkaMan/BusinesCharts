package com.businesscharts.gui.charts;

import com.businesscharts.data.BCColumnData;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public abstract class BCColumnChart extends BCChart {

    /**
     * Hardcoded space between columns
     */
    protected int DEFAULT_BOX_SPACE = 15;

    /**
     * Stores all data to draw
     */
    protected BCColumnData data;

    /**
     * Creates base object for all column charts
     * @param data - up-casted data object(from BCSColumnData or BCNSColumnData)
     */
    public BCColumnChart(BCColumnData data) {
        this.data = data;
    }

    /**
     * Draws zero level x-axle
     */
    protected void drawZeroX() {
        int y = getVerticalMiddle();
        Line2D line = new Line2D.Float(
                DEFAULT_PADDING,
                y,
                getSize().width - DEFAULT_PADDING,
                y
        );

        g2d.setPaint(Color.BLACK);
        g2d.draw(line);
        drawString(Integer.toString(0), y);
    }

    /**
     * Draws y-axle
     */
    protected void drawY() {
        Line2D line = new Line2D.Float(
                DEFAULT_PADDING,
                DEFAULT_PADDING,
                DEFAULT_PADDING,
                getSize().height - DEFAULT_PADDING
        );

        g2d.setPaint(Color.BLACK);
        g2d.draw(line);
    }

    /**
     * Draws column-box for single data value
     * @param xPos - border-left x-position
     * @param yPos - border-left y-position
     * @param w - width of the box
     * @param val - single data value
     */
    protected void drawBox(float xPos, float yPos, float w, float val) {
        if (val > 0)
            yPos -= val;
        val = Math.abs(val);

        Rectangle2D r = new Rectangle2D.Float(
                xPos,
                yPos,
                w,
                val
        );


        g2d.fill(r);
        g2d.setPaint(Color.BLACK);
        g2d.draw(r);
    }

    /**
     * Draws border x-axles
     * @param borderVal - border value to draw (used for setting up border-values)
     * @param param - last symbol (used to specify units)
     */
    protected void drawXBorder(float borderVal, String param) {

        Line2D lineUp = new Line2D.Float(
                DEFAULT_PADDING,
                DEFAULT_PADDING,
                getWidth() - DEFAULT_PADDING,
                DEFAULT_PADDING
        );

        Line2D lineDown = new Line2D.Float(
                DEFAULT_PADDING,
                getSize().height - DEFAULT_PADDING,
                getSize().width - DEFAULT_PADDING,
                getSize().height - DEFAULT_PADDING
        );

        g2d.setPaint(Color.lightGray);
        g2d.draw(lineUp);
        g2d.draw(lineDown);

        String str = String.format("%.0f%s", borderVal, param);
        drawString(str, DEFAULT_PADDING);
        drawString("-" + str, getSize().height - DEFAULT_PADDING);
    }

    /**
     * Returns vertical middle
     * @return y-coordinate of the middle
     */
    protected int getVerticalMiddle() {
        return getHeight() / 2;
    }

    /**
     * Returns width of column
     * @return width
     */
    protected float getBoxWidth() {
        float w = (getWidth() - 2 * DEFAULT_PADDING - DEFAULT_BOX_SPACE * (data.getSize() + 1)) / data.getSize();
        return (w > 40 ? 40 : (w >= 1 ? w : 1));
    }
}

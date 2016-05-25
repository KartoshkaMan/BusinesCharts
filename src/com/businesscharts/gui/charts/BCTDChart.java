package com.businesscharts.gui.charts;

import com.businesscharts.data.BCTDData;

import java.awt.*;
import java.awt.geom.*;
import java.util.Vector;

public class BCTDChart extends BCChart {

    /**
     * Stores data for td-chart
     */
    private BCTDData data;

    /**
     * Creates chart-component for TD-Chart
     * @param data - specified data for TD-Chart
     */
    public BCTDChart(BCTDData data) {
        this.data = data;
    }

    /**
     * Draws component
     * @param g - Graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawXBorder();
        drawYBorder();
        drawData();
        drawXAxle();
        drawYAxle();
        drawXSign();
        drawYSign();
    }

    /**
     * Draws all data
     */
    private void drawData() {
        float xpxSize = getXPXSize();
        float ypxSize = getYPXSize();

        for (int i = 0; i < data.getSize(); i++) {
            Vector<Point2D.Float> v = data.get(i);

            for (int j = 0; j < v.size(); j++) {
                Point2D.Float point = v.get(j);
                if (point != null) drawPoint(point, xpxSize, ypxSize, data.getColor(j));
            }
        }
    }

    /**
     * Draws one point
     * @param point - point2d object to draw
     * @param xpxSize - rel value for x-dimension
     * @param ypxSize - rel value for y-dimension
     * @param color - color to draw
     */
    private void drawPoint(Point2D point, float xpxSize, float ypxSize, Color color) {
        int xm = getXMiddle();
        int ym = getYMiddle();
        int rad = 2;

        Ellipse2D r = new Ellipse2D.Double(
                xm + point.getX() * xpxSize - rad,
                ym - point.getY() * ypxSize - rad,
                2 * rad,
                2 * rad
        );

        g2d.setPaint(color);
        g2d.draw(r);
        g2d.fill(r);
    }

    /**
     * Draws x-axle based border-coordinates
     */
    private void drawXSign() {
        String s1 = "" + getXMax();
        String s2 = "-" + getXMax();

        FontMetrics fm = getFontMetrics(getFont());
        int w2 = fm.stringWidth(s2);

        int y = getYMiddle() + getFont().getSize() / 2;

        g2d.setPaint(Color.BLACK);
        g2d.drawString(
                s1,
                getWidth() - DEFAULT_PADDING + 5,
                y
        );
        g2d.drawString(
                s2,
                DEFAULT_PADDING - w2 - 5,
                y
        );

    }

    /**
     * Draws y-axle based border-coordinates
     */
    private void drawYSign() {
        drawString("" + getYMax(), DEFAULT_PADDING);
        drawString("-" + getYMax(), getHeight() - DEFAULT_PADDING);
    }

    private void drawXAxle() {
        Line2D line = new Line2D.Float(
                DEFAULT_PADDING,
                getYMiddle(),
                getWidth() - DEFAULT_PADDING,
                getYMiddle()
        );

        g2d.setPaint(Color.BLACK);
        g2d.draw(line);
    }
    private void drawYAxle() {
        Line2D line = new Line2D.Float(
                getXMiddle(),
                DEFAULT_PADDING,
                getXMiddle(),
                getHeight() - DEFAULT_PADDING
        );

        g2d.setPaint(Color.BLACK);
        g2d.draw(line);
    }

    /**
     * Draws x-oriented border axles
     */
    private void drawXBorder() {
        Line2D l1 = new Line2D.Float(
                DEFAULT_PADDING,
                DEFAULT_PADDING,
                getWidth() - DEFAULT_PADDING,
                DEFAULT_PADDING
        );
        Line2D l2 = new Line2D.Float(
                DEFAULT_PADDING,
                getHeight() - DEFAULT_PADDING,
                getWidth() - DEFAULT_PADDING,
                getHeight() - DEFAULT_PADDING
        );

        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.draw(l1);
        g2d.draw(l2);
    }

    /**
     * Draws y-oriented border axles
     */
    private void drawYBorder() {
        Line2D l1 = new Line2D.Float(
                DEFAULT_PADDING,
                DEFAULT_PADDING,
                DEFAULT_PADDING,
                getHeight() - DEFAULT_PADDING
        );
        Line2D l2 = new Line2D.Float(
                getWidth() - DEFAULT_PADDING,
                DEFAULT_PADDING,
                getWidth() - DEFAULT_PADDING,
                getHeight() - DEFAULT_PADDING
        );

        g2d.setPaint(Color.LIGHT_GRAY);
        g2d.draw(l1);
        g2d.draw(l2);
    }

    /**
     * Returns rounded max X value
     * @return x-value
     */
    private int getXMax() {
        return (((int) Math.abs(data.getMaxX()) / 10 + 1) * 10);
    }

    /**
     * Returns rounded max Y value
     * @return y-value
     */
    private int getYMax() {
        return (((int) Math.abs(data.getMaxY() / 10 + 1)) * 10);
    }

    /**
     * Returns x-coordinate of zero-point
     * @return x-coordinate of zero-point
     */
    private int getXMiddle() {
        return getWidth() / 2;
    }

    /**
     * Returns y-coordinate of zero-point
     * @return y-coordinate of zero-point
     */
    private int getYMiddle() {
        return getHeight() / 2;
    }

    /**
     * Returns relative value of available space and max value by X
     * @return - relative value
     */
    private float getXPXSize() {
        return (getXMiddle() - DEFAULT_PADDING) / getXMax();
    }

    /**
     * Returns relative value of available space and max value by Y
     * @return relative value
     */
    private float getYPXSize() {
        return (getYMiddle() - DEFAULT_PADDING) / getYMax();
    }
}

package com.businesscharts.gui.charts;

import com.businesscharts.data.BCSColumnData;

import java.awt.*;
import java.util.Vector;

public class BCStackedColumn extends BCColumnChart {

    /**
     * Stores max value of data
     */
    private float maxValue;

    /**
     * Creates chart-component for stacked column chart
     * @param data specified data-object
     */
    public BCStackedColumn(BCSColumnData data) {
        super(data);
        getMaxValue(data);
    }

    /**
     * Draws component
     * @param g - Graphics object
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawXBorder(maxValue, "");
        drawData();
        drawZeroX();
        drawY();
    }

    /**
     * Draws data
     */
    private void drawData() {

        float boxWidth = getBoxWidth();
        float xStart = DEFAULT_PADDING + DEFAULT_BOX_SPACE;
        float middle = getVerticalMiddle();
        float pxSize = getPXSize();

        for (int i = 0; i < data.getSize(); i++) {
            Vector<Float> vector = data.getRow(i);

            float posStart = middle;
            float negStart = middle;

            for (int j = 0; j < vector.size(); j++) {
                g2d.setColor(data.getColor(j));

                float v = vector.get(j);
                float h = v * pxSize;
                if (v > 0) {
                    drawBox(xStart, posStart, boxWidth, h);
                    posStart -= Math.abs(h);
                }
                else if (v < 0) {
                    drawBox(xStart, negStart, boxWidth, h);
                    negStart += Math.abs(h);
                }
            }

            xStart += DEFAULT_BOX_SPACE + boxWidth;
        }
    }

    /**
     * Counts max value in data
     * @param data - data
     */
    private void getMaxValue(BCSColumnData data) {
        this.maxValue = ((int)(data.getMaxSum() / 10 + 1)) * 10;
    }

    /**
     * Counts relative value between px and single value from data
     * @return rel. value
     */
    private float getPXSize() {
        float h = getVerticalMiddle() - DEFAULT_PADDING;
        return (h / maxValue);
    }

}

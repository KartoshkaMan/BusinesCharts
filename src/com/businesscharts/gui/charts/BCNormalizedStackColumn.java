package com.businesscharts.gui.charts;

import com.businesscharts.data.BCNSColumnData;

import java.awt.*;
import java.util.Vector;

public class BCNormalizedStackColumn extends BCColumnChart {

    /**
     * Stores max values of each row in data
     */
    private Vector<Float> maxValues;

    /**
     * Creates chart-component for normalized stacked column chart
     * @param data - specified data-object
     */
    public BCNormalizedStackColumn(BCNSColumnData data) {
        super(data);
        prepareData(data);
    }

    /**
     * Draws component
     * @param g - Graphics object
     */
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        drawXBorder(100, "%");
        drawData();
        drawZeroX();
        drawY();
    }

    /**
     * Extrude from data maxValues by row
     * @param data - data from table model
     */
    private void prepareData(BCNSColumnData data) {
        maxValues = new Vector<>();
        for (int i = 0; i < data.getSize(); i++)
            maxValues.add(data.getRowSum(i));

        maxValues.trimToSize();

    }

    /**
     * Draws all data
     */
    private void drawData() {

        float boxWidth = getBoxWidth();
        float xStart = DEFAULT_PADDING + DEFAULT_BOX_SPACE;
        float middle = getVerticalMiddle();

        for (int i = 0; i < data.getSize(); i++) {
            Vector<Float> vector = data.getRow(i);
            float pxSize = getPXSize(i);

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
     * Returns relative value
     * @param row - row number
     * @return multiplier
     */
    private float getPXSize(int row) {
        float h = getVerticalMiddle() - DEFAULT_PADDING;
        float m = maxValues.get(row);

        return (h / m);
    }

}

package com.businesscharts.data;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class BCData {

    /**
     * Stores colors for each row
     */
    private Vector<Color> color;

    /**
     * Creates base data object
     * @param model - default table model from table
     */
    public BCData(DefaultTableModel model) {
        prepareColors(model.getColumnCount());
    }

    /**
     * Generates color vector for painting
     * @param count - amount of columns
     */
    private void prepareColors(int count) {
        color = new Vector<>(count);

        for (int i = 0; i < count; i++)
            color.add(BCColor.getRandomColor());
    }

    /**
     * Returns color for table row
     * @param rn - row number
     * @return Color
     */
    public Color getColor(int rn) {
        return color.get(rn);
    }
}

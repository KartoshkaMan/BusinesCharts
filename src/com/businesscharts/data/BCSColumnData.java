package com.businesscharts.data;

import javax.swing.table.DefaultTableModel;

public class BCSColumnData extends BCColumnData {

    /**
     * Creates data object for stacked chart
     * @param model - def. table model
     */
    public BCSColumnData(DefaultTableModel model) {
        super(model);
    }

    /**
     * finds and return biggest sum from all rows
     * @return biggest sum row
     */
    public float getMaxSum() {
        float max = 0;

        for (int i = 0; i < data.size(); i++) {
            float s = 0;
            for (int j = 0; j < data.get(i).size(); j++)
                s += Math.abs(data.get(i).get(j));

            if (s > max) max = s;
        }

        return max;
    }

}

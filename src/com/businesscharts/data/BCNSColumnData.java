package com.businesscharts.data;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class BCNSColumnData extends BCColumnData  {

    /**
     * Creates data for normalized stacked chart
     * @param model default table model from table
     */
    public BCNSColumnData(DefaultTableModel model) {
        super(model);
    }

    /**
     * Returns sum of selected row
     * @param rn - row number
     * @return sum of selected row
     */
    public float getRowSum(int rn) {
        Vector<Float> row = data.get(rn);
        float sum = 0;

        for (int i = 0; i < row.size(); i++)
            sum += Math.abs(row.get(i));

        return sum;
    }

}

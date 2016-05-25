package com.businesscharts.data;

import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class BCDefaultTableModel {

    /**
     * Returns base table model for programs begin
     * @return base table model
     */
    public static DefaultTableModel getModel() {
        String colNames[] = {
                "Col#1",
                "Col#2",
                "Col#3"
        };

        Object data[][] = {
                {null, null, null}
        };

        return new DefaultTableModel(data, colNames);
    }

    /**
     * Returns empty vector for new empty row
     * @param size - amount of columns
     * @return empty vector
     */
    public static Vector getEmptyVector(int size) {
        Vector<Object> v = new Vector<>(size);

        for (int i = 0; i < size; i++)
            v.add(null);

        return v;
    }
}

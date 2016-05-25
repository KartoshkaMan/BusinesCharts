package com.businesscharts.data;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class BCColumnData extends BCData {

    /**
     * Stores all data from table model
     */
    protected Vector<Vector<Float>> data;

    /**
     * Creates base data for columned charts
     * @param model - default table model from table
     */
    public BCColumnData(DefaultTableModel model) {
        super(model);
        prepareData(model.getDataVector());
    }

    /**
     * Executes data from table model data vector to own vector
     * @param vector - vector from table model
     */
    private void prepareData(Vector vector) {
        data = new Vector<>();

        for (int i = 0; i < vector.size(); i++) {
            Vector v = (Vector) vector.get(i);
            Vector<Float> d = new Vector<>();

            for (int j = 0; j < v.size(); j++) {
                Float f;

                try {
                    f = Float.parseFloat((String) v.get(j));
                } catch (Exception e) {
                    f = 0F;
                }

                d.add(f);
            }

            data.add(d);
        }
    }

    /**
     * Return row count
     * @return data.size()
     */
    public int getSize() {
        return data.size();
    }

    /**
     * Returns row-vector
     * @param i - row number
     * @return row-vector
     */
    public Vector<Float> getRow(int i) {
        return data.get(i);
    }

}

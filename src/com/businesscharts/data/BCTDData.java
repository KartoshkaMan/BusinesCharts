package com.businesscharts.data;

import javax.swing.table.DefaultTableModel;
import java.awt.geom.Point2D;
import java.util.Vector;

public class BCTDData extends BCData {

    /**
     * Biggest x-coordinate
     */
    private float maxX;

    /**
     * Biggest y-coordinate
     */
    private float maxY;

    /**
     * Stores all available points extracted from def. table model
     */
    private Vector<Vector<Point2D.Float>> data;

    /**
     * Creates data object for TD chart
     * @param model - def. table model from table
     */
    public BCTDData(DefaultTableModel model) {
        super(model);
        prepareData(model.getDataVector());
        prepareMaxXY();
    }

    /**
     * Extracts data from data vector from def. table model
     * @param vector - data vector from def. table model
     */
    private void prepareData(Vector vector) {
        data = new Vector<>();

        for (int i = 0; i < vector.size(); i++) {
            Vector v = (Vector) vector.get(i);

            float zero;
            try {
                zero = Float.parseFloat((String) v.get(0));
                Vector<Point2D.Float> points = new Vector<>();

                for (int j = 1; j < v.size(); j++) {

                    float val;

                    try {

                        val = Float.parseFloat((String) v.get(j));
                        points.add(new Point2D.Float(zero, val));

                    } catch(Exception e) {
                        //
                    }
                }

                if (!points.isEmpty()) data.add(points);
            } catch (Exception e) {
                //
            }
        }
    }

    /**
     * Searches for max values of X and Y
     */
    private void prepareMaxXY() {
        searchXMax();
        searchYMax();
    }

    /**
     * Searches for max X value
     */
    private void searchXMax() {
        if (!data.isEmpty()) {
            maxX = data.get(0).get(0).x;

            for (int i = 1; i < data.size(); i++) {
                float v = data.get(i).get(0).x;
                if (v > maxX) maxX = v;
            }
        }
    }

    /**
     * Searches for max Y value
     */
    private void searchYMax() {
        if (!data.isEmpty()) {
            maxY = data.get(0).get(0).y;

            for (int i = 0; i < data.size(); i++) {
                Vector<Point2D.Float> vec = data.get(i);
                for (int j = 0; j < vec.size(); j++) {
                    float v = vec.get(j).y;
                    if (v > maxY) maxY = v;
                }
            }
        }
    }


    /**
     * Returns max X value
     * @return - max X
     */
    public float getMaxX() {
        return maxX;
    }

    /**
     * Returns max Y value
     * @return - max Y
     */
    public float getMaxY() {
        return maxY;
    }

    /**
     * Returns count of rows
     * @return row count
     */
    public int getSize() {
        return data.size();
    }

    /**
     * Returns concrete row of points
     * @param i - row number
     * @return vector of points2d objects
     */
    public Vector<Point2D.Float> get(int i) {
        return data.get(i);
    }

}

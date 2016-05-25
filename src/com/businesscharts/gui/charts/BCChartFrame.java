package com.businesscharts.gui.charts;


import com.businesscharts.data.BCDimensions;

import javax.swing.*;
import java.awt.*;

/**
 * ChartFrame is a class witch gets chart to show it
 */
public class BCChartFrame extends JFrame {

    /**
     * Creates frame to show chart
     * @param chart - this will be added in frame and shown
     */
    public BCChartFrame(BCChart chart) {

        add(chart);
        setUpAndShow();
    }

    /**
     * Base setup for frame
     */
    private void setUpAndShow() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(BCDimensions.CHART_FRAME_SIZE);
        setPreferredSize(BCDimensions.CHART_FRAME_SIZE);
        setSize(new Dimension(
                (int) (BCDimensions.SCREEN_SIZE.width * 0.6),
                (int) (BCDimensions.SCREEN_SIZE.height * 0.6)
        ));
        setTitle("CHART");
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

package com.businesscharts.gui.main.buttons;

import com.businesscharts.data.BCTDData;
import com.businesscharts.gui.charts.BCChart;
import com.businesscharts.gui.charts.BCChartFrame;
import com.businesscharts.gui.charts.BCTDChart;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BCTDButton extends BCChartButton {

    public BCTDButton(DefaultTableModel model) {
        super("TD", model);

        addActionListener(new Listener());
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BCTDData data = new BCTDData(model);

            BCChart chart = new BCTDChart(data);
            new BCChartFrame(chart);
        }
    }
}

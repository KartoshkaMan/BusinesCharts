package com.businesscharts.gui.main.buttons;

import com.businesscharts.data.BCSColumnData;
import com.businesscharts.gui.charts.BCChart;
import com.businesscharts.gui.charts.BCChartFrame;
import com.businesscharts.gui.charts.BCStackedColumn;
import com.sun.istack.internal.NotNull;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BCGG2Button extends BCChartButton {

    public BCGG2Button(@NotNull DefaultTableModel model) {
        super("GG2", model);
        addActionListener(new Listener());
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BCSColumnData data = new BCSColumnData(model);
            BCChart chart = new BCStackedColumn(data);
            new BCChartFrame(chart);
        }
    }

}

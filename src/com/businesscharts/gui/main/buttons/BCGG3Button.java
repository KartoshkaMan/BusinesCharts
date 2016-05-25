package com.businesscharts.gui.main.buttons;

import com.businesscharts.data.BCNSColumnData;
import com.businesscharts.gui.charts.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BCGG3Button extends BCChartButton {

    public BCGG3Button(DefaultTableModel model) {
        super("GG3", model);

        addActionListener(new Listener());
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            BCNSColumnData data = new BCNSColumnData(model);
            BCChart chart = new BCNormalizedStackColumn(data);
            new BCChartFrame(chart);
        }
    }
}

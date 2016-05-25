package com.businesscharts.gui.main.buttons;

import javax.swing.table.DefaultTableModel;

class BCChartButton extends BCAbstractButton {

    protected DefaultTableModel model;

    public BCChartButton(String str, DefaultTableModel model) {
        super(str);
        this.model = model;
    }

}

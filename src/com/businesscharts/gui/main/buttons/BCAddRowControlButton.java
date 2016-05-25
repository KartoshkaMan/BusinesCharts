package com.businesscharts.gui.main.buttons;

import com.businesscharts.data.BCDefaultTableModel;
import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BCAddRowControlButton extends BCControlButton {

    public BCAddRowControlButton(@NotNull JTable table) {
        super("+", table);

        addActionListener(new Listener());
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addRow(BCDefaultTableModel.getEmptyVector(model.getColumnCount()));
        }
    }

}

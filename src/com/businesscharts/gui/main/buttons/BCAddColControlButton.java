package com.businesscharts.gui.main.buttons;

import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BCAddColControlButton extends BCControlButton {

    public BCAddColControlButton(@NotNull JTable table) {
        super("+", table);

        addActionListener(new Listener());
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = ((DefaultTableModel) table.getModel());
            model.addColumn("Col#" + (table.getColumnCount() + 1));
            table.setModel(model);
        }
    }

}

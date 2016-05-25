package com.businesscharts.gui.main.buttons;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BCDelRowControlButton extends BCControlButton {
    public BCDelRowControlButton(JTable table) {
        super("-", table);
        addActionListener(new Listener());
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if (model.getRowCount() == 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Table is empty!"
                );
            }
            else model.removeRow(model.getRowCount() - 1);
        }
    }
}

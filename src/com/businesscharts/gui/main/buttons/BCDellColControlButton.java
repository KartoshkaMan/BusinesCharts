package com.businesscharts.gui.main.buttons;

import com.sun.istack.internal.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BCDellColControlButton extends BCControlButton {

    public BCDellColControlButton(@NotNull JTable table) {
        super("-", table);

        addActionListener(new Listener());
    }

    private class Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // get model from table
            DefaultTableModel model = (DefaultTableModel) table.getModel();

            // message if table is empty
            if (model.getColumnCount() == 0) {
                JOptionPane.showMessageDialog(
                        null,
                        "Table is empty!"
                );
            }
            else {
                // get data from model
                Vector data = model.getDataVector();

                // remove last item in each row
                for (int i = 0; i < data.size(); i++) {
                    Vector current = (Vector)data.get(i);
                    current.remove(current.size() - 1);
                }

                // get all headers exclude last
                Vector<String> name = new Vector<>();
                for (int i = 0; i < model.getColumnCount() - 1; i++)
                    name.add(model.getColumnName(i));

                model.setDataVector(data, name);
            }
        }
    }
}

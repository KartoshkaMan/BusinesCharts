package com.businesscharts.gui.main;

import com.businesscharts.data.BCDefaultTableModel;
import com.businesscharts.gui.main.buttons.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class BCMainFrame extends JFrame {

    JTable table = new JTable(BCDefaultTableModel.getModel());

    public BCMainFrame() {

        setLayout(new BorderLayout());
        add(colControlPanel(), BorderLayout.SOUTH);
        add(drawingPanel(), BorderLayout.NORTH);
        add(rowControlPanel(), BorderLayout.EAST);
        add(rowControlPanel(), BorderLayout.WEST);
        add(tablePanel(), BorderLayout.CENTER);

        setUpAndShow();

    }

    private JPanel colControlPanel() {
        JButton add = new BCAddColControlButton(table);
        JButton del = new BCDellColControlButton(table);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        panel.add(del);
        panel.add(add);

        return panel;
    }
    private JPanel drawingPanel() {
        JButton gg2 = new BCGG2Button((DefaultTableModel) table.getModel());
        JButton gg3 = new BCGG3Button((DefaultTableModel) table.getModel());
        JButton td  = new BCTDButton((DefaultTableModel) table.getModel());

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        panel.add(gg2);
        panel.add(gg3);
        panel.add(td);

        return panel;
    }
    private JPanel rowControlPanel() {
        JButton add = new BCAddRowControlButton(table);
        JButton del = new BCDelRowControlButton(table);


        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(10,10, 10, 10));
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(Box.createVerticalGlue());
        panel.add(del);
        panel.add(Box.createRigidArea(new Dimension(0, 5)));
        panel.add(add);
        panel.add(Box.createVerticalGlue());

        return panel;
    }
    private JScrollPane tablePanel() {
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        JScrollPane scroller = new JScrollPane(
                table,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
        );

        return scroller;
    }

    private void setUpAndShow() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension((int) (screenSize.width * 0.6), (int) (screenSize.height * 0.6)));
        setTitle("BCCharts");

        setBackground(Color.WHITE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

package com.businesscharts.gui.main.buttons;

import com.sun.istack.internal.NotNull;

import javax.swing.*;

class BCControlButton extends BCAbstractButton {
    protected JTable table;

    public BCControlButton(@NotNull String str, @NotNull JTable table) {
        super(str);

        if (table == null)
            throw new NullPointerException();

        this.table = table;
    }
}

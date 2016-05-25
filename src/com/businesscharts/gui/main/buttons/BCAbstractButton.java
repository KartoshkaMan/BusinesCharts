package com.businesscharts.gui.main.buttons;

import com.businesscharts.data.BCDimensions;
import com.sun.istack.internal.NotNull;

import javax.swing.*;

class BCAbstractButton extends JButton {

    public BCAbstractButton(@NotNull String str) {

        super(str);

        setMaximumSize(BCDimensions.BUTTON_SIZE);
        setMinimumSize(BCDimensions.BUTTON_SIZE);
        setPreferredSize(BCDimensions.BUTTON_SIZE);
    }

}

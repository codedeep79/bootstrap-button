package com.nth;

import javax.swing.UIDefaults;
import javax.swing.plaf.basic.BasicLookAndFeel;

/**
 * 
 * @author HAU TRUNG NGUYEN <haunt.hcm2015@gmail.com>
 */
@SuppressWarnings("serial")
public class JBootstrapLF extends BasicLookAndFeel {

    public static final String JBOOTSTRAP_CLASS = "jbootstrap-class";

    @Override
    public String getDescription() {
        return "Swing Look and Feel based on Twitter Bootstrap";
    }

    @Override
    public String getID() {
        return "JBootstrap";
    }

    @Override
    public String getName() {
        return "JBootstrap";
    }

    @Override
    public boolean isNativeLookAndFeel() {
        return false;
    }

    @Override
    public boolean isSupportedLookAndFeel() {
        return true;
    }

    @Override
    protected void initClassDefaults(UIDefaults table) {
        super.initClassDefaults(table);
        StyleButton.registerStyles();
        StyleLabel.registerStyles();

        table.put("ButtonUI", JBootstrapButtonUI.class.getCanonicalName());
        table.put("LabelUI", JBootstrapLabelUI.class.getCanonicalName());
        table.put("TextFieldUI", JBootstrapTextFieldUI.class.getCanonicalName());
    }
}

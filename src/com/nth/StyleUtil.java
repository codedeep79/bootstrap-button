package com.nth;

import java.awt.Color;
import java.awt.Toolkit;

/**
 *
 * @author HAU TRUNG NGUYEN <haunt.hcm2015@gmail.com>
 */
class StyleUtil {

    enum ComponentState {
        HOVER("hover"),
        ACTIVE("active"),
        DISABLED("disabled"),
        FOCUSED("focus");

        final String name;

        private ComponentState(String display) {
            this.name = display;
        }
    }

    static class StyleSimpleGradient {

        private final Color start;
        private final Color end;

        StyleSimpleGradient(Color start, Color end) {
            this.start = start;
            this.end = end;
        }

        Color getStart() {
            return this.start;
        }

        Color getEnd() {
            return this.end;
        }

        boolean isSolid() {
            return this.end == null || this.start.equals(this.end);
        }
    }

    static class StyleQuad<T> {

        private final T top;
        private final T bottom;
        private final T left;
        private final T right;

        StyleQuad(T top, T right, T bottom, T left) {
            this.top = top;
            this.right = right;
            this.bottom = bottom;
            this.left = left;
        }

        T getTop() {
            return this.top;
        }

        T getRight() {
            return this.right;
        }

        T getBottom() {
            return this.bottom;
        }

        T getLeft() {
            return this.left;
        }
    }

    enum BorderSide {
        TOP, LEFT, RIGHT, BOTTOM;
    }

    static int getComponentFontSize(int ptSize) {
       
        int screenRes = Toolkit.getDefaultToolkit().getScreenResolution();
        int fontSize = (int) Math.round(ptSize * screenRes / 72.0);
        return fontSize;
    }

    static float getAdjustedSize(int fontSize, float baseSize, int forEachBase, float toAdjustBy) {
        int delta = fontSize - 11;

        if (delta <= 0) {
            return baseSize;
        }

        return baseSize + delta * toAdjustBy / forEachBase;
    }

   
    public static int getAdjustedSize(int fontSize, int baseSize,
            int forEachBase, int toAdjustBy, boolean toRoundAsEven) {
        int delta = fontSize - 11;

        if (delta <= 0) {
            return baseSize;
        }

        int result = baseSize + delta * toAdjustBy / forEachBase;

        if (toRoundAsEven && (result % 2 != 0)) {
            result--;
        }

        return result;
    }
}

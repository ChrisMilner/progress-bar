package com.chrisdmilner.progressbar.style;

public class ProgressBarStyleFactory {

    private static final ProgressBarStyle DEFAULT_STYLE = new ProgressBarStyle(20, "", "", "|", "|", '=', ' ', '>', "Done!");

    public static ProgressBarStyle getDefaultStyle() {
        return  DEFAULT_STYLE;
    }
}

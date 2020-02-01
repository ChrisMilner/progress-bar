package com.chrisdmilner.progressbar.style;

public class ProgressBarRendererFactory {

    private static final ProgressBarRenderer DEFAULT_STYLE = new ProgressBarRenderer(20, "", "", "|", "|", '=', ' ', '>', "Done!");

    public static ProgressBarRenderer getDefaultStyle() {
        return  DEFAULT_STYLE;
    }
}

package com.chrisdmilner.progressbar.examples;

import com.chrisdmilner.progressbar.ProgressBar;
import com.chrisdmilner.progressbar.style.ProgressBarStyle;
import com.chrisdmilner.progressbar.style.ProgressBarStyleBuilder;

public class ManualIterationWithStyle implements Runnable {
    public static void main(String[] args) {
        new ManualIterationWithStyle().run();
    }

    @Override
    public void run() {
        int its = 500000000;

        ProgressBarStyle style = new ProgressBarStyleBuilder()
                .withWidth(50)
                .withTitle("Doing some stuff:")
                .withLabel("Loading:")
                .withStart("<")
                .withEnd(">")
                .withCompleted("#")
                .withUncompleted("-")
                .withHead("*")
                .withDoneMessage("Hurray!!! :D")
                .build();
        ProgressBar bar = new ProgressBar(its, style);

        bar.start();
        for (int i = 0; i < its; i++) {
            bar.step();
        }
    }
}

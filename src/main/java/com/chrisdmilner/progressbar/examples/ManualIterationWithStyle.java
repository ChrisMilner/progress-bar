package com.chrisdmilner.progressbar.examples;

import com.chrisdmilner.progressbar.ProgressBar;
import com.chrisdmilner.progressbar.style.ProgressBarRenderer;
import com.chrisdmilner.progressbar.style.ProgressBarRendererBuilder;

public class ManualIterationWithStyle implements Runnable {
    public static void main(String[] args) {
        new ManualIterationWithStyle().run();
    }

    @Override
    public void run() {
        int its = 20;

        ProgressBarRenderer style = new ProgressBarRendererBuilder()
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
            ExampleUtils.pause(0.1);
            bar.step();
        }
    }
}

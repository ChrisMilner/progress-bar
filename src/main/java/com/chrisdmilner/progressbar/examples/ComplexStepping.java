package com.chrisdmilner.progressbar.examples;

import com.chrisdmilner.progressbar.ProgressBar;

public class ComplexStepping implements Runnable {
    public static void main(String[] args) {
        new ComplexStepping().run();
    }

    @Override
    public void run() {
        int its = 20;
        ProgressBar bar = new ProgressBar(its);

        bar.start();
        for (int i = 0; i < its / 2; i++) {
            ExampleUtils.pause(0.1);
            if (i == its / 4) {
                bar.stepToProportion(0.5);
                break;
            }
            bar.step();
        }

        for (int i = 0; i < its / 2; i++) {
            ExampleUtils.pause(0.1);
            if (i == its / 4) {
                bar.done();
                break;
            }
            bar.step();
        }
    }
}

package com.chrisdmilner.progressbar.examples;

import com.chrisdmilner.progressbar.ProgressBar;

public class ManualIteration implements Runnable {
    public static void main(String[] args) {
        new ManualIteration().run();
    }

    @Override
    public void run() {
        int its = 20;
        ProgressBar bar = new ProgressBar(its);

        bar.start();
        for (int i = 0; i < its; i++) {
            ExampleUtils.pause(0.1);
            bar.step();
        }
    }
}

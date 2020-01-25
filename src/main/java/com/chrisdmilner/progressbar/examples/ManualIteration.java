package com.chrisdmilner.progressbar.examples;

import com.chrisdmilner.progressbar.ProgressBar;

public class ManualIteration {
    public static void main(String[] args) {
        int its = 500000000;
        ProgressBar bar = new ProgressBar(its);

        bar.start();
        for (int i = 0; i < its; i++) {
            bar.step();
        }
    }
}

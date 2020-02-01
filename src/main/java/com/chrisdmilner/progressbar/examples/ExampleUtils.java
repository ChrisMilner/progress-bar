package com.chrisdmilner.progressbar.examples;

class ExampleUtils {
    static void pause(double seconds) {
        try {
            Thread.sleep(Math.round(seconds * 1000));
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted while paused");
            e.printStackTrace();
        }
    }
}

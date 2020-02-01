package com.chrisdmilner.progressbar.examples;

class ExampleUtils {
    private static double pauseMultiplier = 1;

    static void setPauseMultiplier(double pauseMultiplier) {
        ExampleUtils.pauseMultiplier = pauseMultiplier;
    }

    static void pause(double seconds) {
        try {
            Thread.sleep(Math.round(seconds * 1000 * pauseMultiplier));
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted while paused");
            e.printStackTrace();
        }
    }
}

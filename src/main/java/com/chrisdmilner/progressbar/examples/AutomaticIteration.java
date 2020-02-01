package com.chrisdmilner.progressbar.examples;

import com.chrisdmilner.progressbar.ProgressBar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutomaticIteration implements Runnable {
    public static void main(String[] args) {
        new AutomaticIteration().run();
    }

    @Override
    public void run() {
        int its = 20;
        List<Integer> data = Stream.generate(() -> 1).limit(its).collect(Collectors.toList());

        for (int i : ProgressBar.iterate(data)) {
            ExampleUtils.pause(0.1);
        }
    }
}

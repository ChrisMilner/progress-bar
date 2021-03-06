package com.chrisdmilner.progressbar.examples;

import com.chrisdmilner.progressbar.ProgressBar;
import com.chrisdmilner.progressbar.style.ProgressBarRenderer;
import com.chrisdmilner.progressbar.style.ProgressBarRendererBuilder;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AutomaticIterationWithStyle implements Runnable {
    public static void main(String[] args) {
        new AutomaticIterationWithStyle().run();
    }

    @Override
    public void run() {
        int its = 20;
        List<Integer> data = Stream.generate(() -> 1).limit(its).collect(Collectors.toList());

        ProgressBarRenderer style = new ProgressBarRendererBuilder()
                .withWidth(30)
                .withLabel("Praising the sun:")
                .withStart("---===<<<")
                .withEnd(">>>===---")
                .withDoneMessage(" \\[T]/ ")
                .build();

        for (int i : ProgressBar.iterate(data, style)) {
            ExampleUtils.pause(0.1);
        }
    }
}

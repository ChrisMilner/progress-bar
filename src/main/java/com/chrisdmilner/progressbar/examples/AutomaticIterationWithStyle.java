package com.chrisdmilner.progressbar.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.chrisdmilner.progressbar.ProgressBar;
import com.chrisdmilner.progressbar.style.ProgressBarStyle;
import com.chrisdmilner.progressbar.style.ProgressBarStyleBuilder;

public class AutomaticIterationWithStyle {
    public static void main(String[] args) {
        int its = 100000000;
        List<Integer> data = Stream.generate(() -> 1).limit(its).collect(Collectors.toList());
        List<Integer> results = new ArrayList<>();

        ProgressBarStyle style = new ProgressBarStyleBuilder()
                .withWidth(30)
                .withLabel("Praising the sun:")
                .withStart("---===<<<")
                .withEnd(">>>===---")
                .withDoneMessage(" \\[T]/ ")
                .build();

        for (int i : ProgressBar.iterate(data, style)) {
            results.add(i * 2);
        }
    }
}

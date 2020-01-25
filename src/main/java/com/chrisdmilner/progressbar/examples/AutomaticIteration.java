package com.chrisdmilner.progressbar.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.chrisdmilner.progressbar.ProgressBar;

public class AutomaticIteration {
    public static void main(String[] args) {
        int its = 100000000;
        List<Integer> data = Stream.generate(() -> 1).limit(its).collect(Collectors.toList());
        List<Integer> results = new ArrayList<>();

        for (int i : ProgressBar.iterate(data)) {
            results.add(i * 2);
        }
    }
}

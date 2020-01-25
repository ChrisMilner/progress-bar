package com.chrisdmilner.progressbar;

import com.chrisdmilner.progressbar.style.ProgressBarStyle;
import com.chrisdmilner.progressbar.style.ProgressBarStyleFactory;

public class ProgressBar {
    private final int totalIterations;
    private final ProgressBarStyle style;

    private int currentStep;
    private int progress;

    public ProgressBar(int totalIterations, ProgressBarStyle style) {
        this.totalIterations = totalIterations;
        this.style = style;
    }

    public ProgressBar(int totalIterations) {
        this(totalIterations, ProgressBarStyleFactory.getDefaultStyle());
    }

    public static <K> ProgressBarIterable<K> iterate(Iterable<K> iterable, ProgressBarStyle style) {
        return new ProgressBarIterable<>(iterable, style);
    }

    public static <K> ProgressBarIterable<K> iterate(Iterable<K> iterable) {
        return new ProgressBarIterable<>(iterable, ProgressBarStyleFactory.getDefaultStyle());
    }

    public void start() {
        validate();

        currentStep = 0;
        progress = 0;

        if (!style.title.isBlank()) {
            System.out.println(style.title);
        }
        printProgressBar();
    }

    public void step() {
        validate();

        currentStep++;
        int next_progress = (int) (currentStep / (totalIterations / (float) style.width));

        if (next_progress > progress || currentStep == totalIterations) {
            progress = next_progress;
            printProgressBar();
        }
    }

    private void validate() {
        if (totalIterations <= 0) {
            throw new IllegalStateException("Invalid number of total iterations defined");
        }
    }

    private void printProgressBar() {
        System.out.print(style.label + " " + style.start);
        for (int i = 0; i < style.width; i++) {
            if (i < progress) {
                System.out.print(style.completed);
            } else if (i < progress + 1) {
                System.out.print(style.head);
            } else {
                System.out.print(style.uncompleted);
            }
        }
        System.out.print(style.end);

        if (currentStep == totalIterations) {
            System.out.print(" " + style.doneMessage + "\n");
        } else {
            System.out.print("\r");
        }
    }
}

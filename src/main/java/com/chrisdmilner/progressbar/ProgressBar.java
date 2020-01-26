package com.chrisdmilner.progressbar;

import com.chrisdmilner.progressbar.style.ProgressBarStyle;
import com.chrisdmilner.progressbar.style.ProgressBarStyleFactory;
import com.google.common.base.Preconditions;

public class ProgressBar {
    private final int totalSteps;
    private final ProgressBarStyle style;

    private int currentStep;

    public static <K> ProgressBarIterable<K> iterate(Iterable<K> iterable, ProgressBarStyle style) {
        return new ProgressBarIterable<>(iterable, style);
    }

    public static <K> ProgressBarIterable<K> iterate(Iterable<K> iterable) {
        return new ProgressBarIterable<>(iterable, ProgressBarStyleFactory.getDefaultStyle());
    }

    public ProgressBar(int totalSteps, ProgressBarStyle style) {
        Preconditions.checkState(totalSteps > 0,  "Invalid number of total iterations");

        this.totalSteps = totalSteps;
        this.style = style;
    }

    public ProgressBar(int totalSteps) {
        this(totalSteps, ProgressBarStyleFactory.getDefaultStyle());
    }

    int getCurrentStep() {
        return currentStep;
    }

    public void start() {
        currentStep = 0;
        style.init();
    }

    public void step() {
        Preconditions.checkState(currentStep < totalSteps, "You cannot step past the total number of steps");

        currentStep++;
        updateBar();
    }

    public void stepTo(int step) {
        Preconditions.checkArgument(step >= 0 && step <= totalSteps, "Step must be greater than zero and less than the total");

        currentStep = step;
        updateBar();
    }

    public void stepToProportion(double proportion) {
        Preconditions.checkArgument(proportion >= 0 && proportion <= 1, "Proportion must be between 0 and 1");

        currentStep = (int) (proportion * totalSteps);
        updateBar();
    }

    public void done() {
        currentStep = totalSteps;
        style.finish();
    }

    private void updateBar() {
        if (currentStep >= totalSteps) {
            style.finish();
        } else {
            style.update(currentStep / (double) totalSteps);
        }
    }
}

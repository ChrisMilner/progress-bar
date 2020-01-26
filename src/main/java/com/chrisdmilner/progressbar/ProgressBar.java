package com.chrisdmilner.progressbar;

import com.chrisdmilner.progressbar.style.ProgressBarStyle;
import com.chrisdmilner.progressbar.style.ProgressBarStyleFactory;
import com.google.common.base.Preconditions;

public class ProgressBar {
    private final int totalSteps;
    private final ProgressBarStyle style;

    private int currentStep;

    public ProgressBar(int totalSteps, ProgressBarStyle style) {
        this.totalSteps = totalSteps;
        this.style = style;
    }

    public ProgressBar(int totalSteps) {
        this(totalSteps, ProgressBarStyleFactory.getDefaultStyle());
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
        style.init();
    }

    public void step() {
        validate();

        currentStep++;
        updateBar();
    }

    public void stepTo(int step) {
        validate();
        Preconditions.checkState(step >= 0, "Step must be greater than zero");

        currentStep = step;
        updateBar();
    }

    public void stepToProportion(double proportion) {
        validate();
        Preconditions.checkState(proportion >= 0 && proportion <= 1, "Proportion must be between 0 and 1");

        currentStep = (int) (proportion * totalSteps);
        updateBar();
    }

    public void done() {
        validate();

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

    private void validate() {
        Preconditions.checkState(totalSteps > 0, "Invalid number of total iterations");
    }
}

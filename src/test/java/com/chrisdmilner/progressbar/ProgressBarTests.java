package com.chrisdmilner.progressbar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgressBarTests {
    private final ProgressBar bar = new ProgressBar(10);

    @BeforeEach
    void beforeEach() {
        bar.start();
        checkCurrentStep(0);
    }

    @Test
    void testStepping() {
        for (int i = 0; i < 10; i++) {
            bar.step();
            Assertions.assertEquals(i + 1, bar.getCurrentStep());
        }
    }

    @Test
    void testStepTo() {
        bar.stepTo(5);
        checkCurrentStep(5);

        bar.stepTo(1);
        checkCurrentStep(1);

        bar.stepTo(10);
        checkCurrentStep(10);
    }

    @Test
    void testStepToProportion() {
        bar.stepToProportion(0.5);
        checkCurrentStep(5);

        bar.stepToProportion(0.1);
        checkCurrentStep(1);

        bar.stepToProportion(1.0);
        checkCurrentStep(10);
    }

    @Test
    void testDone() {
        bar.done();
        checkCurrentStep(10);
    }

    @Test
    void testNegativeTotalStepsThrowsException() {
        Assertions.assertThrows(IllegalStateException.class, () -> new ProgressBar(-1));
    }

    @Test
    void testTotalStepsBeingExceededThrowsException() {
        bar.stepToProportion(1.0);
        checkCurrentStep(10);

        Assertions.assertThrows(IllegalStateException.class, bar::step);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bar.stepTo(11));
    }

    @Test
    void testInvalidProportionThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> bar.stepToProportion(-0.1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> bar.stepToProportion(1.1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> bar.stepToProportion(20));
    }

    private void checkCurrentStep(int step) {
        Assertions.assertEquals(step, bar.getCurrentStep());
    }
}

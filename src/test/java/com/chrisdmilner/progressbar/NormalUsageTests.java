package com.chrisdmilner.progressbar;

import com.chrisdmilner.progressbar.examples.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class NormalUsageTests {

    @ParameterizedTest
    @MethodSource("provideExamples")
    void testExamples(Runnable example) {
        Assertions.assertDoesNotThrow(example::run);
    }

    private static Stream<Arguments> provideExamples() {
        return Stream.of(
                Arguments.of(new ManualIteration()),
                Arguments.of(new ManualIterationWithStyle()),
                Arguments.of(new AutomaticIteration()),
                Arguments.of(new AutomaticIterationWithStyle()),
                Arguments.of(new ComplexStepping()));
    }
}

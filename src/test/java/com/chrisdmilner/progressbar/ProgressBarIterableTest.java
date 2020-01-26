package com.chrisdmilner.progressbar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

class ProgressBarIterableTest {
    @ParameterizedTest
    @MethodSource("provideIterables")
    void testIterableReturnsTheSameResults(Iterable<Integer> iterable) {
        ProgressBarIterable<Integer> wrappedIterable = new ProgressBarIterable<>(iterable);

        ArrayList<Integer> expected = new ArrayList<>();
        ArrayList<Integer> actual = new ArrayList<>();

        for (int i : iterable) {
            expected.add(i);
        }

        for (int i : wrappedIterable) {
            actual.add(i);
        }

        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideIterables() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5)),
                Arguments.of(Set.of(1, 2, 3, 4, 5)));
    }
}

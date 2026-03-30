package dsa.exercises.strings;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OneAwayTest {
    private final OneAway oneAway = new OneAway();

    @ParameterizedTest(name = "Run {index}: input={0}, {1}, output={2}")
    @MethodSource("oneEditAwayTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testOneEditAway (String input1, String input2, boolean expected) {
        assertEquals(expected, oneAway.oneEditAway1(input1, input2),
                "Failed for input" + input1 + ", " + input2);
    }

    private static Stream<Arguments> oneEditAwayTestCases () {
        return Stream.of(
                Arguments.of("pale", "ple", true),
                Arguments.of("cod", "cdo", false),
                Arguments.of("abc", "abcdddd", false),
                Arguments.of("a", "", true)
        );
    }
}
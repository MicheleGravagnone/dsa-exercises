package dsa.exercises.strings;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationTest {
    private final PalindromePermutation palindromePermutation = new PalindromePermutation();

    @ParameterizedTest(name = "Run {index}: input={0}, expected={1}")
    @MethodSource("isPalindromePermutationTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testIsPalindromePermutation (String input, boolean expected) {
        assertEquals (expected, palindromePermutation.isPalindromePermutation(input),
                "Failed for input: " + input);
    }

    @ParameterizedTest(name = "Run {index}: input={0}, expected={1}")
    @MethodSource("isPalindromePermutationTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testIsPalindromePermutation1 (String input, boolean expected) {
        assertEquals (expected, palindromePermutation.isPalindromePermutation1(input),
                "Failed for input: " + input);
    }

    private static Stream<Arguments> isPalindromePermutationTestCases () {
        return Stream.of(
                Arguments.of("eded", true),
                Arguments.of("Taoc t ac", true),
                Arguments.of(" b O B", true),
                Arguments.of("aaaaa", true),
                Arguments.of("", false)
        );
    }

}
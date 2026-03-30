package dsa.exercises.strings;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class URLifyTest {
    private final URLify urlify = new URLify();

    @ParameterizedTest(name = "Run {index}: input=\"{0}\", \"{1}\",  expected=\"{2}\"")
    @MethodSource("replaceSpacesTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testReplaceSpaces1 (char[] input1, int input2, char[] expected) {
        assertArrayEquals (expected, urlify.replaceSpaces1(input1, input2),
                "Failed for input: " + Arrays.toString(input1) + ", " + input2);
    }

    private static Stream<Arguments> replaceSpacesTestCases () {
        return Stream.of (
                Arguments.of("Mr John Smith    ".toCharArray(), 13, "Mr%20John%20Smith".toCharArray()),
                Arguments.of("HelloWorld".toCharArray(), 10, "HelloWorld".toCharArray()),
                Arguments.of("a  b    ".toCharArray(), 4, "a%20%20b".toCharArray()),
                Arguments.of(" a  ".toCharArray(), 2, "%20a".toCharArray()),
                Arguments.of("a   ".toCharArray(), 2, "a%20".toCharArray()),
                Arguments.of("        ".toCharArray(), 2, "%20%20  ".toCharArray()),
                Arguments.of("a b    ".toCharArray(), 3, "a%20b  ".toCharArray()),
                Arguments.of(new char[0], 0, new char[0])
        );
    }
}
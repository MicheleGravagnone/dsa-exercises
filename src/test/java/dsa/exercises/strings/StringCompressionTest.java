package dsa.exercises.strings;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCompressionTest {

    private final StringCompression compressor = new StringCompression();

    @ParameterizedTest(name = "Run {index}: input=\"{0}\", expected=\"{1}\"")
    @MethodSource("compressionTestCases")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testCompressString(String input, String expected) {
        assertEquals(expected, compressor.compressString(input));
    }

    private static Stream<Arguments> compressionTestCases() {
        return Stream.of(
                Arguments.of("aabcccccaaa", "a2b1c5a3"),
                Arguments.of("abcd", "abcd"),
                Arguments.of("aabb", "aabb"),
                Arguments.of("a", "a"),
                Arguments.of("", ""),
                Arguments.of("zzzzz", "z5"),
                Arguments.of("aaaaaaaaaaaaaaa", "a15"),
                Arguments.of("AAbbCC", "AAbbCC"),
                Arguments.of("AABBCCcc", "AABBCCcc"),
                Arguments.of("aA", "aA")
        );
    }
}
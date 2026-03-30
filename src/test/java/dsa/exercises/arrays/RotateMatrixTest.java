package dsa.exercises.arrays;

import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class RotateMatrixTest {
    private final RotateMatrix rotator = new RotateMatrix();

    @ParameterizedTest(name = "RUN {index}: Valid NxN Matrix")
    @MethodSource("validMatrixProvider")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testRotateMatrixValid(int[][] input, int[][] expected) {
        assertTrue(rotator.rotateMatrix(input));
        assertTrue(Arrays.deepEquals(expected, input));
    }

    @ParameterizedTest(name = "RUN {index}: Invalid Matrix")
    @MethodSource("invalidMatrixProvider")
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testRotateMatrixInvalid(int[][] input) {
        assertFalse(rotator.rotateMatrix(input));
    }

    private static Stream<Arguments> validMatrixProvider() {
        return Stream.of(
                Arguments.of(
                        new int[][]{{1}},
                        new int[][]{{1}}
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        },
                        new int[][]{
                                {3, 1},
                                {4, 2}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        new int[][]{
                                {7, 4, 1},
                                {8, 5, 2},
                                {9, 6, 3}
                        }
                ),
                Arguments.of(
                        new int[][]{
                                {5, 1, 9, 11},
                                {2, 4, 8, 10},
                                {13, 3, 6, 7},
                                {15, 14, 12, 16}
                        },
                        new int[][]{
                                {15, 13, 2, 5},
                                {14, 3, 4, 1},
                                {12, 6, 8, 9},
                                {16, 7, 10, 11}
                        }
                )
        );
    }

    private static Stream<Arguments> invalidMatrixProvider() {
        return Stream.of(
                Arguments.of((Object) null),
                Arguments.of((Object) new int[0][0]),
                Arguments.of((Object) new int[][]{
                        {1, 2, 3},
                        {4, 5, 6}
                }),
                Arguments.of((Object) new int[][]{
                        {1, 2},
                        {3, 4},
                        {5, 6}
                })
        );
    }
}
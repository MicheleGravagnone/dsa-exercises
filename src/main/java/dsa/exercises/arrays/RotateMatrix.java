package dsa.exercises.arrays;

/*
 * Problem: CTCI 1.7 - Rotate Matrix
 * Topic: Arrays
 */

public class RotateMatrix {

    /*
     * Approach:
     * The only way we can do this is by swapping clockwise the elements by layers.
     * I cannot see any possible optimization.
     *
     * Time: O(n^2)
     * Space: O(1)
     */

    public boolean rotateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }

        int len = matrix.length;

        for (int i = 0; i < len / 2; i++) {
            int first = i;
            int last = len - 1 - i;

            for (int j = first; j < last; j++) {
                int offset = j - first;

                int top = matrix[first][j];

                matrix[first][j] = matrix[last - offset][first];

                matrix[last - offset][first] = matrix[last][last - offset];

                matrix[last][last - offset] = matrix[j][last];

                matrix[j][last] = top;
            }
        }

        return true;
    }
}

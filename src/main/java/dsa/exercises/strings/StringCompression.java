package dsa.exercises.strings;

import java.util.*;

/*
 * Problem: CTCI 1.6 - String Compression
 * Topic: Strings
 */

public class StringCompression {

    /*
     * Approach:
     * A possible approach could've been with a HashMap holding {character,frequency} pairs
     * but such data structure doesn't take into account the order of letters in the String.
     * I will prefer a two pointer approach in a dynamic sliding window pattern,
     * so that we can easily distinguish portions of String with the same letter and find their
     * frequency for our compression purposes.
     *
     * Time: O(N)
     * Space: O(N)
     */

    public String compressString (String s) {
        if (s == null || s.isEmpty()) return s;

        int left = 0, right = 0;
        StringBuilder sb = new StringBuilder();

        while (left <= right && right < s.length()) {
            char first = s.charAt(left);
            char last = s.charAt(right);

            if (first == last) {
                right++;
            } else {
                int len = right - left;
                sb.append(first).append(len);
                left = right;
            }
        }

        sb.append(s.charAt(left)).append(right - left);

        return sb.length() < s.length() ? sb.toString() : s;
    }


    /*---------------------------------------------------------------------*/


    /*
     * Approach:
     * A better approach to avoid mantaining 2 pointer variables could be looping
     * once through the array and keeping a check variable to count consecutive characters.
     *
     * Time: O(N)
     * Space: O(N)
     */

    public String compressString1 (String s) {
        if (s == null || s.isEmpty()) return s;

        StringBuilder sb = new StringBuilder();
        int countConsecutive = 0;

        for (int i = 0; i < s.length(); i++) {
            countConsecutive++;

            if (i + 1 >= s.length() || s.charAt(i) != s.charAt(i + 1)) {
                sb.append(s.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return sb.length() < s.length() ? sb.toString() : s;
    }
}

package dsa.exercises.strings;

import java.util.*;

/*
 * Problem: CTCI 1.4 - Palindrome permutation
 * Topic: Strings
 */

public class PalindromePermutation {

    /*
     * Approach:
     * I would observe that a palindrome is a sentence/word where each letter appears
     * an even amount of times, except for the middle letter (which is the symmetry pivot) if
     * the string has odd length.
     * For instance,:
     * bob -> b(2), o(1) | odd length
     * civic -> c(2), i(2), v(1) | odd length
     * deed -> d(2), e(2) | even length
     *
     * My approach would be to replace all whitespaces in the string, build a frequency map
     * of all characters and then check the frequencies to make sure they respect
     * the observation I made above.
     *
     * EDIT: an edge case string like "aaaaa" would also be a palindrome, so what we need to
     * track is the amount of elements with odd frequency instead of just a single pivot and
     * make sure it's at most 1.
     *
     *
     * Time: O(N)
     * Space: O(N)
     */

    public boolean isPalindromePermutation (String s) {
        if (s.isEmpty()) return false;
        int oddCount = 0;

        s = s.replaceAll("\\s+", "").toLowerCase();
        Map<Character, Integer> charMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (int value : charMap.values()) {
            if (value % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

}

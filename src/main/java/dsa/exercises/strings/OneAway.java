package dsa.exercises.strings;

import java.util.*;

/*
 * Problem: CTCI 1.5 - One Away
 * Topic: Strings
 */

public class OneAway {

    /*
     * Approach:
     * Given two string s and t, they're one edit away from each other if
     * one character at max in t is different from s.
     * I would implement a charFreq hashmap and keep track of the frequency
     * of each character in s, then iterate through the second string and verify
     * the frequencies in t.
     *
     * Time: O(N)
     * Space: O(N)
     */

    public boolean oneEditAway (String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;

        Map<Character, Integer> charFreq = new HashMap<>();

        for (char c : s.toCharArray()) {
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        int diff = 0;
        for (char c : t.toCharArray()) {
            if (!charFreq.containsKey(c)) {
                diff++;
            } else {
                if (charFreq.get(c) < 0) {
                    return false;
                }
                charFreq.put(c, charFreq.get(c) - 1);
            }
        }

        return diff < 2;

        // Faulty implementation because implementing a frequency map doesn't take into account
        // the order of letters, where specific letter ordering could impact the amount of
        // edits needed despite correct frequencies
    }


    /*---------------------------------------------------------------------*/

    /*
     * Approach:
     * Building upon the previous consideration, I would implement the solution through a two
     * pointer approach where each pointer walks through its respective string.
     * We keep track of the diff and return accordingly
     *
     *
     * Time: O(N)
     * Space: O(1)
     */

    public boolean oneEditAway1 (String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;

        int first = 0, second = 0;
        boolean diff = false;

        while (first < s.length() && second < t.length()) {
            if (s.charAt(first) != t.charAt(second)) {
                if (diff) return false;
                diff = true;

                if (s.length() > t.length()) {
                    first++;
                } else if (s.length() < t.length()) {
                    second++;
                } else {
                    first++;
                    second++;
                }
            } else {
                first++;
                second++;
            }
        }

        return true;
    }


}

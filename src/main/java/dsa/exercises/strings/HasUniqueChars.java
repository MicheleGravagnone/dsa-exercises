package dsa.exercises.strings;

import java.util.*;

/*
 * Problem: CTCI 1.1 - Is Unique
 * Topic: Strings
 */

public class HasUniqueChars {

    /*
     * Approach:
     * We use a HashSet to track characters from the string, when a duplicate appears
     * we return.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public boolean hasUniqueChars (String s) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) return false;
            charSet.add(c);
        }

        return true;
    }

    /*
     * Approach:
     * If we assume the String is made up only by lowercase ASCII characters, we can store
     * 0/1 values in an integer (32bits in Java, enough for 26 letters) instead of creating
     * a frequency array.
     *
     * Time: O(n)
     * Space: O(1)
     */
    public boolean hasUniqueChars1 (String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false; // if char was found (<< for 1-based indexing, & for checking)
            checker |= (1 << val); // add character
        }

        return true;
    }

}

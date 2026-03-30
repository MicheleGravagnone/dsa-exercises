package dsa.exercises.strings;

import java.util.*;

/*
 * Problem: CTCI 1.2 - Is Permutation
 * Topic: Strings
 */

public class StringIsPermutation {

    /*
     * Approach:
     * We use a helper method to sort the Strings, then we
     * return the value of the comparison between them.
     *
     * Time: O(n logn)
     * Space: O(n)
     */
    public boolean stringIsPermutation (String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    public String sort (String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
        // TIME COMPLEXITY | O(N LOG N)
        // SPACE COMPLEXITY | O(N)
    }


    /*---------------------------------------------------------------------*/


    /*
     * Approach:
     * We initialize a 128 char long array and store the frequency of each character in s.
     * We loop through the second String and return if a character was not present in the first String
     * so it's frequency is < 0.
     *
     * Time: O(n)
     * Space: O(n)
     */
    public boolean stringIsPermutation1 (String s, String t) {
        if (s.length() != t.length()) return false;

        char[] alphabet = new char[128]; // Assuming non-extended ASCII characters
        for (int i = 0; i < s.length(); i++) {
            int c = (int) s.charAt(i);
            alphabet[c]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int c = (int) t.charAt(i);
            alphabet[c]--;

            if(alphabet[c] < 0) return false;
        }

        return true;
    }
}

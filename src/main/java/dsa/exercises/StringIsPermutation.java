package dsa.exercises;

import java.util.*;

/*
 * 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 * Pg 90
 * */

public class StringIsPermutation {

    public boolean stringIsPermutation (String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
        // TIME COMPLEXITY | O(N LOGN)
        // SPACE COMPLEXITY | O(N)
    }

    public String sort (String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
        // TIME COMPLEXITY | O(N LOG N)
        // SPACE COMPLEXITY | O(N)
    }
}

package dsa.exercises;

import java.util.*;

/*
 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 * pg90
 * */

public class HasUniqueChars {

    public boolean hasUniqueChars (String s) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (charSet.contains(c)) return false;
            charSet.add(c);
        }

        return true;
        // TIME COMPLEXITY | O(N)
        // SPACE COMPLEXITY | 0(2N)
    }

    // Assuming ASCII lowercase letters a-z
    public boolean hasUniqueChars1 (String s) {
        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false; // if char was found (<< for 1-based indexing, & for checking)
            checker |= (1 << val); // add character
        }

        return true;
        // TIME COMPLEXITY | O(N)
        // SPACE COMPLEXITY | O(1)
    }

}

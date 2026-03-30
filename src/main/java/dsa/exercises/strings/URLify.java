package dsa.exercises.strings;

import java.util.*;

/*
 * Problem: CTCI 1.3 - URLify
 * Topic: Strings
 */

public class URLify {

    /*
     * Approach:
     * As requested, we are using a char[] to do the substitution in-place.
     * Each space will be replaced by '%20', in a ratio of 1:3 hence needing
     * 2 extra character spaces in the array. The array given also has enough
     * space at the end to accommodate the extra characters.
     *
     * Time: O(n^2)
     * Space: O(1)
     */

    public char[] replaceSpaces (char[] s, int trueLength) {
        for (int i = 0; i < s.length; i++) {
            if (i < trueLength && s[i] == ' ') {
                for (int j = i; j < s.length; j++) {
                    s[j+3] = s[j];
                }
                s[i] = '%';
                s[i+1] = '2';
                s[i+2] = '0';
            }
        }

        return s;
        // Faulty implementation because it runs in IndexOutOfBounds exceptions
        // and overwrites pre-existing data. Right-shifting is tricky and the
        // better way to achieve it would be looping through the array backwards.
        // Time Complexity is also bad, with a nested for loop resulting in O(n^2)
    }


    /*---------------------------------------------------------------------*/


    /*
     * Approach:
     * We are using a char[] to do the substitution in-place.
     * We are using a two-pass approach where in a quick first pass we count how many
     * actual spaces we have, we find out the new length of the string once we
     * URLify it and we use a two pointer approach while iterating backwards to replace elements.
     *
     * Time: O(n)
     * Space: O(1)
     */

    public char[] replaceSpaces1 (char[] s, int trueLength) {
        int spaces = 0;
        for (int i = 0; i < trueLength; i++) { // for-each loop wouldn't work because it'd count also extra spaces
            if (s[i] == ' ') spaces++;         // and we don't want that
        }

        int newLength = trueLength + (spaces * 2); // One space is taken by '%' (previous ' ') and we just need to check
                                                // the necessary space for '20' hence why times 2
        int first = trueLength - 1, second = newLength - 1;

        while (first >= 0 && second >= 0) {
            if (s[first] == ' ') {
                s[second] = '0';
                s[second - 1] = '2';
                s[second - 2] = '%';
                second -= 3;
            } else {
                s[second] = s[first];
                second -= 1;
            }
            first--;
        }

        return s;
    }
}

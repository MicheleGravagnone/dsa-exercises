package dsa.exercises;

import java.util.*;

public class LargestElement {

    public int secondLargestElement(int[] arr) {
        int largest = -1;
        int secondLargest = -1;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public int thirdLargestElement(int[] arr) {
        int largest = -1;
        int secondLargest = -1;
        int thirdLargest = -1;

        for (int num : arr) {
            if (num > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            } else if (num > thirdLargest && num != secondLargest) {
                thirdLargest = num;
            }
        }

        return thirdLargest;
    }

    /*
    * 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
    * Pg 90
    * */

    public boolean isPermutation (String s, String t) {
        if (s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
        // TIME COMPLEXITY | O(N LOGN)
        // SPACE COMPLEXIITY | O(1)
    }

    public String sort (String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}

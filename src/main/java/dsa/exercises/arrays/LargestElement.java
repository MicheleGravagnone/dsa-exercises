package dsa.exercises.arrays;

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
}

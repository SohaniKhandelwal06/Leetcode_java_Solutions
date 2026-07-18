// Bubble Sort

/*
Approach:

1. Compare every pair of adjacent elements.
2. If the left element is greater than the right,
   swap them.
3. After each pass, the largest element moves
   to its correct position at the end.
4. Repeat for the remaining unsorted part.
5. If no swaps occur in a pass, the array is already
   sorted, so terminate early.

Time Complexity:
Best Case: O(N)       // Already sorted
Average Case: O(N²)
Worst Case: O(N²)

Space Complexity:
O(1)
*/

class Solution {

    public void bubbleSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}

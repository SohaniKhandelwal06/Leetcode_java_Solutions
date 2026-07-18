
// Insertion Sort

/*
Approach:

1. Assume the first element is already sorted.
2. Pick the next element (key).
3. Compare the key with elements on its left.
4. Shift all elements greater than the key
   one position to the right.
5. Insert the key into its correct position.
6. Repeat until the entire array is sorted.

Time Complexity:
Best Case: O(N)       // Already sorted
Average Case: O(N²)
Worst Case: O(N²)     // Reverse sorted

Space Complexity:
O(1)
*/




class Solution {

    public void insertionSort(int[] arr) {

        int n = arr.length;

        for (int i = 1; i < n; i++) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}

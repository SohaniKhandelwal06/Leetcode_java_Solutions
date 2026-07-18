// Selection Sort

/*
Approach:

1. Divide the array into two parts:
   - Sorted part
   - Unsorted part
2. For each position i:
   - Find the smallest element in the unsorted part.
   - Swap it with the element at index i.
3. Repeat until the entire array is sorted.

Time Complexity:
Best Case: O(N²)
Average Case: O(N²)
Worst Case: O(N²)

Space Complexity:
O(1)
*/
class Solution {

    public void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
}

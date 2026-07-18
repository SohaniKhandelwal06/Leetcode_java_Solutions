// Quick Sort

/*
Approach (Divide and Conquer):

1. Choose the first element as the pivot.
2. Place the pivot at its correct sorted position using
   the partition process.
3. During partition:
   - Move pointer i from the left until an element
     greater than the pivot is found.
   - Move pointer j from the right until an element
     smaller than or equal to the pivot is found.
   - Swap arr[i] and arr[j] if i < j.
4. After the pointers cross, swap the pivot with arr[j].
5. Recursively apply Quick Sort on:
   - Left subarray
   - Right subarray

Partition:
- Elements <= pivot go to the left.
- Elements > pivot go to the right.

Time Complexity:
Best Case: O(N log N)
Average Case: O(N log N)
Worst Case: O(N²)   // Pivot is always the smallest/largest

Space Complexity:
Average: O(log N) (recursion stack)
Worst: O(N)
*/

class Solution {

    public void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {

        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {

            while (i <= high - 1 && arr[i] <= pivot) {
                i++;
            }

            while (j >= low + 1 && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);

        return j;
    }

    private void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

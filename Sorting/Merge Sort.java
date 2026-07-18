// Merge Sort

/*
Approach (Divide and Conquer):

1. Divide the array into two halves recursively until
   each subarray contains only one element.
2. Merge the two sorted halves into a temporary array.
3. Copy the merged elements back into the original array.
4. Repeat until the entire array becomes sorted.

Merge Process:
- Compare the first elements of both halves.
- Insert the smaller one into the temporary array.
- Copy the remaining elements after one half is exhausted.

Time Complexity:
Best Case: O(N log N)
Average Case: O(N log N)
Worst Case: O(N log N)

Space Complexity:
O(N)
*/






class Solution {

    void mergeSort(int[] arr, int low, int high) {

        if (low >= high) return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    void merge(int[] arr, int low, int mid, int high) {

        ArrayList<Integer> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                temp.add(arr[right++]);
            }
        }

        while (left <= mid) {
            temp.add(arr[left++]);
        }

        while (right <= high) {
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}

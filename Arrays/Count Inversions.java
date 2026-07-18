// Count Inversions

/*
Definition:
An inversion is a pair (i, j) such that:
    i < j and arr[i] > arr[j]

Approach (Merge Sort):

1. Divide the array into two halves recursively.
2. Count inversions in:
   - Left half
   - Right half
3. During the merge step:
   - If arr[left] <= arr[right], copy arr[left].
   - Otherwise:
       * arr[left] > arr[right]
       * Since the left half is sorted, every element
         from left to mid is also greater than arr[right].
       * Number of inversions added:
             mid - left + 1
4. Merge the two sorted halves.
5. Return:
      leftCount + rightCount + mergeCount

Time Complexity: O(N log N)
Space Complexity: O(N)
*/
class Solution {

    static long inversionCount(long[] arr, long N) {
        return mergeSort(arr, 0, (int) N - 1);
    }

    static long mergeSort(long[] arr, int low, int high) {

        if (low >= high) return 0;

        int mid = low + (high - low) / 2;

        long count = 0;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);

        return count;
    }

    static long merge(long[] arr, int low, int mid, int high) {

        ArrayList<Long> temp = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        long count = 0;

        while (left <= mid && right <= high) {

            if (arr[left] <= arr[right]) {
                temp.add(arr[left++]);
            } else {
                count += (mid - left + 1);
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

        return count;
    }
}

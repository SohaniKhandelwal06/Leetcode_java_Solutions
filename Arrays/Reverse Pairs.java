// Leetcode - 493 - Reverse Pairs

/*
Definition:
A reverse pair is a pair (i, j) such that:
    i < j
    nums[i] > 2 * nums[j]

Approach (Merge Sort):

1. Divide the array recursively.
2. Count reverse pairs in:
   - Left half
   - Right half
3. Before merging:
   - Count reverse pairs between the two sorted halves.
4. Merge the halves.

Counting Reverse Pairs:
- Keep a pointer 'right' in the right half.
- For each element in the left half:
      while(arr[left] > 2 * arr[right])
            right++;
- Number of valid pairs:
      right - (mid + 1)

Use long to avoid integer overflow:
(long)arr[left] > 2L * arr[right]

Time Complexity: O(N log N)
Space Complexity: O(N)
*/

class Solution {

    int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] arr, int low, int high) {

        if (low >= high) return;

        int mid = low + (high - low) / 2;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
    }

    private void countPairs(int[] arr, int low, int mid, int high) {

        int right = mid + 1;

        for (int left = low; left <= mid; left++) {

            while (right <= high &&
                    (long) arr[left] > 2L * arr[right]) {
                right++;
            }

            count += right - (mid + 1);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {

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

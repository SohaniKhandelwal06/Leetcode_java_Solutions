// Binary Search

/*
Approach (Binary Search):
1. Initialize two pointers: low at the beginning and high at the end of the array.
2. Find the middle index using:
      mid = low + (high - low) / 2
   to avoid integer overflow.
3. If the middle element equals the target, return its index.
4. If the target is greater than the middle element, search in the right half.
5. Otherwise, search in the left half.
6. Repeat until the search space becomes empty.
7. If the target is not found, return -1.

Time Complexity: O(log N)
Space Complexity: O(1)
*/



class Solution {
    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}

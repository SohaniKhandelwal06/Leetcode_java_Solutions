// GFG - K-th Element of Two Sorted Arrays

/*
Approach (Binary Search on Partition):
1. Always perform binary search on the smaller array.
2. Partition the arrays so that the left partitions together contain exactly k elements.
3. Let:
      l1 = last element in left part of arr1
      l2 = last element in left part of arr2
      r1 = first element in right part of arr1
      r2 = first element in right part of arr2
4. If:
      l1 <= r2 && l2 <= r1
   then the correct partition is found.
5. The kth element is the maximum of l1 and l2.
6. If l1 > r2, move the partition in arr1 to the left.
7. Otherwise, move it to the right.

Time Complexity: O(log(min(N, M)))
Space Complexity: O(1)
*/


class Solution {
    public long kthElement(int k, int[] arr1, int[] arr2) {

        if (arr1.length > arr2.length) {
            return kthElement(k, arr2, arr1);
        }

        int n1 = arr1.length;
        int n2 = arr2.length;

        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {
            int cut1 = low + (high - low) / 2;
            int cut2 = k - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];

            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : arr1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : arr2[cut2];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return -1;
    }
}

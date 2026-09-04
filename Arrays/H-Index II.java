// Leetcode 275 - H-Index II
//
// citations is sorted in ascending order.
//
// Approach: Binary Search
//
// At index mid:
// papers = n - mid
//
// If citations[mid] >= papers,
// we may have a valid h-index.
// Move left to find a potentially larger h.
//
// Otherwise, move right.
//
// Time Complexity: O(log N)
// Space Complexity: O(1)

class Solution {

    public int hIndex(int[] citations) {

        int n = citations.length;

        int left = 0;
        int right = n - 1;

        while (left <= right) {

            int mid =
                left + (right - left) / 2;

            int papers = n - mid;

            if (citations[mid] >= papers) {

                // Possible answer
                right = mid - 1;

            } else {

                // Need more citations
                left = mid + 1;
            }
        }

        return n - left;
    }
}

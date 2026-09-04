// Leetcode 274 - H-Index
//
// Approach: Sorting
//
// Sort citations in ascending order.
// For each position, calculate how many papers
// have at least citations[i] citations.
//
// Time Complexity: O(N log N)
// Space Complexity: O(1) excluding sorting

class Solution {

    public int hIndex(int[] citations) {

        Arrays.sort(citations);

        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {

            // Number of papers from i to n-1
            int papers = n - i;

            h = Math.max(
                h,
                Math.min(citations[i], papers)
            );
        }

        return h;
    }
}

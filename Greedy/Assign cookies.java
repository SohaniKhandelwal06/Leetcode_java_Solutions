// Leetcode 455 - Assign Cookies
//
// Approach (Greedy)
//
// - Sort both arrays.
// - Use two pointers.
// - Try to satisfy the least greedy child
//   using the smallest available cookie.
// - If cookie >= greed,
//   child is satisfied.
// - Otherwise, try a larger cookie.
//
// Time Complexity:
// O(N log N + M log M)
//
// Space Complexity:
// O(1)

class Solution {

    public int findContentChildren(
            int[] g,
            int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length &&
               cookie < s.length) {

            if (s[cookie] >= g[child]) {

                child++;
            }

            cookie++;
        }

        return child;
    }
}

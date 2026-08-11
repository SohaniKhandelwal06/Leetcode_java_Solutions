// Leetcode 1237 - Find Positive Integer Solution for a Given Equation
//
// Approach: Two Pointers
//
// Since the function is strictly increasing:
// - If f(x, y) < z, increase x.
// - If f(x, y) > z, decrease y.
// - If f(x, y) == z, store the pair and move both.
//
// Time Complexity: O(1000)
// Space Complexity: O(1) excluding the answer

/*
 * // This is the CustomFunction interface.
 * // You should not implement it, or speculate about its implementation.
 *
 * class CustomFunction {
 *     public int f(int x, int y) {
 *         // Returns f(x, y)
 *     }
 * }
 */

class Solution {

    public List<List<Integer>> findSolution(
            CustomFunction customfunction, int z) {

        List<List<Integer>> ans = new ArrayList<>();

        int x = 1;
        int y = 1000;

        while (x <= 1000 && y >= 1) {

            int value = customfunction.f(x, y);

            if (value == z) {

                ans.add(Arrays.asList(x, y));

                x++;
                y--;

            } else if (value < z) {

                x++;

            } else {

                y--;
            }
        }

        return ans;
    }
}

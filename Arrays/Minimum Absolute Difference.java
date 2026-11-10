//LeetCode 1200 — Minimum Absolute Difference
/*Approach: Sorting
We are given an array of distinct integers. We need to find all pairs having the minimum absolute difference.
1. Sort the array in ascending order.
2. Calculate the difference between every pair of adjacent elements.
3. Maintain a variable minDiff to store the minimum difference.
4. If a smaller difference is found, clear the previous result and add the new pair.
5. If the difference equals minDiff, add that pair to the result.
Why sorting?

After sorting, the minimum absolute difference will always occur between two adjacent elements. Therefore, we don't need to check every possible pair.
import java.util.*;
*/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {

            int diff = arr[i] - arr[i - 1];

            if (diff < minDiff) {
                minDiff = diff;
                result.clear();

                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
            else if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}

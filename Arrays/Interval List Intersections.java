//LeetCode 986 — Interval List Intersections
/*Approach: Two Pointers
We are given two sorted lists of non-overlapping intervals. We need to find all intersections between the intervals of both lists.

Steps:
1. Initialize two pointers i and j at the beginning of both arrays.
2. Calculate the intersection boundaries:
   - Start = maximum of both starting points.
   - End = minimum of both ending points.
3. If start <= end, an intersection exists. Add it to the result.
4. Move the pointer whose interval ends earlier because that interval cannot intersect with any future interval from the other list.
5. Continue until either list is exhausted.
*/
import java.util.*;

class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> result = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < firstList.length && j < secondList.length) {

            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            // Check whether an intersection exists
            if (start <= end) {
                result.add(new int[]{start, end});
            }

            // Move the interval that ends earlier
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}

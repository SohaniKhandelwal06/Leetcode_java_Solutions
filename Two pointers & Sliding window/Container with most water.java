// Leetcode 11 - Container With Most Water
//
// Approach: Two Pointers
//
// Area = min(height[left], height[right])
//        * (right - left)
//
// Move the pointer with the smaller height.
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int width = right - left;

            int h = Math.min(
                height[left],
                height[right]
            );

            int area = h * width;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

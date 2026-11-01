//LeetCode 223 — Rectangle Area
/*Approach: Calculate Total Area and Subtract Overlap
We are given two rectangles aligned with the X and Y axes.

The goal is to calculate the total area covered by both rectangles.
1. Calculate the area of the first rectangle.
2. Calculate the area of the second rectangle.
3. Find the overlapping width and height.
4. If the rectangles overlap, subtract the overlapping area once.
*/

class Solution {
    public int computeArea(
        int ax1, int ay1, int ax2, int ay2,
        int bx1, int by1, int bx2, int by2
    ) {

        // Area of both rectangles
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);

        // Calculate overlapping width and height
        int overlapWidth = Math.max(
            0,
            Math.min(ax2, bx2) - Math.max(ax1, bx1)
        );

        int overlapHeight = Math.max(
            0,
            Math.min(ay2, by2) - Math.max(ay1, by1)
        );

        // Overlapping area
        int overlapArea = overlapWidth * overlapHeight;

        // Total covered area
        return area1 + area2 - overlapArea;
    }
}

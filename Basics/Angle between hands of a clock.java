//Leetcode 1344 - Angle Between Hands of a Clock

// // Approach: Mathematical Calculation //
// Calculate the minute hand angle using minutes * 6.
// Calculate the hour hand angle using hours * 30 + minutes * 0.5. 
// Find the absolute difference between both angles.
// Return the smaller angle between the two hands.
// // Time Complexity: // O(1) // 
// Space Complexity: // O(1)
class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double minuteAngle = minutes * 6;

        double diff = Math.abs(hourAngle - minuteAngle);

        return Math.min(diff, 360 - diff);
    }
}

//Leetcode 605 - Can Place Flowers

//
// Approach: Greedy
//
// Traverse the flowerbed from left to right.
// If the current position is 0 and both its neighbors are also 0
// (or out of bounds), place a flower there and increase the count.
//
// Time Complexity:
// O(N)
//
// Space Complexity: O(1)





class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; i++) {

            // Check if current position is empty
            if (flowerbed[i] == 0) {

                // Check left and right positions
                int left = (i == 0) ? 0 : flowerbed[i - 1];
                int right = (i == flowerbed.length - 1)
                            ? 0
                            : flowerbed[i + 1];

                // Place flower if both sides are empty
                if (left == 0 && right == 0) {

                    flowerbed[i] = 1;
                    n--;

                    if (n == 0) {
                        return true;
                    }
                }
            }
        }

        return n <= 0;
    }
}

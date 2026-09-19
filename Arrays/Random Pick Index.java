//Leetcode 398 - Random Pick Index

//
// Approach: Reservoir Sampling
//
// Traverse the array and keep track of how many times the target appears.
// For each matching index, randomly select it with probability 1/count.
// This ensures every occurrence of the target has an equal chance of being selected.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(1)
class Solution {
    int[] nums;
    Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int result = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;

                if (random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }

        return result;
    }
}

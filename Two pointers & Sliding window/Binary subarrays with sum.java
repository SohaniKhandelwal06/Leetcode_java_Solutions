// Leetcode - 930 - Binary Subarrays With Sum

/*
Approach (Sliding Window)

Observation:
Instead of counting subarrays with exactly goal,
count:

Exactly(goal) =
AtMost(goal) - AtMost(goal - 1)

Function AtMost(goal):

1. Maintain a sliding window.
2. Expand the window by moving right.
3. Keep the sum of the current window.
4. If sum > goal,
   shrink the window from the left.
5. Every valid window ending at 'right'
   contributes:
        right - left + 1
   subarrays.

Answer:
AtMost(goal) - AtMost(goal - 1)

Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal)-atMost(nums,goal-1);
    }
private int atMost(int[]arr,int goal){
    if(goal<0) return 0;
    int l=0;
    int r=0;
    int cnt=0;
    int sum=0;
    while(r<arr.length){
        sum=sum+arr[r];
while(sum>goal){
sum=sum-arr[l];
    
l++;
   }
        cnt=cnt+(r-l+1);
        r++;
    }
    return cnt;
}
}

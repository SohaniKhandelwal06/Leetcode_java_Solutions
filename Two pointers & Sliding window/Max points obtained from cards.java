// Leetcode - 1423 - Maximum Points You Can Obtain from Cards

/*
Approach (Sliding Window):

Observation:
- We can take exactly k cards.
- Cards can only be taken from the beginning or the end.
- Suppose we take x cards from the left.
  Then we must take (k - x) cards from the right.

Algorithm:
1. Compute the sum of the first k cards.
2. Initialize maxSum = leftSum.
3. One by one:
   - Remove one card from the left.
   - Add one card from the right.
   - Update the maximum sum.
4. Return the maximum sum.

Time Complexity: O(k)
Space Complexity: O(1)
*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int left=0;

        for(int i=0;i<=k-1;i++){
            left=left+cardPoints[i];
        }
int max=left;
        int right=0;
int r=cardPoints.length-1;
        for(int i=k-1;i>=0;i--){
            left=left-cardPoints[i];
        
        right=right+cardPoints[r];
r--;
    max=Math.max(max,left+right);
        
    }
return max;
    }
}

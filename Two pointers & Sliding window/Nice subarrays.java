// Leetcode - 1248 - Count Number of Nice Subarrays

/*
Approach (Sliding Window)

Definition:
A nice subarray contains exactly k odd numbers.

Observation:
Instead of counting exactly k,
count:

Exactly(k) =
AtMost(k) - AtMost(k-1)

Function AtMost(k):

1. Maintain a sliding window.
2. Count odd numbers inside the window.
3. Expand the window.
4. If oddCount > k,
   shrink the window.
5. Every valid window ending at right
   contributes:
       right - left + 1
   subarrays.

Answer:
AtMost(k) - AtMost(k-1)

Time Complexity: O(N)
Space Complexity: O(1)
*/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);      
    }
    private int atMost(int[]arr,int k){
if(k<0) return 0;
        int l=0;
        int r=0;
        int cnt=0;
        int ans=0;
        while(r<arr.length){
            if(arr[r]%2==1){
cnt++;
                
        }
            while(cnt>k){
if(arr[l]%2==1){
cnt--;
}
                l++;
            }
            ans=ans+r-l+1;
        r++;
        }
        return ans;
    }
}

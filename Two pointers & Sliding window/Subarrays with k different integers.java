// Leetcode - 992 - Subarrays with K Different Integers

/*
Approach (Sliding Window + HashMap)

Observation:
It is difficult to count subarrays with exactly k
distinct integers directly.

Instead,

Exactly(k) =
AtMost(k) - AtMost(k-1)

Function AtMost(k):
-------------------
1. Maintain a sliding window.
2. Store frequencies using a HashMap.
3. Expand the window.
4. If distinct elements exceed k,
   shrink the window.
5. Every valid window ending at 'right'
   contributes:
       right - left + 1
   subarrays.

Finally,

Answer =
AtMost(k) - AtMost(k-1)

Time Complexity: O(N)
Space Complexity: O(K)
*/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k)-func(nums,k-1);
        
    }
private int func(int[]arr,int k){
HashMap<Integer,Integer>map=new HashMap<>();
    int l=0;
    int r=0;
    int cnt=0;
    while(r<arr.length){
        map.put(arr[r],map.getOrDefault(arr[r],0)+1);
while(map.size()>k){
map.put(arr[l],map.get(arr[l])-1);
if(map.get(arr[l])==0){
map.remove(arr[l]);
}
l++;
}
        cnt=cnt+r-l+1;
        r++;
    }
    return cnt;
}
}
    

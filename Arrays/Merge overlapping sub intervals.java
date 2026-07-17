// Leetcode - 56 - Merge Intervals

/*
Approach:
1. Sort all intervals based on their starting time.
2. Traverse the sorted intervals one by one.
3. If:
   - The answer list is empty, or
   - The current interval does not overlap with the last merged interval,
   add the current interval to the answer.
4. Otherwise, merge the intervals by updating the end time:
      end = max(previousEnd, currentEnd)
5. Convert the list into a 2D array and return it.

Overlap Condition:
Current Start <= Previous End

Time Complexity:
Sorting: O(N log N)
Traversal: O(N)

Overall: O(N log N)

Space Complexity:
O(N)
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]>ans=new ArrayList<>();
        for(int[] interval:intervals){
if(ans.isEmpty()||ans.get(ans.size()-1)[1]<interval[0]){
    ans.add(interval);
}
else{
    ans.get(ans.size() - 1)[1] =Math.max(ans.get(ans.size() - 1)[1], interval[1]);
}
        }
            
        

        return ans.toArray(new int[ans.size()][]);
    }
}

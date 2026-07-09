// Leetcode - 39 - Combination Sum

/*
Approach (Recursion + Backtracking):
1. Start from the first candidate.
2. For each candidate, make two recursive choices:
   - Include the current candidate if it does not exceed the target.
     Since a candidate can be used unlimited times, stay at the same index.
   - Exclude the current candidate and move to the next index.
3. If the target becomes 0, add the current combination to the answer.
4. If all candidates are processed, return.
5. Backtrack after each inclusion to explore all possible combinations.

Time Complexity: O(2^Target) (Approximate)
Space Complexity: O(Target) (Recursion Stack)
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans=new ArrayList<>();
List<Integer>ds=new ArrayList<>();
        solve(0,target,candidates,ans,ds);
        return ans;
    }
    private void solve(int idx,int target,int[]arr,List<List<Integer>>ans,List<Integer>ds){
int n=arr.length;
if(idx==n){
if(target==0){
    ans.add(new ArrayList<>(ds));
}
return;
}
    if(arr[idx]<=target){
ds.add(arr[idx]);
solve(idx,target-arr[idx],arr,ans,ds);
ds.remove(ds.size()-1);
    }
        solve(idx+1,target,arr,ans,ds);
    }
}


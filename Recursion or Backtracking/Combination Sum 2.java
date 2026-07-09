// Leetcode - 40 - Combination Sum II

/*
Approach (Recursion + Backtracking):
1. Sort the array to group duplicate elements together.
2. Start from the given index and try each candidate once.
3. Skip duplicate elements at the same recursion level to avoid duplicate combinations.
4. If the current element exceeds the remaining target, stop exploring further.
5. Include the current element and recursively solve for the remaining target using the next index.
6. Backtrack after each recursive call to explore other combinations.
7. When the target becomes 0, add the current combination to the answer.

Time Complexity: O(2^N)
Space Complexity: O(N) (Recursion Stack)
*/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
List<Integer>ds=new ArrayList<>();
List<List<Integer>>ans=new ArrayList<>();
    solve(0,target,candidates, ds,ans);
        return ans;
}
    private void solve(int idx,int target,int[]arr,List<Integer>ds,List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(ds));
return;
        }
        for(int i=idx;i<arr.length;i++){
            if(i>idx && arr[i]==arr[i-1]){
continue;
            }
            if(arr[i]>target){
break;
            }
            ds.add(arr[i]);
solve(i+1,target-arr[i],arr,ds,ans);
ds.remove(ds.size()-1);
        }
        }
    }


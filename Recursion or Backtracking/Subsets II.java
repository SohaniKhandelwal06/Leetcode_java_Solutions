// Leetcode - 90 - Subsets II

/*
Approach (Recursion + Backtracking):
1. Sort the array so that duplicate elements are adjacent.
2. Add the current subset to the answer at every recursive call.
3. Iterate through the remaining elements starting from the current index.
4. Skip duplicate elements at the same recursion level to avoid duplicate subsets.
5. Include the current element and recursively generate further subsets.
6. Backtrack by removing the last added element to explore other possibilities.

Time Complexity: O(2^N)
Space Complexity: O(N) (Recursion Stack)
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>ds=new ArrayList<>();
        solve(0,nums,ans,ds);
return ans;
        
    }
    private void solve(int idx,int[]arr,List<List<Integer>>ans,List<Integer>ds){
ans.add(new ArrayList<>(ds));
for(int i=idx;i<arr.length;i++){
    if(i>idx && arr[i]==arr[i-1]){
continue;
    }
    ds.add(arr[i]);
solve(i+1,arr,ans,ds);
ds.remove(ds.size()-1);
    
}

}
}

// Leetcode - 46 - Permutations

/*
Approach (Recursion + Backtracking using Swapping):
1. Fix one position in the permutation at a time.
2. Swap the current index with every possible index from the current position to the end.
3. Recursively generate permutations for the remaining positions.
4. When all positions are fixed, store the current permutation in the answer.
5. Backtrack by swapping the elements again to restore the original array before exploring the next possibility.

Time Complexity: O(N × N!)
Space Complexity: O(N) (Recursion Stack)
*/







class Solution {
private void swap(int[]arr,int a,int b){
int temp=arr[a];
arr[a]=arr[b];
arr[b]=temp;
}
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans=new ArrayList<>();
    recurePermute(0,nums,ans);
return ans;
    }
private void recurePermute(int idx,int[]arr,List<List<Integer>>ans){
    if(idx==arr.length){
        ArrayList<Integer>ds=new ArrayList<>();
for(int num:arr){
ds.add(num);
}
ans.add(new ArrayList<>(ds));

return;
    }
    for(int i=idx;i<arr.length;i++){
        swap(arr,idx,i);
recurePermute(idx+1,arr,ans);
swap(arr,idx,i);
    }
    
}
}

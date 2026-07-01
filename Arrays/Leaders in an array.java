// GFG - Leaders in an Array

/*
Approach:
- Traverse the array from right to left.
- Keep track of the maximum element seen so far.
- If the current element is greater than or equal to the maximum,
  add it to the answer.
- Reverse the answer before returning.

Time Complexity: O(N)
Space Complexity: O(N)
*/
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
    int maxi=Integer.MIN_VALUE;
    ArrayList<Integer>ans=new ArrayList<>();
    for(int i=arr.length-1;i>=0;i--){
        if(arr[i]>=maxi){
            ans.add(arr[i]);
        
        maxi=arr[i];
    }
    }
    Collections.reverse(ans);
    return ans;
        
    }
}

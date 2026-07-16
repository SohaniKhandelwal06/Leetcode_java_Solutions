// Leetcode - 907 - Sum of Subarray Minimums

/*
Approach (Monotonic Stack):
1. For every element, find:
   - Previous Smaller Element (PSE)
   - Next Smaller Element (NSE)
2. Compute:
   - Left = i - PSE[i]
   - Right = NSE[i] - i
3. The current element is the minimum in
   Left × Right subarrays.
4. Add its contribution:
      arr[i] * Left * Right
5. Take modulo 1e9+7 after every addition.

Note:
- For Previous Smaller, use '>'.
- For Next Smaller, use '>='.
This avoids double counting when duplicate elements exist.

Time Complexity: O(N)
Space Complexity: O(N)
  */
  class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse=findnse(arr);
int[] pse=findpse(arr);
long total=0;
        long mod=1000000007;
        for(int i=0;i<arr.length;i++){
            int left=i-pse[i];
int right=nse[i]-i;
            total=(total+(left*right %mod)*arr[i]) %mod;
            
        }
        return (int)total;
        
    }
    private int[]findpse(int[] arr){
Stack<Integer>st=new Stack<>();
        int[]ans=new int[arr.length];
for(int i=0;i<arr.length;i++){
        while(!st.isEmpty() && arr[st.peek()]>arr[i]){
st.pop();
        }
        ans[i]=st.isEmpty()?-1:st.peek();
    st.push(i);
        
}
return ans;
    }
    private int[]findnse(int[] arr){
Stack<Integer>st=new Stack<>();
        int[]ans=new int[arr.length];
for(int i=arr.length-1;i>=0;i--){
        while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
st.pop();
        }
        ans[i]=st.isEmpty()?arr.length:st.peek();
    st.push(i);
        
}
return ans;
    }
}
    

  

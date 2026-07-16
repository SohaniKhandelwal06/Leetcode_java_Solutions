// Leetcode - 496 - Next Greater Element I

/*
Approach (Monotonic Decreasing Stack):
1. Traverse nums2 from right to left.
2. Remove all elements from the stack that are smaller than or equal
   to the current element.
3. The top of the stack (if any) is the next greater element.
4. Store the mapping (current element -> next greater element)
   in a HashMap.
5. Push the current element onto the stack.
6. Traverse nums1 and use the HashMap to build the answer.

Time Complexity: O(N + M)
Space Complexity: O(N)
*/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>map=new HashMap<>();
        Stack<Integer>st=new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
st.pop();
            }
                if(st.isEmpty()){
                    map.put(nums2[i],-1);

                }
else{
    map.put(nums2[i],st.peek());
}
            st.push(nums2[i]);
        }
            int[]ans=new int[nums1.length];
for(int i=0;i<nums1.length;i++){
    ans[i]=map.get(nums1[i]);
}
return ans;
}
        }
        
    

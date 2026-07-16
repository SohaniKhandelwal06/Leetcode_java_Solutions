// Leetcode - 735 - Asteroid Collision

/*
Approach (Stack):
1. Traverse each asteroid one by one.
2. If the asteroid is moving right (positive), push it onto the stack.
3. If it is moving left (negative):
   - Remove all smaller positive asteroids from the stack.
   - If the top positive asteroid has the same size,
     both asteroids are destroyed.
   - If the stack becomes empty or the top is negative,
     push the current negative asteroid.
4. After processing all asteroids, the stack contains the
   final state of the asteroids.
5. Copy the stack elements into the answer array.

Collision Cases:
- Positive < |Negative|  -> Positive asteroid explodes.
- Positive == |Negative| -> Both explode.
- Positive > |Negative|  -> Negative asteroid explodes.

Time Complexity: O(N)
Space Complexity: O(N)
  */








class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer>st=new Stack<>();
        for(int it:asteroids){
if(it>0){
    st.push(it);
}
else{
    while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(it)){
st.pop();
    }
        if(!st.isEmpty()&&st.peek()==Math.abs(it)){
st.pop();
        }
        else if(st.isEmpty() || st.peek()<0){
            st.push(it);
        }
}
        }
int[]ans=new int[st.size()];
            for(int i=st.size()-1;i>=0;i--){
                ans[i]=st.pop();
            }
            return ans;
        
    }
}

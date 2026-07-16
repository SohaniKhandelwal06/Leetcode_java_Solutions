// Leetcode - 402 - Remove K Digits

/*
Approach (Monotonic Increasing Stack):
1. Traverse each digit of the number.
2. While:
   - the stack is not empty,
   - k > 0,
   - and the top digit is greater than the current digit,
   pop the stack and decrement k.
3. Push the current digit onto the stack.
4. If k is still greater than 0 after traversal,
   remove the remaining digits from the top of the stack.
5. Build the answer by popping all digits from the stack
   and reversing the result.
6. Remove leading zeros.
7. If the resulting string is empty, return "0".

Time Complexity: O(N)
Space Complexity: O(N)
  */

  class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character>st=new Stack<>();
        for(char ch:num.toCharArray()){
            while(!st.isEmpty() &&k>0 && st.peek()>ch){
st.pop();
                k--;
                
        }
            st.push(ch);
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
            
        }
            StringBuilder ans=new StringBuilder();
            while(!st.isEmpty()){
                ans.append(st.pop());
            }
ans.reverse();
            while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        

        return ans.length() == 0 ? "0" : ans.toString();
    
}
    }

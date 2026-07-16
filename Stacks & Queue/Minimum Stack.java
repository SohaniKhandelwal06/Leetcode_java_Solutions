
// Leetcode - 155 - Min Stack (Single Stack + Encoding)

/*
Approach (Single Stack with Encoding):
1. Maintain a single stack and a variable 'min' to store the current minimum.
2. Push:
   - If the stack is empty, push the element and update min.
   - If the new element is greater than or equal to min, push it normally.
   - Otherwise:
       - Push the encoded value: 2 * val - min.
       - Update min = val.
3. Pop:
   - If the top is greater than or equal to min, pop normally.
   - Otherwise, the top is an encoded value:
       - Restore the previous minimum using:
         previousMin = 2 * min - encodedValue.
4. Top:
   - If the top is encoded (top < min), the actual top element is the current min.
   - Otherwise, return the top value.
5. getMin:
   - Return the current minimum.

Why Encoding Works:
- Whenever a new minimum is inserted, the encoded value
  (2 * val - previousMin) is always smaller than the new minimum.
- This helps identify encoded values during pop and restore the previous minimum.

Time Complexity:
Push: O(1)
Pop: O(1)
Top: O(1)
getMin: O(1)

Space Complexity:
O(1) extra space
*/
class MinStack {
    Stack<Long>st;
long mini;

    public MinStack() {
st=new Stack<>();
        
        
    }
    
    public void push(int value) {
        if(st.isEmpty()){
st.push((long)value);
            mini=value;
        
    }
        else if(value>=mini){
st.push((long)value);
        }
        else{
            st.push(2*(long)value-mini);
mini=value;
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        long top=st.pop();
        if(top<mini){
mini=2*mini-top;
        
    }
    }
    
    public int top() {
        long top=st.peek();
        if(top<mini){
return (int)mini;
        
    }
        return (int)top;
    }
    
    public int getMin() {
        return (int)mini;
        
    }
}


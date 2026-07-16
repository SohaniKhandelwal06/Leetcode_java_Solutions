// Leetcode - 232 - Implement Queue using Stacks

/*
Approach (Using Two Stacks):
1. Maintain two stacks:
   - input: stores newly added elements.
   - output: stores elements in queue order.
2. Push:
   - Push the element into the input stack.
3. Pop:
   - If output is empty, transfer all elements from input to output.
   - Pop the top element from output.
4. Peek:
   - If output is empty, transfer all elements from input to output.
   - Return the top element of output.
5. Empty:
   - Return true if both stacks are empty.

Time Complexity:
Push: O(1)
Pop: Amortized O(1)
Peek: Amortized O(1)
Empty: O(1)

Space Complexity: O(N)
*/
class MyQueue {
    Stack<Integer>input;
    Stack<Integer>output;

    public MyQueue() {
        input=new Stack<>();
        output=new Stack<>();
        
    }
    
    public void push(int x) {
        input.push(x);
        
    }
    
    public int pop() {
if(output.isEmpty()){
    while(!input.isEmpty()){
        output.push(input.pop());
    }
}
        return output.pop();
        
    }
    
    public int peek() {
if(output.isEmpty()){
    while(!input.isEmpty()){
        output.push(input.pop());
    }
}
        return output.peek();

        
    }
    
    public boolean empty() {
return input.isEmpty() && output.isEmpty();
        
    }
}

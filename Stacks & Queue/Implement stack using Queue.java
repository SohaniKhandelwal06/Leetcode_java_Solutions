// Leetcode - 225 - Implement Stack using Queues

/*
Approach (Using One Queue):
1. Use a single queue to simulate stack operations.
2. Push:
   - Insert the new element into the queue.
   - Rotate the existing elements to the back so that
     the newly inserted element comes to the front.
3. Pop:
   - Remove and return the front element of the queue.
4. Top:
   - Return the front element.
5. Empty:
   - Check if the queue is empty.

Time Complexity:
Push: O(N)
Pop: O(1)
Top: O(1)
Empty: O(1)

Space Complexity: O(N)
*/
class MyStack {
    Queue<Integer>q;

    public MyStack() {
        q=new LinkedList<>();
        
    }
    
    public void push(int x) {
        q.offer(x);
for(int i=0;i<q.size()-1;i++){
    q.offer(q.poll());
}
        
    }
    
    public int pop() {
return q.poll();
        
    }
    
    public int top() {
        return q.peek();
        
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

// Implement Stack Using Array

/*
Approach:
1. Use an array to store stack elements.
2. Maintain a variable 'top' to keep track of the topmost element.
3. Push:
   - Increment top and insert the element.
4. Pop:
   - Return the top element and decrement top.
5. Top:
   - Return the current top element.
6. Size:
   - Return top + 1.
7. isEmpty:
   - Check if top == -1.

Time Complexity:
Push: O(1)
Pop: O(1)
Top: O(1)
Size: O(1)
isEmpty: O(1)

Space Complexity: O(N)
*/

class MyStack {
    int[] arr;
    int top;
    int size;

    MyStack(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
    }

    int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return arr[top--];
    }

    int top() {
        if (top == -1) return -1;
        return arr[top];
    }

    int size() {
        return top + 1;
    }

    boolean isEmpty() {
        return top == -1;
    }
}

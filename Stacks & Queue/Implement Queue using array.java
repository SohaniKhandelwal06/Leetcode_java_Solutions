// Implement Queue Using Array

/*
Approach:
1. Use an array to store queue elements.
2. Maintain two pointers:
   - front: points to the first element.
   - rear: points to the last element.
3. Push:
   - Increment rear and insert the element.
4. Pop:
   - Return the front element and increment front.
5. Front:
   - Return the front element without removing it.
6. Size:
   - Return rear - front + 1.
7. isEmpty:
   - Check if front > rear.

Time Complexity:
Push: O(1)
Pop: O(1)
Front: O(1)
Size: O(1)
isEmpty: O(1)

Space Complexity: O(N)
*/

class MyQueue {
    int[] arr;
    int front;
    int rear;
    int size;

    MyQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
    }

    void push(int x) {
        if (rear == size - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        arr[++rear] = x;
    }

    int pop() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return -1;
        }
        return arr[front++];
    }

    int front() {
        if (front > rear) {
            return -1;
        }
        return arr[front];
    }

    int size() {
        return rear - front + 1;
    }

    boolean isEmpty() {
        return front > rear;
    }
}

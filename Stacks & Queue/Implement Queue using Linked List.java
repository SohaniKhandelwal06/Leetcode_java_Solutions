// Implement Queue Using Linked List

/*
Approach:
1. Use a singly linked list to implement the queue.
2. Maintain two pointers:
   - front: points to the first node.
   - rear: points to the last node.
3. Push:
   - Create a new node.
   - If the queue is empty, both front and rear point to it.
   - Otherwise, attach the new node after rear and update rear.
4. Pop:
   - Remove the front node.
   - If the queue becomes empty, set rear to null.
5. Front:
   - Return the data at the front node.
6. Size:
   - Maintain a counter for the number of elements.
7. isEmpty:
   - Check if front is null.

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

// Leetcode 295 - Find Median from Data Stream
//
// Approach: Two Heaps
//
// maxHeap -> smaller half
// minHeap -> larger half
//
// Keep maxHeap size equal to minHeap size,
// or one larger.
//
// Time Complexity:
// addNum() -> O(log N)
// findMedian() -> O(1)
//
// Space Complexity: O(N)

class MedianFinder {

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public MedianFinder() {

        // Smaller half
        maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        // Larger half
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Add to smaller half first
        maxHeap.offer(num);

        // Largest of smaller half
        // should not be greater than
        // smallest of larger half
        if (!minHeap.isEmpty() &&
            maxHeap.peek() > minHeap.peek()) {

            minHeap.offer(maxHeap.poll());
        }

        // Balance the heaps
        if (maxHeap.size() >
            minHeap.size() + 1) {

            minHeap.offer(maxHeap.poll());
        }

        if (minHeap.size() >
            maxHeap.size()) {

            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if (maxHeap.size() >
            minHeap.size()) {

            return maxHeap.peek();
        }

        return (
            maxHeap.peek() +
            minHeap.peek()
        ) / 2.0;
    }
}

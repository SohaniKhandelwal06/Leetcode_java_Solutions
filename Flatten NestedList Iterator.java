//Leetcode 341 - Flatten Nested List Iterator
//
// Approach: Stack
//
// Store the nested list elements in a stack in reverse order.
// In hasNext(), expand nested lists until the top element is an integer.
// In next(), return the integer at the top and remove it.
// This ensures elements are returned in the original order.
//
// Time Complexity:
// O(1) amortized per operation
//
// Space Complexity:
// O(N)
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        pushReverse(nestedList);
    }

    private void pushReverse(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }

    @Override
    public Integer next() {
        hasNext();
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();

            if (top.isInteger()) {
                return true;
            }

            stack.pop();
            pushReverse(top.getList());
        }

        return false;
    }
}

// Leetcode 173 - Binary Search Tree Iterator

/*
Approach (Iterative Inorder Traversal)

- Inorder traversal of a BST gives values in sorted order.
- Initially, push all the left nodes into the stack.
- The top of the stack is the next smallest element.
- After removing a node:
    - If it has a right subtree,
      push all the left nodes of that subtree.

Time Complexity:
- next(): O(1) amortized
- hasNext(): O(1)

Space Complexity: O(H)

where:
H = Height of the BST
*/
class BSTIterator {
    private Stack<TreeNode>st=new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
        
    }
private void pushAll(TreeNode root){
while(root!=null){
st.push(root);
root=root.left;
}
}
    
    public int next() {
        TreeNode curr=st.pop();
        pushAll(curr.right);
        return curr.val;
        
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
        
        
    }
}

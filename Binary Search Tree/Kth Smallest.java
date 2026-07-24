// Leetcode 230 - Kth Smallest Element in a BST

/*
Approach (Iterative Inorder Traversal)

- Inorder traversal of a BST produces values in sorted order.
- Use a stack to perform inorder traversal iteratively.
- Decrease k whenever a node is visited.
- When k becomes 0, the current node is the kth smallest element.

Time Complexity: O(H + K)

Space Complexity: O(H)

where:
H = Height of the BST
K = Given position
*/




class Solution {

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;

        while (true) {

            // Go as far left as possible
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }

            // Visit node
            curr = st.pop();

            k--;

            if (k == 0) {
                return curr.val;
            }

            // Move to right subtree
            curr = curr.right;
        }
    }
}

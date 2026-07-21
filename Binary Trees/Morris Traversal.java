// Morris Inorder Traversal

/*
Traversal Order:
Left -> Root -> Right

Approach:

Morris Traversal performs inorder traversal without
using recursion or an explicit stack.

It uses the rightmost node of the left subtree
(inorder predecessor) to create a temporary link
back to the current node.

Steps:

1. If curr.left is null:
   - Visit curr.
   - Move to curr.right.

2. Otherwise:
   - Find the inorder predecessor of curr.
   - If predecessor.right is null:
       Create a temporary thread to curr.
       Move curr to curr.left.
   - Otherwise:
       Remove the temporary thread.
       Visit curr.
       Move curr to curr.right.

The temporary links are removed after use,
so the original tree is restored.

Time Complexity: O(N)

Space Complexity: O(1)

*/

class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        TreeNode curr = root;

        while (curr != null) {

            // If there is no left subtree
            if (curr.left == null) {

                ans.add(curr.val);
                curr = curr.right;
            }

            else {

                // Find inorder predecessor
                TreeNode prev = curr.left;

                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                // Create a thread
                if (prev.right == null) {

                    prev.right = curr;
                    curr = curr.left;
                }

                // Remove the thread
                else {

                    prev.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}

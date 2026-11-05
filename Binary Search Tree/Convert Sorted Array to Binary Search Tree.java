//LeetCode 108 — Convert Sorted Array to Binary Search Tree
/*Approach: Recursion + Binary Search
We are given a sorted array and need to convert it into a height-balanced Binary Search Tree (BST).

A height-balanced BST ensures that the heights of the left and right subtrees of every node differ by no more than one.

Steps:
1. Find the middle element of the current array range.
2. Create a tree node using that element.
3. Recursively construct the left subtree using the left half.
4. Recursively construct the right subtree using the right half.
5. Return the middle node as the root.
Choosing the middle element ensures that the tree remains balanced.
*/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums,0,nums.length-1);
    }
    private TreeNode buildTree(int[]nums,int left,int right){
        if(left>right)return null;
        int mid=left+(right-left)/2;
        TreeNode  root= new TreeNode(nums[mid]);
        root.left=buildTree(nums,left,mid-1);
        root.right=buildTree(nums,mid+1,right);
        return root;
    }
}

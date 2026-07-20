// Leetcode 102 - Binary Tree Level Order Traversal

/*
Approach (Breadth First Search - BFS)

1. If the tree is empty, return an empty list.
2. Create a queue and insert the root node.
3. While the queue is not empty:
   - Store the current queue size (number of nodes at this level).
   - Traverse exactly 'size' nodes.
   - Remove each node from the queue.
   - Add its value to the current level list.
   - Insert its left child (if present).
   - Insert its right child (if present).
4. Add the current level list to the answer.
5. Return the final answer.

Why store queue size?
Because it tells us how many nodes belong to the current level.

Time Complexity: O(N)
Space Complexity: O(N)

where:
N = Number of nodes
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>>ans=new ArrayList<>();
    if(root==null) return ans;
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
while(!q.isEmpty()){
    int size=q.size();
    List<Integer>level=new ArrayList<>();
    for(int i=0;i<size;i++){
        TreeNode curr=q.poll();
        level.add(curr.val);
if(curr.left!=null){
q.offer(curr.left);
    }
        if(curr.right!=null){
q.offer(curr.right);
        }
    }
ans.add(level);
        
    
}
return ans;
        
        
    }
}

// Leetcode 103 - Binary Tree Zigzag Level Order Traversal

/*
Approach (BFS + Level Order Traversal)

- Use a queue to traverse the tree level by level.
- Maintain a boolean variable to track the direction.
- If the direction is left to right, store the level normally.
- If the direction is right to left, reverse the current level.
- Toggle the direction after processing every level.

Time Complexity: O(N)

Space Complexity: O(N)

where:
N = Number of nodes
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>ans=new ArrayList<>();
        Queue<TreeNode>q=new LinkedList<>();
        if(root==null) return ans;
        q.add(root);
        int flag=0;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                temp.add(node.val);
            
if(node.left!=null) q.add(node.left);
if(node.right!=null)q.add(node.right);
            }
if(flag==1){
    Collections.reverse(temp);
ans.add(temp);
flag=0;
}
    else{
    ans.add(temp);
flag=1;
}
            }
            return ans;
    }
}

            
        
        
    

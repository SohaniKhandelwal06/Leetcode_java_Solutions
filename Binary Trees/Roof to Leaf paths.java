// Leetcode 257 - Binary Tree Paths

/*
Approach:
- Use DFS to traverse the tree.
- Maintain the current path using StringBuilder.
- Add the current node's value to the path.
- When a leaf node is reached, add the complete path to the answer.
- After exploring the node, backtrack by restoring the StringBuilder
  to its previous length.

Time Complexity: O(N)
Space Complexity: O(H)

where:
N = Number of nodes
H = Height of the tree
*/

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>ans=new ArrayList<>();
        StringBuilder path=new StringBuilder();
        solve(root,path,ans);
        return ans;
    }
private void solve(TreeNode root,StringBuilder path,List<String>ans){
int len=path.length();
    if(root==null) return;
    if(path.length()>0){
        path.append("->");
    }
    path.append(root.val);
if(root.left==null && root.right==null){
ans.add(path.toString());
}
else{
    solve(root.left,path,ans);
solve(root.right,path,ans);
}
  path.setLength(len);
}
}

    
        
    

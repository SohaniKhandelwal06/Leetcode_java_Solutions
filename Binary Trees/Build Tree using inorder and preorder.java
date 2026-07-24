// Leetcode 105 - Construct Binary Tree from Preorder and Inorder Traversal

/*
Approach (Recursion + HashMap)

- The first element in preorder is always the root.
- Find this root in inorder.
- Elements to the left of the root in inorder belong
  to the left subtree.
- Elements to the right of the root belong to the right subtree.
- Recursively construct both subtrees.

To find the root position in inorder efficiently,
store each value and its index in a HashMap.

Time Complexity: O(N)

Space Complexity: O(N)

where:
N = Number of nodes
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
TreeNode root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
return root;
    }

private TreeNode buildTree(int[]preorder,int ps,int pe,int[]inorder,int is,int ie,HashMap<Integer, Integer>map){
if(ps>pe || is>ie) return null;
    TreeNode root=new TreeNode(preorder[ps]);
int inroot=map.get(root.val);
    int numsleft=inroot-is;
    root.left=buildTree(preorder,ps+1,ps+numsleft,inorder,is,inroot-1,map);
root.right=buildTree(preorder,ps+numsleft+1,pe,inorder,inroot+1,ie,map);
return root;
}
}


        
    

// Leetcode 297 - Serialize and Deserialize Binary Tree

/*
Approach (Preorder Traversal)

Serialize:
- Traverse the tree using preorder traversal.
- Store every node value.
- Store "N" for null nodes.

Deserialize:
- Read the serialized values in the same preorder order.
- If the value is "N", return null.
- Otherwise create a node and recursively construct
  its left and right subtrees.

The null markers are necessary to preserve the exact
structure of the tree.

Time Complexity:
- Serialize: O(N)
- Deserialize: O(N)

Space Complexity: O(N)

where:
N = Number of nodes
*/

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode>q=new LinkedList<>();
        StringBuilder ans=new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
    if(curr==null) {
        ans.append("# ");
        continue;
    }
            ans.append(curr.val+" ");
q.add(curr.left);
q.add(curr.right);
        }
return ans.toString();
    }


        
            
            
        

        
        
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<TreeNode>q=new LinkedList<>();
        String[]values=data.split(" ");
    TreeNode root=new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
int i=1;
        while(!q.isEmpty()){
    TreeNode curr=q.poll();
    if(!values[i].equals("#")){
TreeNode left=new TreeNode(Integer.parseInt(values[i]));
curr.left=left;
        q.add(left);
    }
i++;
        if(!values[i].equals("#")){
            TreeNode right=new TreeNode(Integer.parseInt(values[i]));
curr.right=right;
            q.add(right);
        }
    i++;
}
return root;
}
        
    }


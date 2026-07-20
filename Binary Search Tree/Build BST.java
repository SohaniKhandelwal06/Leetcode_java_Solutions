// Build a Binary Search Tree (BST)

/*
Approach (Recursive Insertion)

1. If the current node is null,
   create a new node and return it.
2. If key < root.data,
   insert into the left subtree.
3. If key > root.data,
   insert into the right subtree.
4. Return the current root.

BST Property:
- Left subtree contains smaller values.
- Right subtree contains larger values.

Time Complexity:
- Average: O(log N)
- Worst: O(N) (skewed BST)

Space Complexity:
- Average: O(log N)
- Worst: O(N)

where:
N = Number of nodes
*/

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BST {

    Node root;

    // Insert a node into BST
    Node insert(Node root, int key) {

        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }

    // Inorder Traversal
    void inorder(Node root) {

        if (root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

//Leetcode 208 - Implement Trie (Prefix Tree)

//
// Approach: Trie
//
// Each TrieNode contains an array of 26 children and a boolean
// isEnd to mark the end of a complete word.
//
// insert() -> Add characters one by one
// search() -> Traverse the Trie and check isEnd
// startsWith() -> Traverse the Trie and check if prefix exists
//
// Time Complexity:
// insert() -> O(L)
// search() -> O(L)
// startsWith() -> O(L)
//
// Space Complexity: O(N × L)
class Trie {

    class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {

        TrieNode curr = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                return false;
            }

            curr = curr.children[index];
        }

        return true;
    }
}

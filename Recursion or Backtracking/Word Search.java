//Leetcode 79 - Word Search

//
// Approach: Backtracking + DFS
//
// Start DFS from every cell matching the first character.
// Mark the current cell as visited, explore all 4 directions,
// and backtrack by restoring the cell after the search.
//
// Time Complexity:
// O(M × N × 4^L)
//
// Space Complexity: O(L)
  class Solution {

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == word.charAt(0) &&
                    dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word,
                        int i, int j, int index) {

        // Word found
        if (index == word.length()) {
            return true;
        }

        // Out of bounds or character mismatch
        if (i < 0 || i >= board.length ||
            j < 0 || j >= board[0].length ||
            board[i][j] != word.charAt(index)) {
            return false;
        }

        // Mark as visited
        char temp = board[i][j];
        board[i][j] = '#';

        // Explore 4 directions
        boolean found =
            dfs(board, word, i + 1, j, index + 1) ||
            dfs(board, word, i - 1, j, index + 1) ||
            dfs(board, word, i, j + 1, index + 1) ||
            dfs(board, word, i, j - 1, index + 1);

        // Backtrack
        board[i][j] = temp;

        return found;
    }
}

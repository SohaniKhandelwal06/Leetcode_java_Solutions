// Leetcode 36 - Valid Sudoku
//
// Approach: HashSet
//
// Time Complexity: O(81) = O(1)
// Space Complexity: O(81) = O(1)

class Solution {

    public boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char ch = board[i][j];

                if (ch == '.') {
                    continue;
                }

                // Row
                String row = ch + " in row " + i;

                // Column
                String col = ch + " in col " + j;

                // 3 x 3 box
                int box = (i / 3) * 3 + (j / 3);

                String block =
                    ch + " in block " + box;

                if (!set.add(row) ||
                    !set.add(col) ||
                    !set.add(block)) {

                    return false;
                }
            }
        }

        return true;
    }
}

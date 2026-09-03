// Leetcode 909 - Snakes and Ladders
//
// Approach: BFS
//
// Each dice roll is one move.
// BFS guarantees the minimum number of moves.
//
// Time Complexity: O(N^2)
// Space Complexity: O(N^2)

class Solution {

    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        Queue<Integer> q =
            new LinkedList<>();

        boolean[] visited =
            new boolean[n * n + 1];

        q.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int x = 0; x < size; x++) {

                int curr = q.poll();

                if (curr == n * n) {
                    return moves;
                }

                for (int dice = 1;
                     dice <= 6;
                     dice++) {

                    int next = curr + dice;

                    if (next > n * n) {
                        break;
                    }

                    int[] pos =
                        getPosition(next, n);

                    int row = pos[0];
                    int col = pos[1];

                    // Snake or ladder
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {

                        visited[next] = true;
                        q.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] getPosition(
            int square,
            int n) {

        int row =
            n - 1 - (square - 1) / n;

        int col =
            (square - 1) % n;

        // Every alternate row is reversed
        if (((n - row) % 2) == 0) {
            col = n - 1 - col;
        }

        return new int[]{row, col};
    }
}

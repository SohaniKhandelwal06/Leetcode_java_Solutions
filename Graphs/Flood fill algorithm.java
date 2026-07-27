// Leetcode 733 - Flood Fill

/*
Approach (BFS)

- Store the original color of the starting pixel.
- If the original color is already equal to the new color,
  return the image directly.
- Start BFS from the source pixel.
- Change its color to the new color.
- Visit its four neighbours:
      Up
      Down
      Left
      Right
- If a neighbour has the same original color,
  change its color and add it to the queue.

The image itself is used to mark visited cells.

Time Complexity: O(M * N)

Space Complexity: O(M * N)

where:
M = Number of rows
N = Number of columns
*/

class Pair {

    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int color) {

        int originalColor = image[sr][sc];

        // If both colors are same,
        // avoid infinite processing
        if (originalColor == color) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(sr, sc));

        // Mark starting cell
        image[sr][sc] = color;

        while (!q.isEmpty()) {

            Pair temp = q.poll();

            int row = temp.first;
            int col = temp.second;

            for (int delrow = -1;
                 delrow <= 1;
                 delrow++) {

                for (int delcol = -1;
                     delcol <= 1;
                     delcol++) {

                    // Ignore diagonal directions
                    // and the current cell
                    if (Math.abs(delrow) ==
                        Math.abs(delcol)) {

                        continue;
                    }

                    int nrow = row + delrow;
                    int ncol = col + delcol;

                    if (nrow >= 0 &&
                        nrow < m &&
                        ncol >= 0 &&
                        ncol < n &&
                        image[nrow][ncol] ==
                        originalColor) {

                        image[nrow][ncol] = color;

                        q.offer(
                            new Pair(nrow, ncol)
                        );
                    }
                }
            }
        }

        return image;
    }
}

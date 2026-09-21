//Leetcode 1376 - Time Needed to Inform All Employees

//
// Approach: DFS + Adjacency List
//
// Build a tree where each employee stores their direct subordinates.
// Start DFS from the head employee and calculate the total time needed
// for each subtree.
// For every employee, add their inform time to the maximum time needed
// by any of their subordinates.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                graph[manager[i]].add(i);
            }
        }

        return dfs(headID, graph, informTime);
    }

    private int dfs(int employee, List<Integer>[] graph, int[] informTime) {
        int maxTime = 0;

        for (int subordinate : graph[employee]) {
            maxTime = Math.max(maxTime, dfs(subordinate, graph, informTime));
        }

        return informTime[employee] + maxTime;
    }
}

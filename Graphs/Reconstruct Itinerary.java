//Leetcode 332 - Reconstruct Itinerary

//
// Approach: DFS + Hierholzer's Algorithm
//
// Build a graph from each airport to its destinations and keep the
// destinations sorted so the lexicographically smallest route is chosen.
// Use DFS to consume every ticket exactly once.
// Add an airport to the result after exploring all its outgoing edges.
// Reverse the result to obtain the valid itinerary.
//
// Time Complexity:
// O(E log E)
//
// Space Complexity:
// O(E)
class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> ticket : tickets) {
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>())
                 .offer(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>();

        dfs("JFK", graph, result);

        return result;
    }

    private void dfs(String airport,
                     Map<String, PriorityQueue<String>> graph,
                     LinkedList<String> result) {

        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {
            dfs(destinations.poll(), graph, result);
        }

        result.addFirst(airport);
    }
}

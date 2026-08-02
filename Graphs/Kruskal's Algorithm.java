// Kruskal's Algorithm (Minimum Spanning Tree)
//
// Approach:
//
// - Store all edges.
// - Sort edges by increasing weight.
// - Use Disjoint Set Union (DSU).
// - For every edge:
//      If both vertices belong to different sets,
//      include the edge in MST.
//      Merge the two sets.
// - Skip edges that form a cycle.
//
// Time Complexity:
// O(E log E)
//
// Space Complexity:
// O(V + E)

class Edge {

    int src;
    int dest;
    int weight;

    Edge(int src, int dest, int weight) {

        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class DisjointSet {

    int[] parent;
    int[] size;

    DisjointSet(int n) {

        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {

            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int node) {

        if (parent[node] == node) {

            return node;
        }

        parent[node] =
            findUPar(parent[node]);

        return parent[node];
    }

    void unionBySize(int u, int v) {

        int pu = findUPar(u);
        int pv = findUPar(v);

        if (pu == pv) {
            return;
        }

        if (size[pu] < size[pv]) {

            parent[pu] = pv;
            size[pv] += size[pu];
        }

        else {

            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {

    static int spanningTree(
            int V,
            int E,
            int[][] edges) {

        ArrayList<Edge> list =
            new ArrayList<>();

        for (int[] edge : edges) {

            list.add(
                new Edge(
                    edge[0],
                    edge[1],
                    edge[2]
                )
            );
        }

        Collections.sort(
            list,
            (a, b) -> a.weight - b.weight
        );

        DisjointSet ds =
            new DisjointSet(V);

        int mstWeight = 0;

        for (Edge edge : list) {

            if (ds.findUPar(edge.src)
                    != ds.findUPar(edge.dest)) {

                mstWeight += edge.weight;

                ds.unionBySize(
                    edge.src,
                    edge.dest
                );
            }
        }

        return mstWeight;
    }
}

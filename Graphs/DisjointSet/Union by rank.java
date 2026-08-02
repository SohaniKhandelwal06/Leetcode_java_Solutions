// Disjoint Set Union (Union by Rank + Path Compression)

/*
Approach

- Every node is initially its own parent.
- Find operation returns the ultimate parent.
- Path Compression makes future finds faster.
- Union by Rank attaches the smaller-height tree
  below the larger-height tree.

Time Complexity:
Nearly O(1) per operation
(Amortized O(α(N)))

Space Complexity: O(N)
*/

class DisjointSet {

    ArrayList<Integer> parent;
    ArrayList<Integer> rank;

    DisjointSet(int n) {

        parent = new ArrayList<>();
        rank = new ArrayList<>();

        for (int i = 0; i <= n; i++) {

            parent.add(i);
            rank.add(0);
        }
    }

    // Find Ultimate Parent
    int findUPar(int node) {

        if (node == parent.get(node)) {

            return node;
        }

        int ulp =
            findUPar(parent.get(node));

        parent.set(node, ulp);

        return parent.get(node);
    }

    // Union by Rank
    void unionByRank(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (rank.get(ulp_u) < rank.get(ulp_v)) {

            parent.set(ulp_u, ulp_v);
        }

        else if (rank.get(ulp_v) < rank.get(ulp_u)) {

            parent.set(ulp_v, ulp_u);
        }

        else {

            parent.set(ulp_v, ulp_u);

            rank.set(
                ulp_u,
                rank.get(ulp_u) + 1
            );
        }
    }
}

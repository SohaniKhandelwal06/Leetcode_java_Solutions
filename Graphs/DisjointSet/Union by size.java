// Disjoint Set Union (Union by Size + Path Compression)

class DisjointSet {

    ArrayList<Integer> parent;
    ArrayList<Integer> size;

    DisjointSet(int n) {

        parent = new ArrayList<>();
        size = new ArrayList<>();

        for (int i = 0; i <= n; i++) {

            parent.add(i);
            size.add(1);
        }
    }

    int findUPar(int node) {

        if (node == parent.get(node)) {

            return node;
        }

        int ulp =
            findUPar(parent.get(node));

        parent.set(node, ulp);

        return parent.get(node);
    }

    void unionBySize(int u, int v) {

        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (size.get(ulp_u) <
            size.get(ulp_v)) {

            parent.set(ulp_u, ulp_v);

            size.set(
                ulp_v,
                size.get(ulp_u) +
                size.get(ulp_v)
            );
        }

        else {

            parent.set(ulp_v, ulp_u);

            size.set(
                ulp_u,
                size.get(ulp_u) +
                size.get(ulp_v)
            );
        }
    }
}

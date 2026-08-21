// Leetcode 1090 - Largest Values From Labels
//
// Approach: Greedy + Sorting + HashMap
//
// Sort items by value in descending order.
// Pick the highest-value item if its label
// has not reached useLimit.
//
// Time Complexity: O(N log N)
// Space Complexity: O(N)

class Solution {

    public int largestValsFromLabels(
            int[] values,
            int[] labels,
            int numWanted,
            int useLimit) {

        int n = values.length;

        Integer[] indices = new Integer[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices by value descending
        Arrays.sort(
            indices,
            (a, b) ->
                Integer.compare(
                    values[b],
                    values[a]
                )
        );

        HashMap<Integer, Integer> used =
            new HashMap<>();

        int sum = 0;
        int count = 0;

        for (int index : indices) {

            if (count == numWanted) {
                break;
            }

            int label = labels[index];

            int labelCount =
                used.getOrDefault(label, 0);

            if (labelCount < useLimit) {

                sum += values[index];

                used.put(
                    label,
                    labelCount + 1
                );

                count++;
            }
        }

        return sum;
    }
}

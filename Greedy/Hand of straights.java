// Leetcode 846 - Hand of Straights
//
// Approach: Greedy + TreeMap
//
// Always start a group from the smallest
// available card.
//
// Time Complexity: O(N log N)
// Space Complexity: O(N)

class Solution {

    public boolean isNStraightHand(
            int[] hand,
            int groupSize) {

        int n = hand.length;

        if (n % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map =
            new TreeMap<>();

        // Frequency of every card
        for (int card : hand) {

            map.put(
                card,
                map.getOrDefault(card, 0) + 1
            );
        }

        while (!map.isEmpty()) {

            int first = map.firstKey();

            // Build a consecutive group
            for (int card = first;
                 card < first + groupSize;
                 card++) {

                if (!map.containsKey(card)) {
                    return false;
                }

                int count = map.get(card);

                if (count == 1) {
                    map.remove(card);
                } else {
                    map.put(card, count - 1);
                }
            }
        }

        return true;
    }
}

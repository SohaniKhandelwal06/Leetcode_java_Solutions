//Leetcode 914 - X of a Kind in a Deck of Cards

//
// Approach: HashMap + GCD
//
// Count the frequency of every card value.
// For a valid grouping, the group size must divide the frequency of
// every card value and must be at least 2.
// Find the GCD of all frequencies. If the GCD is at least 2, the deck
// can be divided into valid groups.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int card : deck) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        int gcd = 0;

        for (int count : map.values()) {
            gcd = findGcd(gcd, count);
        }

        return gcd >= 2;
    }

    private int findGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}

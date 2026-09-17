//Leetcode 1010 - Pairs of Songs With Total Durations Divisible by 60

//
// Approach: HashMap + Remainder
//
// For every song duration, calculate its remainder when divided by 60.
// To make a pair divisible by 60, the second song must have remainder
// (60 - remainder) % 60.
//
// Store the frequency of each remainder in a HashMap.
// For the current song, add the number of previously seen songs
// having the required remainder.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(1)
import java.util.*;

class Solution {

    public int numPairsDivisibleBy60(int[] time) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 0;

        for (int t : time) {

            int rem = t % 60;

            // Required remainder to make sum divisible by 60
            int required = (60 - rem) % 60;

            // Add previous valid pairs
            count += map.getOrDefault(required, 0);

            // Store current remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}

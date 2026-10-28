//LeetCode 911 — Online Election
/* Approach
You are given two arrays:
- persons[i] — the person who received a vote at time times[i].
- times[i] — the time when that vote was cast. The times are strictly increasing.
Implement q(int t) to return the person leading the election at time t. If multiple people are tied for the most votes, the person who received the most recent vote wins the tie.
Strategy: Precompute leaders + Binary Search
Instead of recounting votes for every query, process the votes once in chronological order.
1. Use a HashMap to track each person's vote count.
2. After each vote, update the current leader if that person has at least as many votes as the current leader. Using >= ensures the most recently voted-for person wins ties.
3. Store the leader after each vote in a leaders array.
4. For each query time t, use binary search to find the last index where times[i] <= t. Return leaders[i].
This makes each query efficient, even when there are many queries.
*/

import java.util.HashMap;
import java.util.Map;

class TopVotedCandidate {
    private final int[] times;
    private final int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];

        Map<Integer, Integer> votes = new HashMap<>();

        int leader = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];

            int count = votes.getOrDefault(person, 0) + 1;
            votes.put(person, count);

            // Most recent vote wins ties
            if (count >= maxVotes) {
                maxVotes = count;
                leader = person;
            }

            leaders[i] = leader;
        }
    }

    public int q(int t) {
        int left = 0;
        int right = times.length;

        // Find the first index where times[index] > t
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (times[mid] <= t) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // The previous index contains the latest valid leader
        return leaders[left - 1];
    }
}

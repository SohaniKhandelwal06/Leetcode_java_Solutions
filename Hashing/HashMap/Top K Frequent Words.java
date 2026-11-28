//LeetCode 692 - Top K Frequent Words

/*Approach: HashMap + PriorityQueue

Use a HashMap to count the frequency of each word and a PriorityQueue to maintain the top k frequent words.

Store each word's frequency in a HashMap.

Use a min-heap of size k.

The heap should prioritize:

Words with lower frequency first.

For equal frequencies, lexicographically larger words first.

If the heap size exceeds k, remove the top element.

Extract the remaining words and reverse the result.
For equal frequencies, words are sorted lexicographically.

Complexity Analysis

Let n be the number of words and m be the number of unique words.

Time Complexity: O(n + m log k)

Space Complexity: O(m + k)

*/

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            if (map.get(a).equals(map.get(b))) {
                return b.compareTo(a);
            }

            return map.get(a) - map.get(b);
        });

        for (String word : map.keySet()) {
            pq.offer(word);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();

        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);

        return result;
    }
}

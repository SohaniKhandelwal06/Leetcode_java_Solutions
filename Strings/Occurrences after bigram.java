// Leetcode 1078 - Occurrences After Bigram
//
// Find every word that occurs immediately after
// the sequence: first, second.
//
// Time Complexity: O(N)
// Space Complexity: O(N)

class Solution {

    public String[] findOcurrences(
            String text,
            String first,
            String second) {

        String[] words = text.split(" ");

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length - 2; i++) {

            if (words[i].equals(first) &&
                words[i + 1].equals(second)) {

                ans.add(words[i + 2]);
            }
        }

        return ans.toArray(new String[0]);
    }
}

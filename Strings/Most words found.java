// Leetcode 2114 - Maximum Number of Words Found in Sentences
//
// A sentence with N spaces has N + 1 words.
//
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {

    public int mostWordsFound(String[] sentences) {

        int max = 0;

        for (String sentence : sentences) {

            int words = 1;

            for (char ch : sentence.toCharArray()) {

                if (ch == ' ') {
                    words++;
                }
            }

            max = Math.max(max, words);
        }

        return max;
    }
}

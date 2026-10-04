//Leetcode 557 - Reverse Words in a String III

// // Approach: Two Pointers //
// Split the sentence into words.
// For each word, use two pointers to swap characters from both ends
// until the pointers meet. 
// Join the reversed words with a single space. // 
// Time Complexity: // O(N)
// // Space Complexity: 
// O(N)
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();

            int left = 0;
            int right = chars.length - 1;

            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }

            words[i] = new String(chars);
        }

        return String.join(" ", words);
    }
}

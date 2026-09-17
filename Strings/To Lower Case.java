//Leetcode 709 - To Lower Case

//
// Approach: Character Conversion
//
// Traverse each character of the string and convert it to lowercase
// using Character.toLowerCase().
// Append each converted character to a StringBuilder.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(N)
class Solution {
    public String toLowerCase(String s) {

        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            res.append(Character.toLowerCase(c));
        }

        return res.toString();
    }
}

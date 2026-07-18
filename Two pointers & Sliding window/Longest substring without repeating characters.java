 // Leetcode - 3 - Longest Substring Without Repeating Characters

/*
Approach (Sliding Window + HashSet):

1. Maintain a sliding window [left, right].
2. Use a HashSet to store the characters currently in the window.
3. Expand the window by moving the right pointer.
4. If the current character is already in the set:
   - Remove characters from the left until the duplicate is removed.
5. Add the current character to the set.
6. Update the maximum window length.

Time Complexity: O(N)
Space Complexity: O(min(N, Character Set))
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l=0;
        int r=0;
        int max=0;
        HashSet<Character>set=new HashSet<>();
        while(r<s.length()){
            if(!set.contains(s.charAt(r))){
set.add(s.charAt(r));
max=Math.max(max,set.size());
            r++;
        }
                else{
                    set.remove(s.charAt(l));
l++;
                }
            
                    
                }
        return max;
        
    }
}

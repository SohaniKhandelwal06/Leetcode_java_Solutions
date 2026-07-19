// Leetcode - 1358 - Number of Substrings Containing All Three Characters

/*
Approach (Sliding Window)

Observation:
A valid substring must contain at least one:
'a', 'b', and 'c'.

Algorithm:

1. Maintain a sliding window [left, right].
2. Store the frequency of 'a', 'b', and 'c'.
3. Expand the window by moving right.
4. Whenever the window contains all three characters:
      freq[a] > 0
      freq[b] > 0
      freq[c] > 0

   Then every substring starting at 'left'
   and ending from right to n-1 is valid.

   Therefore,

      count += n - right

5. Shrink the window from the left and continue.

Time Complexity: O(N)
Space Complexity: O(1)
*/

class Solution {
    public int numberOfSubstrings(String s) {
        int []freq=new int[3];
        int l=0;
        int r=0;
        int cnt=0;
        while(r<s.length()){
            freq[s.charAt(r)-'a']++;
            
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                cnt=cnt+s.length()-r;
                freq[s.charAt(l)-'a']--;
           l++;
            }
            r++;
        }
        return cnt;
        
    }
}

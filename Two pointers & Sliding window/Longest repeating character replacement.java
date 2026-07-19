// Leetcode - 424 - Longest Repeating Character Replacement

/*
Approach (Sliding Window):

Observation:
We can replace at most k characters.

Suppose:
Window Size = right - left + 1
Maximum Frequency Character = maxFreq

Characters to replace =
Window Size - maxFreq

If:
(Window Size - maxFreq) <= k

then the current window is valid.

Algorithm:

1. Maintain a sliding window.
2. Store the frequency of each character.
3. Keep track of the maximum frequency inside the window.
4. If:
      windowSize - maxFreq > k
   shrink the window.
5. Update the maximum window size.

Time Complexity: O(N)
Space Complexity: O(26) = O(1)
*/

class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer>map=new HashMap<>();
        int l=0;
        int r=0;
        int len=0;
        int freq=0;
        while(r<s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
freq=Math.max(freq,map.get(s.charAt(r)));
if(r-l+1-freq>k){
map.put(s.charAt(l),map.get(s.charAt(l))-1);
if(map.get(s.charAt(l))==0){
map.remove(s.charAt(l));
    }
l++;
        }
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
        
    }
}

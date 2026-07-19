// Leetcode - 904 - Fruit Into Baskets

/*
Approach (Sliding Window + HashMap):

1. Maintain a sliding window [left, right].
2. Use a HashMap to store:
      fruit type -> frequency.
3. Expand the window by moving right.
4. If more than 2 fruit types exist,
   shrink the window from the left until
   only 2 types remain.
5. Update the maximum window length.

Why HashMap?
- We need to know:
   • how many fruit types are in the window.
   • when a fruit type completely disappears.

Time Complexity: O(N)
Space Complexity: O(1)
(The map stores at most 3 fruit types before shrinking.)
*/
class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int l=0;
        int r=0;
        int maxlength=0;
        while(r<fruits.length){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            if(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
if(map.get(fruits[l])==0) {
map.remove(fruits[l]);
            }
l++;
            }
        
            maxlength=Math.max(maxlength,r-l+1);
            r++;
        }
        
        return maxlength;
    }
}

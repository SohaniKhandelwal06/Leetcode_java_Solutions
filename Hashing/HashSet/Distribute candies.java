// Leetcode - 575 - Distribute Candies

/*
Approach (HashSet):
1. Store all distinct candy types in a HashSet.
2. Count the number of unique candy types using the set size.
3. Alice can eat only n/2 candies.
4. Therefore, the maximum number of different candy types she can eat is:
      min(number of distinct types, n/2)

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public int distributeCandies(int[] candyType) {
        int n=candyType.length;
        HashSet<Integer>set=new HashSet<>();
        for(int candy:candyType){
            set.add(candy);
        }
return Math.min(n/2,set.size());        
    }
}

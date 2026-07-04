// Leetcode - 217 - Contains Duplicate

/*
Approach:
1. Create a HashSet to store the elements.
2. Traverse the array.
3. If the current element is already present in the HashSet, return true.
4. Otherwise, add the element to the HashSet.
5. If no duplicate is found, return false.

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
if(set.contains(num)){
return true;
}
            set.add(num);
        }
        return false;
        
    }
}

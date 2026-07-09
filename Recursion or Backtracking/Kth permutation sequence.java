// Leetcode - 60 - Permutation Sequence

/*
Approach (Factorial Number System):
1. Store the numbers from 1 to n in a list.
2. Compute (n - 1)! to determine the size of each permutation group.
3. Convert k to zero-based indexing.
4. Repeatedly select the appropriate digit using k / factorial.
5. Remove the selected digit from the list.
6. Update k and the factorial for the remaining digits.
7. Continue until all digits are selected to form the kth permutation.

Time Complexity: O(N²)
Space Complexity: O(N)
*/

class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer>list=new ArrayList<>();
        for(int i=1;i<n;i++){
            fact=fact*i;
            list.add(i);
        }
list.add(n);
k=k-1;
        StringBuilder ans=new StringBuilder();
        while(true){
ans.append(list.get(k/fact));
list.remove(k/fact);
if(list.size()==0){
    break;
}
            k=k%fact;
            fact=fact/list.size();
}
        return ans.toString();
        
    }
}

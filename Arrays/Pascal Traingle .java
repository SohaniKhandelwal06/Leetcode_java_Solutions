// Leetcode - 118 - Pascal's Triangle

/*
Approach:
1. Generate each row independently.
2. Start every row with 1.
3. Compute the remaining elements using the previous element:
   ans = ans * (row - col) / col.
4. Add each generated row to the final answer.
5. Return the complete Pascal's Triangle.

Time Complexity: O(N²)
Space Complexity: O(1) (excluding the output list)
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ansRow=new ArrayList<>();
        long ans=1;
        for(int col=0;col<numRows;col++){
            ansRow.add(generateRow(col+1));
        }
        return ansRow;
        
    }
    private List<Integer>generateRow(int RowNumber){
        List<Integer>ansRow=new ArrayList<>();
    ansRow.add(1);
        long ans=1;
        for(int col=1;col<RowNumber;col++){
            ans=ans*(RowNumber-col);
            ans=ans/col;
            ansRow.add((int)ans);
        }
        return ansRow;
    }
}

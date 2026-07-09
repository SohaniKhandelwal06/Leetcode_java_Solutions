// Leetcode - 17 - Letter Combinations of a Phone Number

/*
Approach (Recursion + Backtracking):
1. Create a mapping of digits (2–9) to their corresponding letters.
2. Start from the first digit and recursively build all possible letter combinations.
3. For each letter mapped to the current digit:
   - Add the letter to the current combination.
   - Recursively process the next digit.
4. When all digits have been processed, add the completed combination to the answer.
5. Backtrack by removing the last added letter before trying the next one.

Time Complexity: O(4^N × N)
Space Complexity: O(N) (Recursion Stack + StringBuilder)
*/
class Solution {
private static final String[] map = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    public List<String> letterCombinations(String digits) {
        List<String>ans=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        if(digits.length()==0){
return  ans;
        }
        solve(0,digits,ans,sb);
return ans;
    }
    private void solve(int idx,String s,List<String>ans,StringBuilder sb){
        int n=s.length();
        if(idx==n){
ans.add(sb.toString());
            return;
        }
        String letters=map[s.charAt(idx)-'0'];
        for(char ch:letters.toCharArray()){
        sb.append(ch);
        solve(idx+1,s,ans,sb);
sb.deleteCharAt(sb.length()-1);
    }
}
}

// Leetcode - 131 - Palindrome Partitioning

/*
Approach (Recursion + Backtracking):
1. Start partitioning the string from index 0.
2. For each possible substring starting at the current index, check if it is a palindrome.
3. If the substring is a palindrome, add it to the current partition.
4. Recursively partition the remaining suffix of the string.
5. When the end of the string is reached, add the current partition to the answer.
6. Backtrack by removing the last added substring to explore other valid partitions.

Time Complexity: O(N × 2^N)
Space Complexity: O(N) (Recursion Stack)
*/
class Solution {
    private boolean isPalindrome(String s,int start,int end){
while(start<=end){
if(s.charAt(start++)!=s.charAt(end--)){
    return false;
    
}

}
        return true;
    }
    private void solve(int idx,String s,List<List<String>>ans,List<String>path){
if(idx==s.length()){
    ans.add(new ArrayList<>(path));
return;
}
        for(int i=idx;i<s.length();i++){
if(isPalindrome(s,idx,i)){
path.add(s.substring(idx,i+1));
    solve(i+1,s,ans,path);
path.remove(path.size()-1);
}
        }
    }
            
        

    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>path=new ArrayList<>();
        solve(0,s,ans,path);
return ans;
        
    }
}

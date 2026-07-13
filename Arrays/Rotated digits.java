// Leetcode - 788 - Rotated Digits

/*
Approach:
1. Iterate through every number from 1 to n.
2. Check each digit:
   - If it contains 3, 4, or 7, it is invalid.
   - If it contains 2, 5, 6, or 9, mark that the number changes after rotation.
3. A number is good if:
   - It has no invalid digits.
   - At least one digit changes after rotation.
4. Count all such numbers.

Time Complexity: O(N × D)
where D is the number of digits in n.

Space Complexity: O(1)
*/


class Solution {
    public int rotatedDigits(int n) {
        int cnt=0;
for(int i=1;i<=n;i++){

        if(isGood(i)==true){
            cnt++;
        }
}
        return cnt;
        }
    private boolean isGood(int n){
boolean changed=false;
     
        while(n>0){
          int  d=n%10;
            if(d==3||d==4||d==7){
                return false;
            }
            if(d==2||d==5||d==6||d==9){
                changed=true;
            }
            n=n/10;
            }
        return changed;
        }
     }
        
        
    

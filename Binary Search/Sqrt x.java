// Leetcode - 69 - Sqrt(x)

/*
Approach (Binary Search):
1. Handle the edge cases where x is 0 or 1.
2. Perform binary search on the range [1, x].
3. Compute mid and compare mid * mid with x.
4. If mid * mid equals x, return mid.
5. If mid * mid is less than x:
   - Store mid as the current answer.
   - Search in the right half for a larger possible square root.
6. Otherwise, search in the left half.
7. Return the stored answer, which is the integer part of √x.

Time Complexity: O(log N)
Space Complexity: O(1)
*/


class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1){
            return x;
        }
        int low=1;
        int high=x;
        int res=0;
        while(low<=high){
int mid=low+(high-low)/2;
long ans=(long)mid*mid;
            if(ans==x){
return mid;
            }
            else if(ans<x){
                res=mid;
low=mid+1;
        
    }
            else{
                high=mid-1;
            }
        }
        return res;
            }
}

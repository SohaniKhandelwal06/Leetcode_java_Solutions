// Leetcode - 875 - Koko Eating Bananas

/*
Approach (Binary Search on Answer):
1. The minimum possible eating speed is 1 banana/hour.
2. The maximum possible eating speed is the largest pile size.
3. Perform binary search on the eating speed.
4. For each speed, calculate the total hours required to finish all piles.
5. If the total hours are within h, try a smaller speed.
6. Otherwise, increase the eating speed.
7. The first valid speed is the minimum required.

Time Complexity: O(N × log(MaxPile))
Space Complexity: O(1)
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=findMax(piles);
while(low<=high){
int mid=low+(high-low)/2;
long total=findTotal(piles,mid);
if(total<=h){
high=mid-1;
}
    else{
        low=mid+1;
    }
}
        return low;
    }
    private long findTotal(int[]arr,int hourly){
long total=0;
        for(int i=0;i<arr.length;i++){
            total += (arr[i] + hourly - 1) / hourly;
        }
return total;
        
    }
    private int findMax(int[]arr){
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
    maxi=Math.max(maxi,arr[i]);

        
        }
return maxi;
    }

}

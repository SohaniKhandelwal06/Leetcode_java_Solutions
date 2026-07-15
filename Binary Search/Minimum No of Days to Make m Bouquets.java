// Leetcode - 1482 - Minimum Number of Days to Make m Bouquets

/*
Approach (Binary Search on Answer):
1. If m × k > total flowers, it is impossible to make the required bouquets.
2. The answer lies between:
   - Minimum bloom day.
   - Maximum bloom day.
3. Perform binary search on the number of days.
4. For each day:
   - Count consecutive flowers that have bloomed.
   - Every k consecutive bloomed flowers form one bouquet.
5. If at least m bouquets can be formed, try fewer days.
6. Otherwise, increase the number of days.
7. Return the minimum valid day.

Time Complexity: O(N × log(MaxBloomDay))
Space Complexity: O(1)
*/













class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if((long)m*k>n){
            return -1;
        }
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int day:bloomDay){
low=Math.min(low,day);
high=Math.max(high,day);
        }
while(low<=high){
int mid=low+(high-low)/2;
if(possible(bloomDay,mid,m,k)==true){

    high=mid-1;
}
    else{
        low=mid+1;
    }
    
    }
        return low;
    }
    private boolean possible(int[]arr,int day,int m,int k){
int cnt=0;
        int bouquet=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
cnt++;
            }
            else{
             bouquet=bouquet+cnt/k;
                cnt=0;
            }
            }
            bouquet=bouquet+cnt/k;
            if(bouquet>=m) return true;
        
        return false;
    }
            
        }

    
     
        
    

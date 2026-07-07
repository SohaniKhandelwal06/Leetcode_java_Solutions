// Leetcode - 1331 - Rank Transform of an Array

/*
Approach:
1. Create a copy of the original array and sort it.
2. Traverse the sorted array and assign ranks to unique elements using a HashMap.
3. Traverse the original array and replace each element with its corresponding rank from the HashMap.
4. Return the transformed array.

Time Complexity: O(N log N)
Space Complexity: O(N)
*/






class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[]temp=arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer>map=new HashMap<>();
int rank=1;
        for(int num:temp){
if(!map.containsKey(num)){
map.put(num,rank++);
    }
}
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
return arr;
    }
}

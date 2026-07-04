// Leetcode - 202 - Happy Number

/*
Approach:
1. Repeatedly replace the number with the sum of the squares of its digits.
2. Use a HashSet to store previously seen numbers.
3. If the number becomes 1, it is a happy number.
4. If a number repeats, a cycle exists and the number is not happy.
5. Return true if the number reaches 1, otherwise return false.

Time Complexity: O(log N)
Space Complexity: O(log N)
*/class Solution {
private int getNext(int n){
int sum=0;
    while(n>0){
        int d=n%10;
        sum=sum+d*d;
        n=n/10;
    }
    return sum;
}
    public boolean isHappy(int n) {
        HashSet<Integer>set=new HashSet<>();
while(n!=1){
    if(set.contains(n)){
        return false;
    }
    set.add(n);
n=getNext(n);
}
        return true;
        
    }
}

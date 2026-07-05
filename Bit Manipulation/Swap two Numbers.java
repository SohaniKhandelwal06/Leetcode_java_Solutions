// Swap Two Numbers using Bit Manipulation

/*
Approach:
1. XOR the two numbers and store the result in the first number.
2. XOR the updated first number with the second number to obtain the original first number.
3. XOR the updated first number with the updated second number to obtain the original second number.
4. The two numbers are swapped without using extra space.

Time Complexity: O(1)
Space Complexity: O(1)
*/
class Solution{
  public int[] swap(int a,int b){
    a=a^b;
    b=a^b;
    a=a^b;
    return new int[]{a,b};
  }
}

//Decimal to Binary
/*
1. Divide the decimal number by 2.
2. Store the remainder (0 or 1).
3. Update the number to the quotient.
4. Repeat until the number becomes 0.
5. Read the remainders in reverse order.

Time Complexity:O(log n)
Space Complexity:O(log n)

*/




class Solution{
  public static String decimalToBinary(int n) {
    if (n == 0) return "0";

    StringBuilder binary = new StringBuilder();

    while (n > 0) {
        binary.append(n % 2);
        n /= 2;
    }

    return binary.reverse().toString();
}
}

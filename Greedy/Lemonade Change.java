// Leetcode 860 - Lemonade Change
//
// Approach (Greedy)
//
// - Maintain count of $5 and $10 bills.
// - For $5:
//      Increase five count.
// - For $10:
//      Give one $5.
// - For $20:
//      Prefer giving one $10 and one $5.
//      Otherwise give three $5 bills.
// - If change cannot be given,
//   return false.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(1)

class Solution {

    public boolean lemonadeChange(
            int[] bills) {

        int five = 0;
        int ten = 0;

        for (int bill : bills) {

            if (bill == 5) {

                five++;
            }

            else if (bill == 10) {

                if (five == 0) {
                    return false;
                }

                five--;
                ten++;
            }

            else {

                if (ten > 0 && five > 0) {

                    ten--;
                    five--;
                }

                else if (five >= 3) {

                    five -= 3;
                }

                else {

                    return false;
                }
            }
        }

        return true;
    }
}

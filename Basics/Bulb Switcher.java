// LeetCode 319 — Bulb Switcher
/* Approach
You have n bulbs, initially off, numbered from 1 to n.

You make n rounds:
- Round 1: Toggle every bulb.
- Round 2: Toggle every second bulb.
- Round 3: Toggle every third bulb.
- Continue until round n, toggling every i-th bulb during round i.
Return the number of bulbs that remain on after all rounds.
Key observation
A bulb at position k is toggled once for every divisor of k.

For example, bulb 6 is toggled during rounds 1, 2, 3, and 6 — four times. Since four is even, it ends up off.

Most numbers have divisors in pairs. For example, the divisors of 12 are (1,12), (2,6), and (3,4).

Perfect squares are different: one divisor pair contains the same number twice, such as (3,3) for 9. Therefore, perfect squares have an odd number of divisors and remain on.
*/

class Solution {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}


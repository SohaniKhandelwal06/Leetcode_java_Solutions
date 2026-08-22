// Leetcode 93 - Restore IP Addresses
//
// Approach: Backtracking
//
// An IP address has exactly 4 parts.
// Each part:
// 1. Contains 1 to 3 digits
// 2. Is between 0 and 255
// 3. Cannot have leading zeroes
//
// Time Complexity: O(3^4)
// Space Complexity: O(N) excluding answer

class Solution {

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        backtrack(
            s,
            0,
            0,
            new StringBuilder(),
            ans
        );

        return ans;
    }

    private void backtrack(
            String s,
            int index,
            int parts,
            StringBuilder current,
            List<String> ans) {

        // Four parts created
        if (parts == 4) {

            if (index == s.length()) {

                ans.add(
                    current.substring(
                        0,
                        current.length() - 1
                    )
                );
            }

            return;
        }

        // A part can have at most 3 digits
        for (int len = 1;
             len <= 3 &&
             index + len <= s.length();
             len++) {

            String part =
                s.substring(
                    index,
                    index + len
                );

            // Leading zero is invalid
            if (part.length() > 1 &&
                part.charAt(0) == '0') {
                break;
            }

            // Value must be <= 255
            if (Integer.parseInt(part) > 255) {
                break;
            }

            int oldLength = current.length();

            current.append(part);
            current.append('.');

            backtrack(
                s,
                index + len,
                parts + 1,
                current,
                ans
            );

            // Backtrack
            current.setLength(oldLength);
        }
    }
}

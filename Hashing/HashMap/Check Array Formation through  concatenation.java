//Leetcode 1640 - Check Array Formation Through Concatenation

//
// Approach: HashMap + Sequential Matching
//
// Store each piece in a HashMap using its first element as the key.
// Traverse arr from left to right and find the piece that starts
// with the current value.
// Check every element of that piece against arr and move the pointer.
//
// Time Complexity:
// O(N)
//
// Space Complexity:
// O(K)
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> map = new HashMap<>();

        for (int[] piece : pieces) {
            map.put(piece[0], piece);
        }

        int i = 0;

        while (i < arr.length) {
            if (!map.containsKey(arr[i])) {
                return false;
            }

            int[] piece = map.get(arr[i]);

            for (int num : piece) {
                if (i >= arr.length || arr[i] != num) {
                    return false;
                }
                i++;
            }
        }

        return true;
    }
}

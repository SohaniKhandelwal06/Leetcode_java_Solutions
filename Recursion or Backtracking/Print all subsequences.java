// Print All Subsequences

/*
Approach (Recursion + Backtracking):
1. Start from the first index of the array.
2. For each element, make two recursive choices:
   - Include the current element in the subsequence.
   - Exclude the current element from the subsequence.
3. When the index reaches the end of the array, print the current subsequence.
4. Backtrack after including an element to explore other possible subsequences.

Time Complexity: O(2^N)
Space Complexity: O(N) (Recursion Stack)
*/












class Solution {
    public static void printSubsequences(int[] arr) {
        List<Integer> list = new ArrayList<>();
        solve(0, arr, list);
    }

    private static void solve(int index, int[] arr, List<Integer> list) {
        if (index == arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[index]);
        solve(index + 1, arr, list);

        list.remove(list.size() - 1);
        solve(index + 1, arr, list);
    }
}

// Print All Subsequences with Sum = K

/*
Approach (Recursion + Backtracking):
1. Start from the first index of the array.
2. For each element, recursively make two choices:
   - Include the current element and add it to the current sum.
   - Exclude the current element.
3. When the end of the array is reached, check if the current sum equals K.
4. If the sum is K, print the current subsequence.
5. Backtrack after every inclusion to explore all possible subsequences.

Time Complexity: O(2^N)
Space Complexity: O(N) (Recursion Stack)
*/






class Solution {
    public static void printSubsequences(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        solve(0, arr, list, 0, k);
    }

    private static void solve(int index, int[] arr, List<Integer> list, int sum, int k) {
        if (index == arr.length) {
            if (sum == k) {
                System.out.println(list);
            }
            return;
        }

        list.add(arr[index]);
        solve(index + 1, arr, list, sum + arr[index], k);

        list.remove(list.size() - 1);
        solve(index + 1, arr, list, sum, k);
    }
}

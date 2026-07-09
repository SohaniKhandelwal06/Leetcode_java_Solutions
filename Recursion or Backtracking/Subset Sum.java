// GeeksforGeeks - Subset Sums

/*
Approach (Recursion + Backtracking):
1. Start from the first element with an initial sum of 0.
2. For each element, recursively make two choices:
   - Include the current element in the sum.
   - Exclude the current element.
3. When all elements have been processed, store the current sum.
4. Sort the list of subset sums.
5. Return the sorted list.

Time Complexity: O(2^N)
Space Complexity: O(N) (Recursion Stack)
*/

class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        solve(0, 0, arr, ans);
        Collections.sort(ans);
        return ans;
    }

    private void solve(int index, int sum, ArrayList<Integer> arr, ArrayList<Integer> ans) {
        if (index == arr.size()) {
            ans.add(sum);
            return;
        }

        solve(index + 1, sum + arr.get(index), arr, ans);

        solve(index + 1, sum, arr, ans);
    }
}

// Intersection of Two Arrays

/*
Approach:
1. Store all elements of the first array in a HashSet.
2. Traverse the second array.
3. If an element is present in the HashSet, add it to the answer and remove it from the HashSet to avoid duplicates.
4. Return the intersection of both arrays.

Time Complexity: O(N + M)
Space Complexity: O(N)
*/





class Solution {
    public static ArrayList<Integer> intersection(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : a) {
            set.add(num);
        }

        for (int num : b) {
            if (set.contains(num)) {
                ans.add(num);
                set.remove(num);
            }
        }

        return ans;
    }
}

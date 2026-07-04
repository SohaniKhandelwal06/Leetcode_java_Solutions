// Union of Two Arrays

/*
Approach:
1. Create a HashSet to store unique elements.
2. Traverse the first array and add all elements to the HashSet.
3. Traverse the second array and add all elements to the HashSet.
4. Convert the HashSet into an ArrayList and return it.

Time Complexity: O(N + M)
Space Complexity: O(N + M)
*/





class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : a) {
            set.add(num);
        }

        for (int num : b) {
            set.add(num);
        }

        return new ArrayList<>(set);
    }
}

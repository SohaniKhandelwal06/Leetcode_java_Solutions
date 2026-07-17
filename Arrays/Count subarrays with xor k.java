// Count Subarrays with XOR K

/*
Approach (Prefix XOR + HashMap):
1. Maintain the prefix XOR of the array.
2. Store the frequency of each prefix XOR in a HashMap.
3. Let the current prefix XOR be 'xor'.
4. To find a subarray with XOR = k:
      prefixXor ^ previousPrefixXor = k
   => previousPrefixXor = prefixXor ^ k
5. If (xor ^ k) exists in the HashMap,
   add its frequency to the answer.
6. Store the current prefix XOR in the HashMap.

Why map.put(0, 1)?
- It handles subarrays starting from index 0.

Time Complexity: O(N)
Space Complexity: O(N)
*/

class Solution {
    public long subarrayXor(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int xor = 0;
        long count = 0;

        map.put(0, 1);

        for (int num : arr) {

            xor ^= num;

            int x = xor ^ k;

            if (map.containsKey(x)) {
                count += map.get(x);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}

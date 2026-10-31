//LeetCode 599 — Minimum Index Sum of Two Lists
/*Approach: HashMap
We need to find all common strings between two lists whose sum of indices is minimum.
1. Store each string from list1 and its index in a HashMap.
2. Traverse list2 and check whether each string exists in the map.
3. Calculate the index sum for every common string.
4. If the sum is smaller than the current minimum, clear the result and add the string.
5. If the sum equals the minimum, add the string to the result.
*/

import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> map = new HashMap<>();

        // Store strings and their indices from list1
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Check common strings in list2
        for (int j = 0; j < list2.length; j++) {

            String restaurant = list2[j];

            if (map.containsKey(restaurant)) {

                int sum = map.get(restaurant) + j;

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(restaurant);
                } 
                else if (sum == minSum) {
                    result.add(restaurant);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}

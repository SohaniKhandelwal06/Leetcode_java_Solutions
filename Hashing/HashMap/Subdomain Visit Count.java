//Leetcode 811:Subdomain Visit Count
/*Approach: String Parsing + HashMap
You are given an array of strings cpdomains, where each string contains a visit count and a domain.

For every domain, count visits to:
- The complete domain.
- Its parent domains.
- The top-level domain.
For example, discuss.leetcode.com contributes visits to discuss.leetcode.com, leetcode.com, and com.

Steps:
1. Create a HashMap<String, Integer> to store visit counts.
2. Split each input string into the visit count and domain.
3. Add the visit count to the full domain.
4. Find each dot in the domain and add the count to the corresponding suffix.
5. Convert the map entries into the required output strings.
*/
import java.util.*;

class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] parts = cpdomain.split(" ");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            // Count visits to the complete domain
            map.put(domain, map.getOrDefault(domain, 0) + count);

            // Count visits to each subdomain
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);

                    map.put(
                        subdomain,
                        map.getOrDefault(subdomain, 0) + count
                    );
                }
            }
        }

        // Build the result
        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.add(entry.getValue() + " " + entry.getKey());
        }

        return result;
    }
}

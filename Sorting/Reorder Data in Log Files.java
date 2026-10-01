//Leetcode 937 - Reorder Data in Log Files

//
// Approach: Custom Sorting
//
// Separate letter-logs from digit-logs.
// Digit-logs keep their original relative order.
// Sort letter-logs first by their content, and then by identifier
// when their contents are equal.
// Finally, append the digit-logs after all letter-logs.
//
// Time Complexity:
// O(N log N × K)
//
// Space Complexity:
// O(N)
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letters = new ArrayList<>();
        List<String> digits = new ArrayList<>();

        for (String log : logs) {
            int index = log.indexOf(' ');

            if (Character.isDigit(log.charAt(index + 1))) {
                digits.add(log);
            } else {
                letters.add(log);
            }
        }

        Collections.sort(letters, (a, b) -> {
            int spaceA = a.indexOf(' ');
            int spaceB = b.indexOf(' ');

            String contentA = a.substring(spaceA + 1);
            String contentB = b.substring(spaceB + 1);

            int compare = contentA.compareTo(contentB);

            if (compare != 0) {
                return compare;
            }

            return a.substring(0, spaceA)
                    .compareTo(b.substring(0, spaceB));
        });

        String[] result = new String[logs.length];
        int index = 0;

        for (String log : letters) {
            result[index++] = log;
        }

        for (String log : digits) {
            result[index++] = log;
        }

        return result;
    }
}

// GFG - Allocate Minimum Number of Pages

/*
Approach (Binary Search on Answer):
1. If the number of students is greater than the number of books,
   allocation is impossible, so return -1.
2. The minimum possible answer is the maximum number of pages
   in a single book.
3. The maximum possible answer is the sum of all pages.
4. Perform binary search on this range.
5. For each candidate maximum pages:
   - Allocate books sequentially.
   - If adding a book exceeds the limit,
     assign it to the next student.
6. If all books can be allocated within the given students,
   try a smaller maximum.
7. Otherwise, increase the maximum.
8. Return the minimum feasible maximum pages.

Time Complexity: O(N × log(SumOfPages))
Space Complexity: O(1)
*/

class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;

        if (k > n) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (possible(arr, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean possible(int[] arr, int students, int maxPages) {
        int studentCount = 1;
        int pages = 0;

        for (int book : arr) {
            if (pages + book <= maxPages) {
                pages += book;
            } else {
                studentCount++;
                pages = book;
            }
        }

        return studentCount <= students;
    }
}

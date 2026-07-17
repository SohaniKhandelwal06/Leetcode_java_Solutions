// Merge Two Sorted Arrays Without Extra Space (Gap Method)

/*
Approach (Gap Method / Shell Sort Technique):

1. Consider both arrays as one virtual array of size n + m.
2. Initialize:
      gap = ceil((n + m) / 2)
3. Compare elements that are 'gap' distance apart.
4. Swap them if they are out of order.
5. Reduce the gap:
      gap = ceil(gap / 2)
6. Repeat until gap becomes 1, then terminate.

Cases while comparing:
1. Both pointers in arr1.
2. One pointer in arr1 and the other in arr2.
3. Both pointers in arr2.

Time Complexity: O((n + m) log(n + m))
Space Complexity: O(1)
*/
class Solution {

    public void merge(int[] arr1, int[] arr2, int n, int m) {

        int gap = (n + m + 1) / 2;

        while (gap > 0) {

            int left = 0;
            int right = left + gap;

            while (right < n + m) {

                // Both pointers in arr1
                if (left < n && right < n) {
                    if (arr1[left] > arr1[right]) {
                        swap(arr1, left, right);
                    }
                }

                // left in arr1, right in arr2
                else if (left < n && right >= n) {
                    if (arr1[left] > arr2[right - n]) {
                        int temp = arr1[left];
                        arr1[left] = arr2[right - n];
                        arr2[right - n] = temp;
                    }
                }

                // Both pointers in arr2
                else {
                    if (arr2[left - n] > arr2[right - n]) {
                        swap(arr2, left - n, right - n);
                    }
                }

                left++;
                right++;
            }

            if (gap == 1) {
                break;
            }

            gap = (gap + 1) / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

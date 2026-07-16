// Leetcode - 2104 - Sum of Subarray Ranges

/*
Approach (Monotonic Stack):
1. The range of a subarray = Maximum - Minimum.
2. Compute:
   - Sum of all subarray maximums.
   - Sum of all subarray minimums.
3. Answer = Sum(Maximums) - Sum(Minimums).

For each element:
Contribution = Value × Left × Right

where,
Left  = distance from Previous Greater/Smaller element.
Right = distance to Next Greater/Smaller element.

Comparison Rules:
Minimum:
- Previous Smaller -> >
- Next Smaller -> >=

Maximum:
- Previous Greater -> <
- Next Greater -> <=

These comparisons prevent double counting when duplicate elements exist.

Time Complexity: O(N)
Space Complexity: O(N)
*/
class Solution {

    public long subArrayRanges(int[] nums) {
        return sumOfMaximums(nums) - sumOfMinimums(nums);
    }

    private long sumOfMinimums(int[] nums) {

        int n = nums.length;
        long sum = 0;

        int[] pse = previousSmaller(nums);
        int[] nse = nextSmaller(nums);

        for (int i = 0; i < n; i++) {
            long left = i - pse[i];
            long right = nse[i] - i;

            sum += (long) nums[i] * left * right;
        }

        return sum;
    }

    private long sumOfMaximums(int[] nums) {

        int n = nums.length;
        long sum = 0;

        int[] pge = previousGreater(nums);
        int[] nge = nextGreater(nums);

        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;

            sum += (long) nums[i] * left * right;
        }

        return sum;
    }

    private int[] previousSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    private int[] nextSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    private int[] previousGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    private int[] nextGreater(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }
                   }

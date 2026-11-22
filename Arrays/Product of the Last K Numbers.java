//LeetCode 1352 – Product of the Last K Numbers
/*Difficulty: Medium
Topics: Array, Design, Prefix Sum
Language: Java
Approach: Prefix Product
Maintain a list of prefix products.
- Initially, store 1 in the list.
- When adding a non-zero number, multiply it with the previous prefix product and store the result.
- When adding 0, clear the list and reset it to [1]. This is because any product containing zero is zero.
- To calculate the product of the last k numbers:
  - If k is greater than or equal to the current list size, return 0.
  - Otherwise, divide the latest prefix product by the prefix product before the last k elements.
*/
class ProductOfNumbers {

    List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            int last = prefix.get(prefix.size() - 1);
            prefix.add(last * num);
        }
    }

    public int getProduct(int k) {
        int n = prefix.size();

        if (k >= n) {
            return 0;
        }

        return prefix.get(n - 1) / prefix.get(n - k - 1);
    }
}

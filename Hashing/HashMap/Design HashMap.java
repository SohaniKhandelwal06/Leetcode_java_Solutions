//LeetCode 706 - Design HashMap

/* Approach: Direct Addressing

Use an array of size `1000001` to store key-value pairs directly.

- Initialize all array positions with `-1` to indicate that a key does not exist.
- `put(key, value)`: Store the value at index `key`.
- `get(key)`: Return the value stored at index `key`.
- `remove(key)`: Set the corresponding index to `-1`.

Since the key itself is used as the array index, no hash function or collision handling is required.
*/
/* Complexity Analysis

- **Constructor:** O(10⁶)
- **put():** O(1)
- **get():** O(1)
- **remove():** O(1)
- **Space Complexity:** O(10⁶)
*/


class MyHashMap {

    int[] arr;

    public MyHashMap() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }

    public void put(int key, int value) {
        arr[key] = value;
    }

    public int get(int key) {
        return arr[key];
    }

    public void remove(int key) {
        arr[key] = -1;
    }
}




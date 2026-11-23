//LeetCode 1700 – Number of Students Unable to Eat Lunch
/*Difficulty: Easy
Topics: Array, Simulation, Queue
Language: Java
Approach: Counting
Instead of simulating the entire queue, count how many students prefer each type of sandwich.
- count[0] stores the number of students who prefer circular sandwiches.
- count[1] stores the number of students who prefer square sandwiches.
- Traverse the sandwiches in order.
- If no student prefers the current sandwich type, the remaining students cannot eat.
- Otherwise, decrease the corresponding count.
*/
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        int[] count = new int[2];

        for (int student : students) {
            count[student]++;
        }

        for (int sandwich : sandwiches) {

            if (count[sandwich] == 0) {
                break;
            }

            count[sandwich]--;
        }

        return count[0] + count[1];
    }
}

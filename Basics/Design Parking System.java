//LeetCode 1603 — Design Parking System
/*Approach
Design a parking system with three types of parking spaces:
- big — large parking spaces
- medium — medium parking spaces
- small — small parking spaces
The constructor receives the available number of spaces for each type. The addCar(int carType) method returns true if a space is available for that car type and parks the car; otherwise, it returns false.

Simple approach: Use an integer array to track the remaining spaces for each type.
- Store the available spaces in an array indexed by car type.
- For each incoming car, check whether its type has any spaces left.
- If a space is available, decrement the count and return true.
- Otherwise, return false.
*/

class ParkingSystem {
    private final int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (spaces[carType] > 0) {
            spaces[carType]--;
            return true;
        }

        return false;
    }
}

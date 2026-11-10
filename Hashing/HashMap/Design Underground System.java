//LeetCode 1396 — Design Underground System
/*Approach: Two HashMaps
We need to design an Underground System that supports three operations:
1. checkIn() – Store the passenger's ID, starting station and check-in time.
2. checkOut() – Calculate the travel time and update the total time and number of trips for that route.
3. getAverageTime() – Return the average travel time between two stations.
We will use two HashMaps:
- Check-in Map: Stores passenger ID and their check-in information.
- Journey Map: Stores total travel time and total number of trips for each station pair.
import java.util.*;
*/

class UndergroundSystem {

    class CheckIn {
        String station;
        int time;

        CheckIn(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    class Journey {
        int totalTime;
        int totalTrips;

        Journey(int totalTime, int totalTrips) {
            this.totalTime = totalTime;
            this.totalTrips = totalTrips;
        }
    }

    HashMap<Integer, CheckIn> checkIns;
    HashMap<String, Journey> journeys;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        journeys = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {

        checkIns.put(id, new CheckIn(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        CheckIn checkIn = checkIns.get(id);

        String route = checkIn.station + "->" + stationName;
        int travelTime = t - checkIn.time;

        if (journeys.containsKey(route)) {

            Journey journey = journeys.get(route);

            journey.totalTime += travelTime;
            journey.totalTrips++;

        } else {

            journeys.put(route, new Journey(travelTime, 1));
        }

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {

        String route = startStation + "->" + endStation;

        Journey journey = journeys.get(route);

        return (double) journey.totalTime / journey.totalTrips;
    }
}

import java.util.*;

class UndergroundSystem {

    // id -> [stationName, checkInTime]
    private Map<Integer, CheckInInfo> checkIns;

    // "start#end" -> [totalTime, tripCount]
    private Map<String, TripInfo> trips;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        trips = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.get(id);

        int travelTime = t - info.time;

        String key = info.station + "#" + stationName;

        if (!trips.containsKey(key)) {
            trips.put(key, new TripInfo(0, 0));
        }

        TripInfo trip = trips.get(key);
        trip.totalTime += travelTime;
        trip.tripCount++;

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "#" + endStation;

        TripInfo trip = trips.get(key);

        return (double) trip.totalTime / trip.tripCount;
    }

    // Stores check-in information for a customer
    private static class CheckInInfo {
        String station;
        int time;

        CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    // Stores statistics for a station pair
    private static class TripInfo {
        long totalTime;
        int tripCount;

        TripInfo(long totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }
}

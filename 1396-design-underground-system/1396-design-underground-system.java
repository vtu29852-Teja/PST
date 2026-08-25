import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    // Helper class to store check-in details
    private static class CheckInInfo {
        String stationName;
        int checkInTime;

        CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    // Helper class to accumulate trip statistics
    private static class RouteInfo {
        double totalTime = 0;
        int tripCount = 0;
    }

    // Map: customerId -> CheckInInfo
    private Map<Integer, CheckInInfo> checkIns;
    // Map: "startStation->endStation" -> RouteInfo
    private Map<String, RouteInfo> routeStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        routeStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkIns.remove(id);
        String routeKey = info.stationName + "->" + stationName;
        int travelTime = t - info.checkInTime;

        RouteInfo route = routeStats.computeIfAbsent(routeKey, k -> new RouteInfo());
        route.totalTime += travelTime;
        route.tripCount += 1;
    }

    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        RouteInfo route = routeStats.get(routeKey);
        return route.totalTime / route.tripCount;
    }
}
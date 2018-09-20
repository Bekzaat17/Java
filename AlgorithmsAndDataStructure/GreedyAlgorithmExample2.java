
//Task:
//Given point A and point B. Between A and B have fuel stations with different ranges
//and we have a car whith 500 max fuel range. Find the min stops to fuel stations
//to get from point A to point B.

public class GreedyAlgorithmExample2 {
    public static void main(String[] args) {
        int stops = 0;
        int fuelRange = 500;
        int nextStop = 0;

        int[] stations = {0, 250, 375, 750, 900, 1000, 1200};

        for (int i = 0; i < stations.length; i++) {
            if(stations[i] - stations[nextStop] > fuelRange){
                stations[nextStop] = stations[i-1];
                stops++;
                System.out.println("Stopped at station on "+stations[nextStop]+"km");
            }
        }System.out.println("Totally stopped at "+stops+" stations");


    }
}
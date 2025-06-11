import java.util.*;

public class RoundManager {
    private List<LocationPoint> locations;
    private int currentIndex;

    public RoundManager() {
        locations = new ArrayList<>();
        currentIndex = 0;

        /* TODO: ADD LOCATIONS
        locations.add(new LocationPoint(100, 200, "bottom", "cougarguessr-photo/i1.jpeg"));
        locations.add(new LocationPoint(250, 300, "bottom", "cougarguessr-photo/i2.jpeg"));
        locations.add(new LocationPoint(400, 100, "bottom", "cougarguessr-photo/i3.jpeg"));

        FLOOR ONE:
        i1, 0.5512, 0.8072
        i2, 0.5924, 0.8085
        i3, 0.5882, 0.7839
        i4, 0.5882, 0.7464

        FLOOR TWO:
        i27, 0.4749, 0.5013
        i28, 0.4596, 0.4796
        i29, 0.4650, 0.4179
        i30, 0.4632, 0.3700
        */
        Collections.shuffle(locations); 
    }

    public boolean hasNextRound() {
        return currentIndex < locations.size();
    }

    public LocationPoint getNextRound() {
        if (hasNextRound()) {
            return locations.get(currentIndex++);
        }
        return null;
    }
}

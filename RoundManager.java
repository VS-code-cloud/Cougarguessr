import java.util.*;

public class RoundManager {
    private List<LocationPoint> locations;
    private int currentIndex;

    public RoundManager() {
        locations = new ArrayList<>();
        currentIndex = 0;

        // TODO: ADD LOCATIONS
        locations.add(new LocationPoint(100, 200, "bottom", "images/hallway.jpg"));
        locations.add(new LocationPoint(250, 300, "top", "images/gym.jpg"));
        locations.add(new LocationPoint(400, 100, "bottom", "images/library.jpg"));

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

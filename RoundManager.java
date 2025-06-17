import java.util.*;

public class RoundManager {
    private List<LocationPoint> locations;
    private int currentIndex;
    private int round;
    private int score;
    private LocationPoint currLoc;
    private GameController gameController;
    public RoundManager(GameController g) {
        locations = new ArrayList<>();
        round=0;
        score=0;
        locations.add(new LocationPoint(297, 581, 0, "cougarguessr-photo/i1.jpeg"));
        locations.add(new LocationPoint(320, 582, 0, "cougarguessr-photo/i2.jpeg"));
        locations.add(new LocationPoint(318, 564, 0, "cougarguessr-photo/i3.jpeg"));
        locations.add(new LocationPoint(318, 537, 0, "cougarguessr-photo/i4.jpeg"));
        locations.add(new LocationPoint(256, 361, 1, "cougarguessr-photo/i27.jpeg"));
        locations.add(new LocationPoint(248, 345, 1, "cougarguessr-photo/i28.jpeg"));
        locations.add(new LocationPoint(251, 301, 1, "cougarguessr-photo/i29.jpeg"));
        locations.add(new LocationPoint(250, 266, 1, "cougarguessr-photo/i30.jpeg"));
        currentIndex = (int) (Math.random()*locations.size());
        
        gameController = g;
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
    public int getRound() {
        return round;
    }
    public int getScore() {
        return score;
    }
    public boolean hasNextRound() {
        return currentIndex < locations.size();
    }
    public void incrementRound() {
        round++;
    }
    public LocationPoint getCurrentLocation() {
        return currLoc;
    }
    public void updateWithGuess(int x, int y, int floor) {
        if (currLoc.getFloor()!=floor) {
            score+=Math.sqrt(540*540+720*720);
        } else {
            score+=Math.sqrt(Math.pow(x-currLoc.getX(), 2)+Math.pow(y-currLoc.getY(), 2));
        }
        if (round==5) {
            gameController.endGame();
        } else {
            gameController.startNewRound();
        }
        
    } 
    public LocationPoint getNextRound() {
        round++;
        if (hasNextRound()) {
            currentIndex = (int) (Math.random()*locations.size());
            currLoc = locations.get(currentIndex);
            return currLoc;
        }
        return null;
    }
}

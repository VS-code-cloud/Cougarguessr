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
        locations.add(new LocationPoint(350, 546, 0, "cougarguessr-photo/i5.jpeg"));
        locations.add(new LocationPoint(357, 546, 0, "cougarguessr-photo/i6.jpeg"));
        locations.add(new LocationPoint(406, 546, 0, "cougarguessr-photo/i7.jpeg"));
        locations.add(new LocationPoint(421, 540, 0, "cougarguessr-photo/i8.jpeg"));
        locations.add(new LocationPoint(427, 546, 0, "cougarguessr-photo/i9.jpeg"));
        locations.add(new LocationPoint(309, 541, 0, "cougarguessr-photo/i10.jpeg"));
        locations.add(new LocationPoint(323, 510, 0, "cougarguessr-photo/i11.jpeg"));
        locations.add(new LocationPoint(316, 442, 0, "cougarguessr-photo/i12.jpeg"));
        locations.add(new LocationPoint(348, 469, 0, "cougarguessr-photo/i13.jpeg"));
        locations.add(new LocationPoint(383, 470, 0, "cougarguessr-photo/i14.jpeg"));
        locations.add(new LocationPoint(307, 456, 0, "cougarguessr-photo/i15.jpeg"));
        locations.add(new LocationPoint(290, 454, 0, "cougarguessr-photo/i16.jpeg"));
        locations.add(new LocationPoint(274, 408, 0, "cougarguessr-photo/i17.jpeg"));
        locations.add(new LocationPoint(241, 449, 0, "cougarguessr-photo/i18.jpeg"));
        locations.add(new LocationPoint(229, 398, 0, "cougarguessr-photo/i19.jpeg"));
        locations.add(new LocationPoint(238, 377, 0, "cougarguessr-photo/i20.jpeg"));
        locations.add(new LocationPoint(227, 340, 0, "cougarguessr-photo/i21.jpeg"));
        locations.add(new LocationPoint(215, 311, 0, "cougarguessr-photo/i22.jpeg"));
        locations.add(new LocationPoint(208, 270, 0, "cougarguessr-photo/i23.jpeg"));
        locations.add(new LocationPoint(216, 248, 0, "cougarguessr-photo/i24.jpeg"));
        locations.add(new LocationPoint(207, 164, 0, "cougarguessr-photo/i25.jpeg"));
        locations.add(new LocationPoint(156, 335, 0, "cougarguessr-photo/i26.jpeg"));
        locations.add(new LocationPoint(256, 361, 1, "cougarguessr-photo/i27.jpeg"));
        locations.add(new LocationPoint(248, 345, 1, "cougarguessr-photo/i28.jpeg"));
        locations.add(new LocationPoint(251, 301, 1, "cougarguessr-photo/i29.jpeg"));
        locations.add(new LocationPoint(250, 266, 1, "cougarguessr-photo/i30.jpeg"));
        locations.add(new LocationPoint(253, 225, 1, "cougarguessr-photo/i31.jpeg"));
        locations.add(new LocationPoint(256, 201, 1, "cougarguessr-photo/i32.jpeg"));
        locations.add(new LocationPoint(257, 163, 1, "cougarguessr-photo/i33.jpeg"));
        locations.add(new LocationPoint(265, 386, 1, "cougarguessr-photo/i34.jpeg"));
        locations.add(new LocationPoint(282, 408, 1, "cougarguessr-photo/i35.jpeg"));
        locations.add(new LocationPoint(301, 468, 1, "cougarguessr-photo/i36.jpeg"));
        locations.add(new LocationPoint(313, 544, 1, "cougarguessr-photo/i37.jpeg"));
        locations.add(new LocationPoint(297, 549, 1, "cougarguessr-photo/i38.jpeg"));
        locations.add(new LocationPoint(296, 588, 1, "cougarguessr-photo/i39.jpeg"));
        locations.add(new LocationPoint(307, 636, 1, "cougarguessr-photo/i40.jpeg"));
        locations.add(new LocationPoint(287, 634, 1, "cougarguessr-photo/i41.jpeg"));
        locations.add(new LocationPoint(230, 637, 1, "cougarguessr-photo/i42.jpeg"));
        locations.add(new LocationPoint(185, 634, 1, "cougarguessr-photo/i43.jpeg"));
        locations.add(new LocationPoint(184, 606, 1, "cougarguessr-photo/i44.jpeg"));
        locations.add(new LocationPoint(186, 549, 1, "cougarguessr-photo/i45.jpeg"));
        locations.add(new LocationPoint(192, 493, 1, "cougarguessr-photo/i46.jpeg"));
        locations.add(new LocationPoint(164, 486, 1, "cougarguessr-photo/i47.jpeg"));
        locations.add(new LocationPoint(207, 494, 0, "cougarguessr-photo/i48.jpeg"));
        locations.add(new LocationPoint(188, 479, 0, "cougarguessr-photo/i49.jpeg"));
        locations.add(new LocationPoint(192, 531, 0, "cougarguessr-photo/i50.jpeg"));
        locations.add(new LocationPoint(195, 578, 0, "cougarguessr-photo/i51.jpeg"));
        locations.add(new LocationPoint(192, 619, 0, "cougarguessr-photo/i52.jpeg"));
        locations.add(new LocationPoint(220, 635, 0, "cougarguessr-photo/i53.jpeg"));
        locations.add(new LocationPoint(237, 633, 0, "cougarguessr-photo/i54.jpeg"));
        locations.add(new LocationPoint(277, 634, 0, "cougarguessr-photo/i55.jpeg"));
        locations.add(new LocationPoint(299, 605, 0, "cougarguessr-photo/i56.jpeg"));


        currentIndex = (int) (Math.random()*locations.size());;
        
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
            score+=0;
        } else {
            int bonus = 100;
            bonus-= Math.sqrt(Math.pow(x-currLoc.getX(), 2)+Math.pow(y-currLoc.getY(), 2));
            	if(bonus < 0)
            	{
            		bonus = 0;
            	}
        	score+=bonus;
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

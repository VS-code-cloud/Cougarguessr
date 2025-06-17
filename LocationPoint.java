public class LocationPoint {
    private int x;
    private int y;
    private int floor; 
    private String imagePath;

    public LocationPoint(int x, int y, int floor, String imagePath) {
        this.x = x;
        this.y = y;
        this.floor = floor;
        this.imagePath = imagePath;
    }

    public int getX() 
    { 
        return x; 
    }
    public int getY() 
    { 
        return y; 
    }
    public int getFloor() 
    { 
        return floor; 
    }
    public String getImagePath() 
    { 
        return imagePath; 
    }
}

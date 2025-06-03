public class LocationPoint {
    private int x;
    private int y;
    private String floor; 
    private String imagePath;

    public LocationPoint(int x, int y, String floor, String imagePath) {
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
    public String getFloor() 
    { 
        return floor; 
    }
    public String getImagePath() 
    { 
        return imagePath; 
    }
}

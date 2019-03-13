package mow.it.now.core;

public class TendeusePoint {
    
    private int                  x;
    private int                  y;
    private OrientationDirection orientation;
    
    /**
     * @param x
     * @param y
     */
    public TendeusePoint(int x, int y, OrientationDirection orientation) {
        super();
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
    
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public OrientationDirection getOrientation() {
        return orientation;
    }
    
    public void setOrientation(OrientationDirection orientation) {
        this.orientation = orientation;
    }
    
    public void AvanceX() {
        this.x++;
    }
    
    public void AvanceY() {
        this.y++;
    }
    
    public void ReturneX() {
        this.x--;
    }
    
    public void ReturneY() {
        this.y--;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orientation == null) ? 0 : orientation.hashCode());
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        TendeusePoint other = (TendeusePoint) obj;
        if (orientation != other.orientation) return false;
        if (x != other.x) return false;
        if (y != other.y) return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "TendeusePoint [x=" + x + ", y=" + y + ", orientation=" + orientation.toString()
            + "]";
    }
    
}

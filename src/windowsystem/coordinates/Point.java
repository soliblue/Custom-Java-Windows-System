package windowsystem.coordinates;

import windowsystem.contracts.IWindowSystem;

/**
 * Represents 2D point on windows system in relative to window system scale
 */
public class Point {
    private int x;
    private int y;

    /**
     * Initialises the point
     *
     * @param x                   absolute value of x coordinate of the point
     * @param y                   absolute value of y coordinate of the point
     */
    public Point(int x, int y) {
        this.x = x ;
        this.y = y ;
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
}
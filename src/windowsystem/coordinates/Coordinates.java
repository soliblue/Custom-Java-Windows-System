package windowsystem.coordinates;

/**
 * Represents 2D coordinates consisting of 2 points
 */
public class Coordinates {

    private Point startPoint;
    private Point endPoint;

    /**
     * Initializes coordinates
     *
     * @param startPoint starting point
     * @param endPoint   ending point
     */
    public Coordinates(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * Checks if point is inside given coordinate rectangle
     *
     * @param point point to check
     * @return true if point is inside, false otherwise
     */
    public boolean contains(Point point) {
        boolean contains = false;
        if (endPoint != null && startPoint != null) {
            if (getStartPoint().getX() < point.getX() && point.getX() < getEndPoint().getX() &&
                    getStartPoint().getY() < point.getY() && point.getY() < getEndPoint().getY()) {
                contains = true;
            }
        }
        return contains;
    }
}
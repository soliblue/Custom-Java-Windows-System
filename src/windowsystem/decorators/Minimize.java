package windowsystem.decorators;

import windowsystem.WindowComponent;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

/**
 * Concrete minimize window component
 */
public class Minimize extends MinimizeDecorator {
    public Minimize(WindowComponent simpleWindow, Color color, Color minimizedColor) {
        super(simpleWindow, color, minimizedColor);
    }

    /**
     * Draws itself
     */
    @Override
    public void draw() {
        if (!isMinimized()) {
            getSimpleWindow().draw();
            setCoordinates(new Coordinates(
                    new Point(
                            getSimpleWindow().getCoordinates().getEndPoint().getX() - 30,
                            getSimpleWindow().getCoordinates().getStartPoint().getY()),
                    new Point(
                            getSimpleWindow().getCoordinates().getEndPoint().getX() - 15,
                            getSimpleWindow().getCoordinates().getStartPoint().getY() + 15)));
            getWindowSystem().setColor(getColor());
            getWindowSystem().drawRect(getCoordinates());
            getWindowSystem().fillRect(getCoordinates());
        } else {
            Coordinates minimizeWindow = new Coordinates(
                    new Point( 50 * getId(), 550),
                    new Point( 50 * getId() + 50, 580)
            );
            setCoordinates(minimizeWindow);
            getWindowSystem().setColor(getMinimizedColor());
            getWindowSystem().drawRect(minimizeWindow);
            getWindowSystem().fillRect(minimizeWindow);
        }
    }

    /**
     * Minimizes or maximizes the window depending on current window state
     *
     * @param clickedPoint clicked point
     */
    @Override
    public void react(Point clickedPoint) {
        if (getCoordinates().contains(clickedPoint)) {
            if (isMinimized()) {
                setMinimized(false);
            } else {
                setMinimized(true);
            }
        } else {
            getSimpleWindow().react(clickedPoint);
        }
    }
}

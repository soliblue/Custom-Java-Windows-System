package windowsystem.decorators;

import windowsystem.*;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

/**
 * Concrete close window component
 */
public class Close extends CloseDecorator {
    public Close(WindowComponent windowComponent, Color color, Color crossColor) {
        super(windowComponent, color, crossColor);
    }

    /**
     * Draws itself
     */
    @Override
    public void draw() {
        getWindowComponent().draw();

        IWindowSystem ws = getWindowSystem();
        WindowComponent simpleWindow = getWindowComponent();
        // Adding close button to the window
        Point exitStartPoint = new windowsystem.coordinates.Point(simpleWindow.getCoordinates().getEndPoint().getX() - 15, simpleWindow.getCoordinates().getStartPoint().getY());
        windowsystem.coordinates.Point exitEndPoint = new windowsystem.coordinates.Point( simpleWindow.getCoordinates().getEndPoint().getX(), simpleWindow.getCoordinates().getStartPoint().getY() + 15);
        setCoordinates(new Coordinates(exitStartPoint, exitEndPoint));
        ws.setColor(getColor());
        ws.drawRect(getCoordinates());
        ws.fillRect(getCoordinates());

        //Add cross to the close button
        ws.setColor(getCrossColor());
        ws.drawLine(getCoordinates());
        Coordinates exitLineCoordinates = new Coordinates(
                new Point(getCoordinates().getStartPoint().getX(), getCoordinates().getStartPoint().getY() + 15),
                new Point(getCoordinates().getEndPoint().getX(), getCoordinates().getStartPoint().getY()));
        ws.drawLine(exitLineCoordinates);
    }

    /**
     * Closes the window
     *
     * @param point clicked point
     */
    @Override
    public void react(Point point) {
        if (getCoordinates().contains(point)) {
            getWindowSystem().removeWindow(getId());
        } else {
            getWindowComponent().react(point);
        }
    }

}

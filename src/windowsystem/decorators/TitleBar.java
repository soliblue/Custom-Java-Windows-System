package windowsystem.decorators;

import windowsystem.*;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Concrete title bar component
 */
public class TitleBar extends TitleBarDecorator {
    public TitleBar(WindowComponent simpleWindow, String title, Color color, Color activeColor, Color textColor) {
        super(simpleWindow, title, color, activeColor, textColor);
    }

    /**
     * Draws itself
     */
    @Override
    public void draw() {
        getWindowComponent().draw();

        IWindowSystem ws = getWindowComponent().getWindowSystem();

        Point titleStartPoint = new Point(
                getWindowComponent().getCoordinates().getStartPoint().getX(),
                getWindowComponent().getCoordinates().getStartPoint().getY() - 15);
        Point titleEndPoint = new Point(
                getWindowComponent().getCoordinates().getEndPoint().getX(),
                getWindowComponent().getCoordinates().getStartPoint().getY());
        setCoordinates(new Coordinates(titleStartPoint, titleEndPoint));

        //Set color of the title bar depending on state of the window (active/not active)
        if (getWindowComponent().getId() == (ws.getWindows().size())) {
            ws.setColor(getActiveColor());
        } else {
            ws.setColor(getColor());
        }
        ws.drawRect(getCoordinates());
        ws.fillRect(getCoordinates());

        ws.setColor(getTextColor());
        Point titleTextStartPoint = new Point(
                getCoordinates().getStartPoint().getX(),
                getCoordinates().getStartPoint().getY() + 10);
        ws.drawString(getTitle(), titleTextStartPoint);

    }

    /**
     * Drags the window
     *
     * @param clickedPoint clicked point
     * @param toMove       point to move
     */
    @Override
    public void react(Point clickedPoint, Point toMove) {
        if (getCoordinates().contains(clickedPoint)) {
            int newStartX = getWindowComponent().getCoordinates().getStartPoint().getX() + toMove.getX();
            int newStartY = getWindowComponent().getCoordinates().getStartPoint().getY() + toMove.getY();
            int newEndX = getWindowComponent().getCoordinates().getEndPoint().getX() + toMove.getX();
            int newEndY = getWindowComponent().getCoordinates().getEndPoint().getY() + toMove.getY();
            getWindowComponent().setCoordinates(new Coordinates(
                    new Point( newStartX, newStartY),
                    new Point( newEndX, newEndY)
            ));
        } else {
            getWindowComponent().react(clickedPoint, toMove);
        }
    }

    /**
     * Makes the clicked window active
     *
     * @param clickedPoint clicked point
     */
    @Override
    public void react(Point clickedPoint) {
        if (getCoordinates().contains(clickedPoint)) {
            List<WindowComponent> simpleWindows = new LinkedList<>(getWindowSystem().getWindows());
            getWindowSystem().getWindows().removeAll(simpleWindows);

            WindowComponent currentSimpleWindow = null;
            for (WindowComponent sw : simpleWindows) {
                if (sw.getId() == this.getId()) {
                    currentSimpleWindow = sw;
                } else {
                    getWindowSystem().addWindow(sw);
                }
            }
            getWindowSystem().addWindow(currentSimpleWindow);
        } else {
            getWindowComponent().react(clickedPoint);
        }
    }
}

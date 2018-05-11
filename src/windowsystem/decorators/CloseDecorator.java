package windowsystem.decorators;

import windowsystem.*;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

/**
 * Abstract decorator defining commonalities for any concrete close window component
 */
public abstract class CloseDecorator extends WindowComponent {
    private WindowComponent windowComponent;
    private Color crossColor;
    private Coordinates coordinates;
    private Color color;

    /**
     * Initializes close window component
     *
     * @param windowComponent window to decorate
     * @param color           color of close button
     * @param crossColor      color of cross on the button
     */
    public CloseDecorator(WindowComponent windowComponent, Color color, Color crossColor) {
        super(windowComponent.getWindowSystem());
        this.windowComponent = windowComponent;
        this.crossColor = crossColor;
        this.color = color;
    }

    public Color getCrossColor() {
        return crossColor;
    }

    public void setCrossColor(Color crossColor) {
        this.crossColor = crossColor;
    }

    public WindowComponent getWindowComponent() {
        return windowComponent;
    }

    @Override
    public int getId() {
        return getWindowComponent().getId();
    }

    @Override
    public void setId(int id) {
        getWindowComponent().setId(id);
    }

    /**
     * Passes coordinates to window component that decorates
     *
     * @param clickedPoint clicked point
     * @param toMove       point to move
     */
    @Override
    public void react(Point clickedPoint, Point toMove) {
        getWindowComponent().react(clickedPoint, toMove);
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

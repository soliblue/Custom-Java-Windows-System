package windowsystem.decorators;

import windowsystem.WindowComponent;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;

/**
 * Abstract decorator defining commonalities for any concrete minimize window component
 */
public abstract class MinimizeDecorator extends WindowComponent {
    private WindowComponent simpleWindow;
    private Color color;
    private Color minimizedColor;
    private boolean isMinimized;

    /**
     * Initizlizes minimize component
     *
     * @param simpleWindow   window to decorate
     * @param color          color of minimize button
     * @param minimizedColor color of window icon after window minimization
     */
    public MinimizeDecorator(WindowComponent simpleWindow, Color color, Color minimizedColor) {
        super(simpleWindow.getWindowSystem());
        this.simpleWindow = simpleWindow;
        this.color = color;
        this.minimizedColor = minimizedColor;
    }

    public WindowComponent getSimpleWindow() {
        return simpleWindow;
    }

    @Override
    public int getId() {
        return simpleWindow.getId();
    }

    @Override
    public void setId(int id) {
        simpleWindow.setId(id);
    }

    @Override
    abstract public void draw();

    /**
     * Passes coordinates to window component that decorates
     *
     * @param clickedPoint clicked point
     * @param toMove       point to move
     */
    @Override
    public void react(Point clickedPoint, Point toMove) {
        getSimpleWindow().react(clickedPoint, toMove);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isMinimized() {
        return isMinimized;
    }

    public void setMinimized(boolean minimized) {
        isMinimized = minimized;
    }

    public Color getMinimizedColor() {
        return minimizedColor;
    }

    public void setMinimizedColor(Color minimizedColor) {
        this.minimizedColor = minimizedColor;
    }
}

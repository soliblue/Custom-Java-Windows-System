package windowsystem;

import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

/**
 * Abstract window component defining commonalities
 */
public abstract class WindowComponent {
    private IWindowSystem windowSystem;
    private Coordinates coordinates;

    public WindowComponent(IWindowSystem windowSystem) {
        this.windowSystem = windowSystem;
    }

    abstract public int getId();

    abstract public void setId(int id);

    public IWindowSystem getWindowSystem() {
        return windowSystem;
    }

    public abstract void draw();

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    abstract public void react(Point clickedPoint);

    abstract public void react(Point clickedPoint, Point toMove);
}

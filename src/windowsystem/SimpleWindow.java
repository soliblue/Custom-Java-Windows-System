package windowsystem;

import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import windowsystem.rat.RATWidget;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * Window representation
 */
public class SimpleWindow extends WindowComponent {
    private int id;
    private Color color;
    private List<RATWidget> widgets;

    public SimpleWindow(IWindowSystem windowSystem, Coordinates coordinates, Color color) {
        super(windowSystem);
        widgets = new LinkedList<>();
        setCoordinates(coordinates);
        this.color = color;

    }

    public void draw() {
        getWindowSystem().setColor(getColor());
        getWindowSystem().drawRect(getCoordinates());
        getWindowSystem().fillRect(getCoordinates());

        for (RATWidget widget :
                widgets) {
            widget.draw();
        }
    }

    public void addWidget(RATWidget widget) {
        this.widgets.add(widget);
        widget.setSimpleWindow(this);
        getWindowSystem().requestRepaint();
    }

    @Override
    public void react(Point clickedPoint) {
        for (RATWidget widget :
                widgets) {
            if (widget.getCoordinates().contains(clickedPoint)) {
                widget.clicked();
            }
        }
    }

    @Override
    public void react(Point clickedPoint, Point toMove) {
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setCoordinates(Coordinates coordinates) {
        super.setCoordinates(coordinates);
        for (RATWidget widget :
                widgets) {
//            widget.
        }
    }
}

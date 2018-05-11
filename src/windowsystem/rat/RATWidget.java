package windowsystem.rat;

import windowsystem.SimpleWindow;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.util.LinkedList;
import java.util.List;

public abstract class RATWidget {
    private SimpleWindow simpleWindow;
    private List<RATMouseListener> listeners;
    private Coordinates windowSystemBasedCoordinates;

    public RATWidget(Point startingPoint) {
        this.windowSystemBasedCoordinates = new Coordinates(startingPoint, null);
        this.listeners = new LinkedList<>();
    }

    public void draw() {

    }

    public void addActionListener(RATMouseListener mouseListener) {
        listeners.add(mouseListener);
    }

    public void removeActionListener(RATMouseListener mouseListener) {
        listeners.remove(mouseListener);
    }

    public void notifyListeners(RATActionEvent ae) {
        for (RATMouseListener mouseListener :
                listeners) {
            mouseListener.mouseClicked(ae);
        }
    }
    
    public void clicked() {
        for (RATMouseListener listener :
                listeners) {
            listener.mouseClicked(null);
        }   
    }

    public SimpleWindow getSimpleWindow() {
        return simpleWindow;
    }

    public void setSimpleWindow(SimpleWindow simpleWindow) {
        this.simpleWindow = simpleWindow;
    }


    public Coordinates getCoordinates() {
        if (windowSystemBasedCoordinates == null) {
            throw new IllegalArgumentException("Coordinates object should be valid");
        }
        if (windowSystemBasedCoordinates.getStartPoint() == null) {
            throw new IllegalArgumentException("Coordinates object should be valid");
        }
        Coordinates simpleWindowBasedCoordinates = new Coordinates(new Point(
                windowSystemBasedCoordinates.getStartPoint().getX() + simpleWindow.getCoordinates().getStartPoint().getX(),
                windowSystemBasedCoordinates.getStartPoint().getY() + simpleWindow.getCoordinates().getStartPoint().getY()),
                null
        );

        simpleWindowBasedCoordinates.getStartPoint().setX(windowSystemBasedCoordinates.getStartPoint().getX() + simpleWindow.getCoordinates().getStartPoint().getX());
        simpleWindowBasedCoordinates.getStartPoint().setY(windowSystemBasedCoordinates.getStartPoint().getY() + simpleWindow.getCoordinates().getStartPoint().getY());
        if (windowSystemBasedCoordinates.getEndPoint() != null) {
            simpleWindowBasedCoordinates.setEndPoint(new Point(
                    windowSystemBasedCoordinates.getEndPoint().getX() + simpleWindow.getCoordinates().getStartPoint().getX(),
                    windowSystemBasedCoordinates.getEndPoint().getY() + simpleWindow.getCoordinates().getStartPoint().getY()
            ));
        }
        return simpleWindowBasedCoordinates;
    }

    public Coordinates getWindowSystemBasedCoordinates() {
        return windowSystemBasedCoordinates;
    }
}

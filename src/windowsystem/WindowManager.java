package windowsystem;

import windowsystem.contracts.IWindowManager;
import windowsystem.contracts.IWindowSystem;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import windowsystem.decorators.Close;
import windowsystem.decorators.Minimize;
import windowsystem.decorators.TitleBar;

import java.awt.*;

/**
 * Window manager
 */
public class WindowManager implements IWindowManager {
    private IWindowSystem windowSystem;

    /**
     * Initializes window manager
     */
    public WindowManager(WindowSystem windowSystem) {
        this.windowSystem = windowSystem;
    }

    /**
     * Handles mouse click
     *
     * @param point point where mouse was clicked
     */
    @Override
    public void handleMouseClicked(Point point) {
        for (int i = 0; i < windowSystem.getWindows().size(); i++) {
            windowSystem.getWindows().get(i).react(point);
        }
    }

    /**
     * Handles mouse dragging
     *
     * @param clickedPoint clicked point
     * @param toMove       point to move
     */
    @Override
    public void handleMouseDragged(Point clickedPoint, Point toMove) {
        if (windowSystem.getWindows().size() > 0) {
            windowSystem.getWindows().get(windowSystem.getWindows().size() - 1).react(clickedPoint, toMove);
        }
    }

    @Override
    public WindowComponent decorateWindow(SimpleWindow simpleWindow, String title) {
        simpleWindow.setColor(Color.BLACK);
        WindowComponent decoratedSimpleWindow = new Minimize(
                new Close(
                        new TitleBar(
                                simpleWindow,
                                title, Color.WHITE, Color.CYAN, Color.BLACK),
                        Color.RED, Color.BLACK), Color.GREEN, Color.YELLOW);
        return decoratedSimpleWindow;
    }
}

package windowsystem.contracts;

import windowsystem.SimpleWindow;
import windowsystem.WindowComponent;
import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;

import java.awt.*;
import java.util.List;

/**
 * Contract for window system
 */
public interface IWindowSystem {
    void setColor(Color color);

    void drawRect(Coordinates coordinates);

    void fillRect(Coordinates coordinates);

    List<WindowComponent> getWindows();

    int getHeight();

    int getWidth();

    void drawString(String string, Point point);

    void drawLine(Coordinates coordinates);

    void removeWindow(int id);

    SimpleWindow addWindow(int width, int height, String title);

    void addWindow(WindowComponent windowComponent);

    void requestRepaint();
}

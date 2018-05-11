package windowsystem.decorators;

import windowsystem.WindowComponent;
import windowsystem.coordinates.Coordinates;

import java.awt.*;

/**
 * Abstract decorator defining commonalities for any concrete title bar window component
 */
public abstract class TitleBarDecorator extends WindowComponent {
    private WindowComponent windowComponent;
    private String title;
    private Color textColor;
    private Color activeColor;
    private Color color;
    private Coordinates coordinates;

    /**
     * Initializes title bar
     *
     * @param windowComponent window component to decorate
     * @param title           title text
     * @param color           color of title bar
     * @param activeColor     color of active window title bar
     * @param textColor       color of text on the title bar
     */
    public TitleBarDecorator(WindowComponent windowComponent, String title, Color color, Color activeColor, Color textColor) {
        super(windowComponent.getWindowSystem());
        this.windowComponent = windowComponent;
        this.title = title;
        this.color = color;
        this.activeColor = activeColor;
        this.textColor = textColor;
    }

    public WindowComponent getWindowComponent() {
        return windowComponent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public Color getActiveColor() {
        return activeColor;
    }

    public void setActiveColor(Color activeColor) {
        this.activeColor = activeColor;
    }

    @Override
    public int getId() {
        return getWindowComponent().getId();
    }

    @Override
    public void setId(int id) {
        getWindowComponent().setId(id);
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

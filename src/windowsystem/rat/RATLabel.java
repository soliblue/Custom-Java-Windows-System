package windowsystem.rat;

import windowsystem.coordinates.Point;

import java.awt.*;

public class RATLabel extends RATWidget {
    private String text;
    private Color textColor;

    public RATLabel(Point startingPoint, String text, Color textColor) {
        super(startingPoint);
        this.textColor = textColor;
        this.text = text;
    }

    @Override
    public void draw() {
        super.draw();
        getSimpleWindow().getWindowSystem().setColor(textColor);
        getSimpleWindow().getWindowSystem().drawString(text, new Point(getCoordinates().getStartPoint().getX()+3,getCoordinates().getStartPoint().getY()+15));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

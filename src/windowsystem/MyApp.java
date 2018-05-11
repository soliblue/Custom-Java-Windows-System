package windowsystem;

import windowsystem.coordinates.Coordinates;
import windowsystem.coordinates.Point;
import windowsystem.rat.RATButton;
import windowsystem.rat.RATLabel;
import windowsystem.rat.RATTextField;
import windowsystem.rat.RATWidget;

import java.awt.*;

/**
 * Our main app to test window system
 */
public class MyApp {

    public static void main(String[] args) {
        WindowSystem ws = new WindowSystem(600, 600, Color.PINK);
        ws.setWindowManager(new WindowManager(ws));

        SimpleWindow window1 = ws.addWindow(250, 250, "Window 1");
        SimpleWindow window2 = ws.addWindow(250, 250, "Window 2");
        SimpleWindow window3 = ws.addWindow(250, 250, "Window 3");

        RATButton button = new RATButton(new Point(5,5), "Click!", Color.LIGHT_GRAY, Color.WHITE, Color.BLACK);
        RATButton button2 = new RATButton(new Point(5, 35), "Hello", Color.LIGHT_GRAY, Color.WHITE, Color.BLACK);
        String myString = "Hi, guys!";
        RATTextField textField = new RATTextField(new Point(5, 75),myString,Color.WHITE, Color.CYAN, Color.BLACK);

        button.addActionListener((ae) -> {
            textField.setText("Peeeep");
        });

        window1.addWidget(button);
        window1.addWidget(button2);
        window1.addWidget(textField);

        RATButton button3 = new RATButton(new Point(5,5), "Click!", Color.LIGHT_GRAY, Color.WHITE, Color.BLACK);

        window2.addWidget(button3);

        RATLabel label = new RATLabel(new Point(5,5), "Just Label", Color.GREEN);
        window3.addWidget(label);



        // Expert Program: Calculator

        // Creating the calculator window
        SimpleWindow calculatorWindow = ws.addWindow(200, 300, "Calculator");
        // Attach the calculator to the window;
        Calculator calculator = new Calculator(calculatorWindow);
    }
}

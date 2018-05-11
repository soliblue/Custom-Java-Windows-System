package windowsystem;

import windowsystem.coordinates.Point;
import windowsystem.rat.RATButton;
import windowsystem.rat.RATLabel;
import windowsystem.rat.RATTextField;

import javax.xml.crypto.dsig.SignatureMethod;
import java.awt.*;

public class Calculator {
    private double result;
    private String chosenAction;

    private double chosenNumber;
    private boolean enteringNumber;
    private boolean entertingDecimal;

    private RATTextField resultField;

    public Calculator(SimpleWindow calculatorWindow){
        initNumberButtons(calculatorWindow);
        initActionButtons(calculatorWindow);

        addResultField(calculatorWindow);
        addDecimalAction(calculatorWindow);
        addResultAction(calculatorWindow);
        addCancelAction(calculatorWindow);
        addNegativeAction(calculatorWindow);

        setEnteringNumber(false);
        setEntertingDecimal(false);
        setChosenNumber(0);
        setResult(0);
        setChosenAction("+");
    }

    private void initNumberButtons(SimpleWindow calculatorWindow){
        calculatorWindow.setColor(Color.WHITE);
        // Init all integer buttons
        int [] integers = {0,1,2,3,4,5,6,7,8,9};
        for (int integer : integers) {
            // Create button
            RATButton integerButton = new RATButton(new Point((integer % 3) * 50,Math.floorDiv(integer,3) * 30 +100),
                    Integer.toString(integer),Color.BLUE,Color.WHITE,Color.WHITE);
            // Add button to widget
            integerButton.addActionListener((ae) -> {
                if (isEnteringNumber()){
                    int floorChosenNumber = (int) Math.floor(getChosenNumber());
                    if (isEntertingDecimal()){
                        setChosenNumber(Double.parseDouble(String.valueOf(floorChosenNumber) + "." +  integerButton.getText()));
                        setEntertingDecimal(false);
                    } else {
                        if (floorChosenNumber == getChosenNumber()){
                            setChosenNumber(Double.parseDouble(String.valueOf(floorChosenNumber) + integerButton.getText()));
                        } else {
                            setChosenNumber(Double.parseDouble(String.valueOf(getChosenNumber()) + integerButton.getText()));
                        }
                    }
                } else {
                    setChosenNumber(Integer.parseInt(integerButton.getText()));
                    setEnteringNumber(true);
                }
                displayNumber(getChosenNumber());
                System.out.println("Integer: " + integerButton.getText() + " pressed -- " + getChosenNumber());
            });
            calculatorWindow.addWidget(integerButton);
        }
    }

    private void initActionButtons(SimpleWindow calculatorWindow){
        // Init all mathematical actions
        String [] actions = {"*","+","-","/","%"};
        for(int iteration = 0;iteration < actions.length;iteration++){
            RATButton actionButton;
            actionButton = new RATButton(new Point(3 * 50,iteration * 30 + 100),
                    actions[iteration],Color.GREEN,Color.WHITE,Color.black);
            actionButton.addActionListener((ae) -> {
                setEnteringNumber(false);
                setChosenAction(actionButton.getText());
                if (getResult() != 0) {
                    setResult(calculateResult());
                } else {
                    setResult(getChosenNumber());
                }
                System.out.println("Action: " + actionButton.getText() + " performed.");
            });
            calculatorWindow.addWidget(actionButton);
        }

    }

    private void addResultField(SimpleWindow calculatorWindow){
        // Add field for displaying results
        setResultField(new RATTextField(new Point(40, 50),"",Color.WHITE, Color.CYAN, Color.BLACK));
        calculatorWindow.addWidget(getResultField());
    }

    private void addDecimalAction(SimpleWindow calculatorWindow){
        RATButton actionButton =  new RATButton(new Point(1 * 50,3 * 30 +100),
                ".",Color.ORANGE,Color.WHITE,Color.black);
        actionButton.addActionListener((ae) -> {
            setEntertingDecimal(true);
            System.out.println("Action: " + actionButton.getText() + " performed.");
        });
        calculatorWindow.addWidget(actionButton);

    }

    private void addResultAction(SimpleWindow calculatorWindow){
        RATButton actionButton =  new RATButton(new Point(2 * 50,3 * 30 +100),
                "=",Color.LIGHT_GRAY,Color.WHITE,Color.WHITE);
        actionButton.addActionListener((ae) -> {
            setResult(calculateResult());
            displayNumber(getResult());
            setResult(0);
            setChosenNumber(0);
            setEnteringNumber(false);
            System.out.println("Action: " + actionButton.getText() + " performed.");
        });
        calculatorWindow.addWidget(actionButton);
    };

    private void addCancelAction(SimpleWindow calculatorWindow){
        RATButton actionButton =  new RATButton(new Point(0 * 50,4 * 30 +100),
                "AC",Color.RED,Color.WHITE,Color.WHITE);
        actionButton.addActionListener((ae) -> {
            setResult(0);
            setChosenNumber(0);
            setEnteringNumber(false);
            setEntertingDecimal(false);
            displayNumber(getResult());
            System.out.println("Action: " + actionButton.getText() + " performed.");
        });
        calculatorWindow.addWidget(actionButton);
    };

    private void addNegativeAction(SimpleWindow calculatorWindow){
        RATButton actionButton =  new RATButton(new Point(1 * 50,4 * 30 +100),
                " * (-1)",Color.BLACK,Color.WHITE,Color.WHITE);
        actionButton.addActionListener((ae) -> {
            if (isEnteringNumber()){
                setChosenNumber(getChosenNumber() * -1);
                displayNumber(getChosenNumber());
            } else {
                setResult(getResult() * -1);
                displayNumber(getResult());
            }
            System.out.println("Action: " + actionButton.getText() + " performed.");
        });
        calculatorWindow.addWidget(actionButton);
    }

    private double calculateResult(){
        double result;
        switch (getChosenAction()){
            case "+":
                result = getResult() + getChosenNumber();
                break;
            case "-":
                result = getResult() - getChosenNumber();
                break;
            case "/":
                result = getResult() / getChosenNumber();
                break;
            case "%":
                result = getResult() % getChosenNumber();
                break;
            default:
                result = getResult() * getChosenNumber();
        }
        return result;
    }

    public void displayNumber(double number){
        getResultField().setText(Double.toString(number));
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }


    public String getChosenAction() {
        return chosenAction;
    }

    public void setChosenAction(String chosenAction) {
        this.chosenAction = chosenAction;
    }

    public boolean isEnteringNumber() {
        return enteringNumber;
    }

    public void setEnteringNumber(boolean enteringNumber) {
        this.enteringNumber = enteringNumber;
    }

    public boolean isEntertingDecimal() {
        return entertingDecimal;
    }

    public void setEntertingDecimal(boolean entertingDecimal) {
        this.entertingDecimal = entertingDecimal;
    }

    public double getChosenNumber() {
        return chosenNumber;
    }

    public void setChosenNumber(double chosenNumber) {
        this.chosenNumber = chosenNumber;
    }


    public RATTextField getResultField() {
        return resultField;
    }

    public void setResultField(RATTextField resultField) {
        this.resultField = resultField;
    }
}
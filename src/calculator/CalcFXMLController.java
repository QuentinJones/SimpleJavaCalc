/*Author: Quentin Jones
CLID: qej4373
Class:  CMPS 360
Assignment: project­1
Due Date: 10/26/14 11:55pm
Description: A simple calculator for integer operations.
*/


package calculator;


import java.math.BigInteger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/** Defines event handling actions for the calculator
*/
public class CalcFXMLController implements Initializable {
    
    private final BigInteger zero = new BigInteger("0"); //Always 0 for clearing input
    private BigInteger result = null; //Holds the current result of most recent calculation
    private BigInteger currentInput = new BigInteger("0"); //Holds the value of current input
    private final BigInteger multiplier = new BigInteger("10"); //Multiplier for input changes
    private boolean lastActionOperator = false; // Flag for determining if the last button input was an operator
    private boolean firstInput = true; // Flag for determining if there was previous input
    private enum Operator {none, plus, minus, times, divide}; // Available operators
    private Operator lastOperator = Operator.none; // Holds the last operator entered
    
    @FXML
    private TextField inputField; //Text field for displaying input and results
    @FXML
    private Button button0; //Button for entering 0
    @FXML
    private Button button1;//Button for entering 1
    @FXML
    private Button button2;//Button for entering 2
    @FXML
    private Button button3;//Button for entering 3
    @FXML
    private Button button4;//Button for entering 4
    @FXML
    private Button button5;//Button for entering 5
    @FXML
    private Button button6;//Button for entering 6
    @FXML
    private Button button7;//Button for entering 7
    @FXML
    private Button button8;//Button for entering 8
    @FXML
    private Button button9;//Button for entering 9
    @FXML
    private Button buttonPlus;//Button for entering plus operation
    @FXML
    private Button buttonMinus;//Button for entering minus operation
    @FXML
    private Button buttonMult;//Button for entering multiplication operation
    @FXML
    private Button buttonDivision;//Button for entering division operation
    @FXML
    private Button buttonEquals;//Button for entering equals operation
    @FXML
    private Button buttonClear;//Button for entering clear operation
    @FXML
    private MenuItem menuClose; // Menu selection to exit program
    
    // Handles button press inputs from the GUI
    @FXML
    private void handleButtonPressed(ActionEvent event) {
        Object current = event.getSource();
        
        if (current instanceof Button){
            Button b = (Button)current;
            String currentLabel = b.getText();
            switch (b.getText()) {
                case "0" :
                    setInputField(currentLabel);
                    break;
                case "1":
                    setInputField(currentLabel);
                    break;
                case "2" :
                    setInputField(currentLabel);
                    break; 
                case "3" :
                    setInputField(currentLabel);
                    break;
                case "4" :
                    setInputField(currentLabel);
                    break; 
                case "5" :
                    setInputField(currentLabel);
                    break;
                case "6" :
                    setInputField(currentLabel);
                    break; 
                case "7" :
                    setInputField(currentLabel);
                    break;
                case "8" :
                    setInputField(currentLabel);
                    break; 
                case "9" :
                    setInputField(currentLabel);
                    break;                    
                case "+" :
                    lastOperator = Operator.plus;
                    handleOperator();
                    break; 
                case "-" :
                    lastOperator = Operator.minus;
                    handleOperator();
                    break;
                case "*" :                    
                    lastOperator = Operator.times;
                    handleOperator();
                    break; 
                case "/" :
                    lastOperator = Operator.divide;
                    handleOperator();
                    break;
                case "=" :
                    calculate(result, currentInput);
                    lastOperator = Operator.none;
                    lastActionOperator = false;

                    break;
                case "Clr" : 
                    firstInput = true;
                    lastActionOperator = false;
                    lastOperator = Operator.none;
                    result = null;
                    currentInput = zero;
                    inputField.setText("0");
                    break;
            }
            System.out.println("R: " + result + " C: " + currentInput + " Op: " + lastOperator + lastActionOperator + firstInput);
        }
        else if (current instanceof MenuItem){
            MenuItem m = (MenuItem)current;
            if (m.getText().equals(menuClose.getText())){
                System.exit(0);
            }
        }
    }
     // Helper for handling operator actions from buttons
    private void handleOperator () {
        if (!firstInput){ //do nothing if no input was previously entered
            if (lastActionOperator == false){
               lastActionOperator = true;
               calculate(result, currentInput);
            }
            else {lastActionOperator = true;}
            
        }
    }

    // Handle keyboard input by passing events to appropriate buttons
    @FXML
    private void handleKeyPress(KeyEvent key) {
        KeyCode ke = key.getCode();
        switch (ke) {
            case DIGIT1 :
            case NUMPAD1 :
                button1.fire();
                button1.requestFocus();
                break;
            case DIGIT2 :
            case NUMPAD2 :
                button2.fire();
                button2.requestFocus();
                break;
            case DIGIT3 :
            case NUMPAD3 :
                button3.fire();
                button3.requestFocus();
                break;
            case DIGIT4 :
            case NUMPAD4 :
                button4.fire();
                button4.requestFocus();
                break;
            case DIGIT5 :
            case NUMPAD5 :
                button5.fire();
                button5.requestFocus();
                break;
            case DIGIT6 :
            case NUMPAD6 :
                button6.fire();
                button6.requestFocus();
                break;
            case DIGIT7 :
            case NUMPAD7 :
                button7.fire();
                button7.requestFocus();
                break;
            case DIGIT8 :
            case NUMPAD8 :
                button8.fire();
                button8.requestFocus();
                break;
            case DIGIT9 :
            case NUMPAD9 :
                button9.fire();
                button9.requestFocus();
                break;
            case DIGIT0 :
            case NUMPAD0 :
                button0.fire();
                button0.requestFocus();
                break;
            case BACK_SPACE :
                buttonClear.fire();
                buttonClear.requestFocus();
                break;
            case ADD :
                buttonPlus.fire();
                buttonPlus.requestFocus();
                break;
            case MULTIPLY :
                buttonMult.fire();
                buttonMult.requestFocus();
                break;
            case EQUALS :
            case ENTER :
                buttonEquals.fire();
                buttonEquals.requestFocus();
                break;
            default:
                //System.out.println(key.getText());
        }
        if (ke.isWhitespaceKey()){
            buttonEquals.requestFocus();
            buttonEquals.fire();
        }
        if (null != key.getText())switch (key.getText()) {
            case "/":
                buttonDivision.fire();
                buttonDivision.requestFocus();
                break;
            case "-":
                buttonMinus.fire();
                buttonMinus.requestFocus();
                break;
            case "+":
                buttonPlus.fire();
                buttonPlus.requestFocus();
                break;
            case "*":
                buttonMult.fire();
                buttonMult.requestFocus();
                break;
        }
    }
    
    // Helper function, changes the input text field
    private void setInputField(String currentValue) {
        if (firstInput)
             firstInput = false;
        if (lastActionOperator == false) {
            currentInput = currentInput.multiply(multiplier).add(new BigInteger(currentValue));
        }
        else {
            lastActionOperator = false;
            currentInput = zero.add(new BigInteger(currentValue));
        }
        inputField.setText(String.valueOf(currentInput));
    }
    
    // Does calculations using current input
    private void calculate(BigInteger a, BigInteger b){
        if (result != null) {
            switch (lastOperator) {
                case plus:
                    result = a.add(b); break;
                case minus:
                    result = a.subtract(b); break;
                case times:
                    result = a.multiply(b); break;
                case divide:
                    try {
                        result = a.divide(b);
                    }
                    catch (ArithmeticException e) {
                            System.out.println("Division by zero detected");
                            buttonClear.fire();
                            }
                    finally { break;}
                case none : break;
                default:
                        System.out.println("Invalid Operator");
            }
        }
        else {
            result = currentInput;
        }
        if (result != null)
            inputField.setText(result.toString());
    }
    
    /**
    Perform initialization of interface
     * @param url 
     * @param rb 
    */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}

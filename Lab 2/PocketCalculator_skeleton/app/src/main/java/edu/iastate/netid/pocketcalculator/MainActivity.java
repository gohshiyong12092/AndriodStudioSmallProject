package edu.iastate.netid.pocketcalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    /**
     * The instance of the calculator model for use by this controller.
     */
    private final CalculationStream mCalculationStream = new CalculationStream();

    /*
     * The instance of the calculator display TextView. You can use this to update the calculator display.
     */
    private TextView mCalculatorDisplay;
    //Button
    Button button_0, button_1,button_2, button_3, button_4, button_5, button_6,button_7, button_8,
    button_9, button_mul, button_div, button_add, button_minus, button_equal, button_clr, button_dot;
    //flag for equal button
    private boolean flag_equal = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TODO - uncomment the below line after you make your layout. This line locates
           the instance of the calculator display's TextView.  You need to create this TextView
           and set its ID to CalculatorDisplay in your layout resource file.
         */
        button_0 = findViewById(R.id.zero_Button);
        button_1 = findViewById(R.id.One_Button);
        button_2 = findViewById(R.id.Two_Button);
        button_3 = findViewById(R.id.Three_Button);
        button_4 = findViewById(R.id.four_Button);
        button_5 = findViewById(R.id.Five_Button);
        button_6 = findViewById(R.id.six_Button);
        button_7 = findViewById(R.id.seven_Button);
        button_8 = findViewById(R.id.eight_Button);
        button_9 = findViewById(R.id.nine_Button);
        button_mul = findViewById(R.id.multiply_Button);
        button_add = findViewById(R.id.add_Button);
        button_div = findViewById(R.id.divide_Button);
        button_minus = findViewById(R.id.minus_Button);
        button_equal = findViewById(R.id.equal_Button);
        button_dot = findViewById(R.id.dot_Button);
        button_clr = findViewById(R.id.Clear_Button);


        mCalculatorDisplay = findViewById(R.id.CalculatorDisplay);
    }

    /* TODO - add event listeners for your calculator's buttons. See the model's API to figure out
       what methods should be called. The equals button event listener has been done for you. Once
       you've created the layout, you'll need to add these methods as the onClick() listeners
       for the corresponding buttons in the XML layout. */

    public void onEqualClicked(View view) {
        try {
            mCalculationStream.calculateResult();
        } finally {
            updateCalculatorDisplay();
            flag_equal = true;
        }
    }

    public void onDigit_1Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.ONE);
        if(flag_equal) {
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "1");
        flag_equal = false;
    }

    public void onDigit_2Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.TWO);
        if(flag_equal){
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "2");
        flag_equal = false;
    }

    public void onDigit_3Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.THREE);
        if(flag_equal) {
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "3");
        flag_equal = false;
    }

    public void onDigit_4Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.FOUR);
        if(flag_equal){
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "4");
        flag_equal = false;
    }

    public void onDigit_5Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.FIVE);
        if(flag_equal){
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "5");
        flag_equal = false;
    }
    public void onDigit_6Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.SIX);
        if(flag_equal) {
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "6");
        flag_equal = false;
    }
    public void onDigit_7Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.SEVEN);
        if(flag_equal){
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "7");
        flag_equal = false;
    }
    public void onDigit_8Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.EIGHT);
        if(flag_equal) {
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "8");
        flag_equal = false;
    }
    public void onDigit_9Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.NINE);
        if(flag_equal) {
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "9");
        flag_equal = false;
    }
    public void onDigit_0Clicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.ZERO);
        if(flag_equal) {
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "0");
        flag_equal = false;
    }
    public void onDigit_dotClicked(View view) {
        mCalculationStream.inputDigit(CalculationStream.Digit.DECIMAL);
        if(flag_equal) {
            mCalculatorDisplay.setText("");
            mCalculationStream.clear();
        }
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + ".");
        flag_equal = false;
    }
    public void onOperator_MulClicked(View view) {
        mCalculationStream.inputOperation(CalculationStream.Operation.MULTIPLY);
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "*");
        flag_equal = false;
    }
    public void onOperator_AddClicked(View view) {
        mCalculationStream.inputOperation(CalculationStream.Operation.ADD);
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "+");
        flag_equal = false;
    }
    public void onOperator_SubClicked(View view) {
        mCalculationStream.inputOperation(CalculationStream.Operation.SUBTRACT);
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "-");
        flag_equal = false;
    }
    public void onOperator_DivideClicked(View view) {
        mCalculationStream.inputOperation(CalculationStream.Operation.DIVIDE);
        String text = (String) mCalculatorDisplay.getText();
        mCalculatorDisplay.setText(text + "/");
        flag_equal = false;
    }
    public void onClear_Clicked(View view) {
        flag_equal = false;
        mCalculationStream.clear();
        mCalculatorDisplay.setText("");
    }
    /**
     * Call this method after every button press to update the text display of your calculator.
     */
    public void updateCalculatorDisplay() {
        String value = getString(R.string.empty);
        try {
            value = Double.toString(mCalculationStream.getCurrentOperand());
        } catch(NumberFormatException e) {
            value = getString(R.string.error);
        } finally {
            // TODO: this value may need to be formatted first so it fits on one line... try 0.8 - 0.2
            DecimalFormat df = new DecimalFormat("###.###");
            Double double_val = Double.parseDouble(value);
            value = df.format(double_val);
            if(value.length() > 10){
                mCalculatorDisplay.setText("Error");
                return;
            }
            mCalculatorDisplay.setText(value);
        }
    }
}

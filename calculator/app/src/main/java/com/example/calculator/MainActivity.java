package com.example.calculator;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;


import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final char ADDITION = '+';
    private static final char SUBSTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char PERCENT = '%';
    private char currentSymbol;


    private Double firstValue = Double.NaN;
    private Double secondValue;
    private TextView inputDisplay , outputDisplay;
    private DecimalFormat decimalFormat;
    private MaterialButton button0 , button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonDot, buttonAdd, buttonSub,  buttonMultply, buttonDivide,  buttonPercent, buttonClear, buttonOFF, buttonEqual;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##########");

        inputDisplay =findViewById(R.id.input);
        outputDisplay=findViewById(R.id.output);

        button0 = findViewById(R.id.btn0);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        button5 = findViewById(R.id.btn5);
        button6 = findViewById(R.id.btn6);
        button7 = findViewById(R.id.btn7);
        button8 = findViewById(R.id.btn8);
        button9 = findViewById(R.id.btn9);

        buttonAdd=findViewById(R.id.add);
        buttonSub=findViewById(R.id.subtract);
        buttonMultply=findViewById(R.id.multiply);
        buttonClear=findViewById(R.id.clear);
        buttonDivide=findViewById(R.id.division);
        buttonDot=findViewById(R.id.btnPoint);
        buttonEqual=findViewById(R.id.equal);
        buttonOFF=findViewById(R.id.off);
        buttonPercent=findViewById(R.id.percent);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"0");
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"7");
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"8");
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() +"9");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = ADDITION;
                inputDisplay.setText(decimalFormat.format(firstValue) + "+");
                inputDisplay.setText(null);

            }


        });
        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = SUBSTRACTION;
                inputDisplay.setText(decimalFormat.format(firstValue) + "-");
                inputDisplay.setText(null);

            }


        });
        buttonMultply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = MULTIPLICATION;
                inputDisplay.setText(decimalFormat.format(firstValue) + "*");
                inputDisplay.setText(null);

            }


        });
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = DIVISION;
                inputDisplay.setText(decimalFormat.format(firstValue) + "/");
                inputDisplay.setText(null);

            }


        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                currentSymbol = PERCENT;
                inputDisplay.setText(decimalFormat.format(firstValue) + "%");
                inputDisplay.setText(null);

            }


        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputDisplay.setText(inputDisplay.getText() + ".");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputDisplay.getText().length()>0){
                    CharSequence currentText = inputDisplay.getText();
                    inputDisplay.setText(currentText.subSequence(0,currentText.length() -1));
                }else{
                    firstValue = Double.NaN;
                    secondValue= Double.NaN;
                    inputDisplay.setText("");
                    outputDisplay.setText("");
                }
            }
        });
        buttonOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allCalculations();
                outputDisplay.setText(decimalFormat.format(firstValue));
                firstValue =  Double.NaN;
                currentSymbol='0';
            }
        });


    }
    private void allCalculations(){
        if(!Double.isNaN(firstValue)){
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);

            if(currentSymbol == ADDITION)
                firstValue = this.firstValue + secondValue ;
            else if (currentSymbol == SUBSTRACTION)
                firstValue = this.firstValue - secondValue ;
            else if (currentSymbol == MULTIPLICATION)
                firstValue = this.firstValue * secondValue;
            else if (currentSymbol == DIVISION)
                firstValue = this.firstValue / secondValue;
            else if (currentSymbol == PERCENT)
                firstValue = this.firstValue % secondValue;


        } else {
            try{
                firstValue = Double.parseDouble(inputDisplay.getText().toString());
            }catch(Exception e){

            }
        }
    }
}
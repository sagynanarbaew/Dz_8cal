package com.example.dz_8cal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String emptyString = "";

    private static  final String zeroString = "0";

    private Button[] buttonsNumber, buttonOperation;

    private Button buttonEqual;

    private TextView tvResult;

    private String  firstNumber , secondNumber, number ,result;

    private OperationStatus operationStatus = OperationStatus.DEFAULT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        funFindViewByiD();
        funNumber(buttonsNumber);
        funOperation(buttonOperation);
        funEqual();

    }

    private void funEqual() {
        buttonEqual.setOnClickListener(v -> {
            secondNumber = tvResult.getText().toString();
            switch (operationStatus) {
                case PLUS:
                    result = String.valueOf(Integer.parseInt(firstNumber));
                    break;
                case DIVIDE:
                    result = String.valueOf(Integer.parseInt(firstNumber));
                    break;
                case SUBTRACT:
                    result = String.valueOf(Integer.parseInt(firstNumber));
                    break;
                case MULTIPLY:
                    result = String.valueOf(Integer.parseInt(firstNumber));
                    break;
                case DEFAULT:
                    break;
            }

            tvResult.setText(result);
            firstNumber = emptyString;
            secondNumber = emptyString;
            operationStatus = OperationStatus.DEFAULT;
        });

    }

    @SuppressLint("NonConstantResourceId")
    private void funOperation(Button[] buttonOperation) {
        for (Button item : buttonOperation) {
            item.setOnClickListener(v -> {
                firstNumber = tvResult.getText().toString();
                tvResult.setText(zeroString);

                switch (item.getId()) {
                    case R.id.btr_plus:
                        operationStatus = OperationStatus.PLUS;
                    case R.id.btr_minus:
                        operationStatus = OperationStatus.SUBTRACT;
                    case R.id.btr_divide:
                        operationStatus = OperationStatus.DIVIDE;
                    case R.id.btr_multiply:
                        operationStatus = OperationStatus.MULTIPLY;
                    case R.id.btr_remove:
                        operationStatus = OperationStatus.DEFAULT;

                }
            });
        }

    }

    @SuppressLint("SetTextI18n")
    private void funNumber(Button[] buttonsNumber) {
        for (Button item : buttonsNumber) {
            item.setOnClickListener(v -> {
                if (tvResult.getText().toString().equals(zeroString))
                    tvResult.setText(item.getText());
                else tvResult.setText(tvResult.getText().toString() + item.getText());
            });
        }
    }


    private void funFindViewByiD() {
        buttonOperation = new Button[]{
                findViewById(R.id.btr_plus),
                findViewById(R.id.btr_minus),
                findViewById(R.id.btr_multiply),
                findViewById(R.id.btr_divide),
                findViewById(R.id.btr_remove),
        };


        buttonsNumber = new Button[]{
                findViewById(R.id.btr_Zero), findViewById(R.id.btr_one), findViewById(R.id.btr_twe),
                findViewById(R.id.btr_three), findViewById(R.id.btr_four), findViewById(R.id.btr_five),
                findViewById(R.id.btr_six), findViewById(R.id.btr_Seven), findViewById(R.id.btr_Eight),
                findViewById(R.id.btr_nine),
        };
        buttonEqual = findViewById(R.id.btr_equal);
        tvResult = findViewById(R.id.tv_Result);
    }

    private enum OperationStatus {

        DEFAULT, PLUS, SUBTRACT, MULTIPLY, DIVIDE
    }
}
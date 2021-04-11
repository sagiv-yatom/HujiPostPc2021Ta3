package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }

    /*
    TODO:
    - find all views
    - initial update main text-view based on calculator's output
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */
    TextView output = findViewById(R.id.textViewCalculatorOutput);
    TextView equalsButton = findViewById(R.id.buttonEquals);
    TextView plusButton = findViewById(R.id.buttonPlus);
    TextView minusButton = findViewById(R.id.buttonMinus);
    TextView clearButton = findViewById(R.id.buttonClear);
    View deleteLastButton = findViewById(R.id.buttonBackSpace);

    TextView zeroButton = findViewById(R.id.button0);
    TextView oneButton = findViewById(R.id.button1);
    TextView twoButton = findViewById(R.id.button2);
    TextView threeButton = findViewById(R.id.button3);
    TextView fourButton = findViewById(R.id.button4);
    TextView fiveButton = findViewById(R.id.button5);
    TextView sixButton = findViewById(R.id.button6);
    TextView sevenButton = findViewById(R.id.button7);
    TextView eightButton = findViewById(R.id.button8);
    TextView nineButton = findViewById(R.id.button9);

    output.setText(calculator.output());

    equalsButton.setOnClickListener(v -> {
      calculator.insertEquals();
      output.setText(calculator.output());
    });

    plusButton.setOnClickListener(v -> {
      calculator.insertPlus();
      output.setText(calculator.output());
    });

    minusButton.setOnClickListener(v -> {
      calculator.insertMinus();
      output.setText(calculator.output());
    });

    clearButton.setOnClickListener(v -> {
      calculator.clear();
      output.setText(calculator.output());
    });

    deleteLastButton.setOnClickListener(v -> {
      calculator.deleteLast();
      output.setText(calculator.output());
    });

    zeroButton.setOnClickListener(v -> {
      calculator.insertDigit(0);
      output.setText(calculator.output());
    });

    oneButton.setOnClickListener(v -> {
      calculator.insertDigit(1);
      output.setText(calculator.output());
    });

    twoButton.setOnClickListener(v -> {
      calculator.insertDigit(2);
      output.setText(calculator.output());
    });

    threeButton.setOnClickListener(v -> {
      calculator.insertDigit(3);
      output.setText(calculator.output());
    });

    fourButton.setOnClickListener(v -> {
      calculator.insertDigit(4);
      output.setText(calculator.output());
    });

    fiveButton.setOnClickListener(v -> {
      calculator.insertDigit(5);
      output.setText(calculator.output());
    });

    sixButton.setOnClickListener(v -> {
      calculator.insertDigit(6);
      output.setText(calculator.output());
    });

    sevenButton.setOnClickListener(v -> {
      calculator.insertDigit(7);
      output.setText(calculator.output());
    });

    eightButton.setOnClickListener(v -> {
      calculator.insertDigit(8);
      output.setText(calculator.output());
    });

    nineButton.setOnClickListener(v -> {
      calculator.insertDigit(9);
      output.setText(calculator.output());
    });
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
    outState.putSerializable("param", calculator.saveState());
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
    Serializable savedState = savedInstanceState.getSerializable("param");
    calculator.loadState(savedState);
    TextView output = findViewById(R.id.textViewCalculatorOutput);
    output.setText(calculator.output());
  }
}
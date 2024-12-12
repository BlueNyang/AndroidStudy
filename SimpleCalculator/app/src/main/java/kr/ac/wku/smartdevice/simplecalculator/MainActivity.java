package kr.ac.wku.smartdevice.simplecalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    TextView textResult;
    String num1, num2;
    float result;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);
        setTitle("Simple Calculator");

        edit1 = (EditText) findViewById(R.id.Edit1);
        edit2 = (EditText) findViewById(R.id.Edit2);
        btnAdd = (Button) findViewById(R.id.BtnAdd);
        btnSubtract = (Button) findViewById(R.id.BtnSubtract);
        btnMultiply = (Button) findViewById(R.id.BtnMultiply);
        btnDivide = (Button) findViewById(R.id.BtnDivide);
        textResult = (TextView) findViewById(R.id.TvResult);

        btnAdd.setOnTouchListener(this::SetOnClickListener);
        btnSubtract.setOnTouchListener(this::SetOnClickListener);
        btnMultiply.setOnTouchListener(this::SetOnClickListener);
        btnDivide.setOnTouchListener(this::SetOnClickListener);

    }

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    public boolean SetOnClickListener(View view, MotionEvent event) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();

        int id = view.getId();
        if (id == R.id.BtnAdd){
            result = Float.parseFloat(num1) + Float.parseFloat(num2);
        } else if (id == R.id.BtnSubtract){
            result = Float.parseFloat(num1) - Float.parseFloat(num2);
        } else if (id == R.id.BtnMultiply){
            result = Float.parseFloat(num1) * Float.parseFloat(num2);
        } else if (id == R.id.BtnDivide){
            result = Float.parseFloat(num1) / Float.parseFloat(num2);
        }

        //%0.2f result
        textResult.setText("계산 결과 : " + String.format("%.2f", result));

        return false;
    }
}
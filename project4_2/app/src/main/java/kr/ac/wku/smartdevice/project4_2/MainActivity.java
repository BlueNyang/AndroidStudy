package kr.ac.wku.smartdevice.project4_2;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    SwitchCompat sw1;
    ImageView img1;
    RadioGroup rg1;
    RadioButton rb1, rb2, rb3;
    Button btnExit, btnBack;


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
        setTitle("Show Android Image");

        text1 = findViewById(R.id.Text1);
        sw1 = findViewById(R.id.Switch1);

        text2 = findViewById(R.id.Text2);
        rg1 = findViewById(R.id.RadioGroup1);
        rb1 = findViewById(R.id.RadioButton1);
        rb2 = findViewById(R.id.RadioButton2);
        rb3 = findViewById(R.id.RadioButton3);

        btnExit = findViewById(R.id.ButtonExit);
        btnBack = findViewById(R.id.ButtonBack);
        img1 = findViewById(R.id.ImageView1);

        sw1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                text2.setVisibility(View.VISIBLE);
                rg1.setVisibility(View.VISIBLE);
                btnBack.setVisibility(View.VISIBLE);
                img1.setVisibility(View.VISIBLE);
            } else {
                text2.setVisibility(View.GONE);
                rg1.setVisibility(View.GONE);
                btnBack.setVisibility(View.GONE);
                img1.setVisibility(View.GONE);
            }
        });

        rb1.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.s12);
        });
        rb2.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.t13);
        });
        rb3.setOnClickListener(v -> {
            img1.setImageResource(R.drawable.u14);
        });

        btnExit.setOnClickListener(v -> {
            finish();
        });

        btnBack.setOnClickListener(v -> {
            sw1.setChecked(false);
            //delete all checked radio buttons and image
            rg1.clearCheck();
            img1.setImageResource(0);
        });
    }
}
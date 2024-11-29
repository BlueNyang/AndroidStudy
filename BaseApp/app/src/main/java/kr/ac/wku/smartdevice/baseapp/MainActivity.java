package kr.ac.wku.smartdevice.baseapp;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnWKU;
    Button btn911;
    Button btnGallery;
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        btnWKU = (Button) findViewById(R.id.btnWKU);
        btn911 = (Button) findViewById(R.id.btn911);
        btnGallery = (Button) findViewById(R.id.btnGallery);
        btnExit = (Button) findViewById(R.id.btnExit);

        btnWKU.setBackgroundColor(Color.GRAY);
        btnWKU.setTextColor(Color.BLACK);
        btnWKU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wku.ac.kr/"));
                startActivity(intent);
            }

        });

        //#006400
        btn911.setBackgroundColor(Color.parseColor("#009b00"));
        btn911.setTextColor(Color.BLACK);
        btn911.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:911"));
                startActivity(intent);
            }
        });

        btnGallery.setBackgroundColor(Color.RED);
        btnGallery.setTextColor(Color.BLACK);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
                startActivity(intent);
            }
        });

        //Yellow
        btnExit.setBackgroundColor(Color.YELLOW);
        btnExit.setTextColor(Color.BLACK);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
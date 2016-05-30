package com.example.user.task1;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button harButton, resetButton;
    TextView harText;
    int count = 0;
    RelativeLayout harLayout;
    String t;


    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        t=harText.getText().toString();
        outState.putString("file",t);

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        harText.setText(savedInstanceState.getString("file"));
        count=Integer.parseInt(harText.getText().toString());

    }


    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main_l);
        }
        harLayout = (RelativeLayout) findViewById(R.id.harishLayout);
        harButton = (Button) findViewById(R.id.button1);
        resetButton = (Button) findViewById(R.id.button2);
        harText = (TextView) findViewById(R.id.harishText);
        SharedPreferences value = getSharedPreferences("key",MODE_PRIVATE);
        count = value.getInt("count",0);
        harText.setText(Integer.toString(count));
        if (count == 0) {
            harLayout.setBackgroundColor(Color.BLUE);
            count++;
            harText.setText(Integer.toString(count));
        } else if (count == 1) {
            harLayout.setBackgroundColor(Color.CYAN);
            count++;
            harText.setText(Integer.toString(count));
        } else if (count == 2) {
            harLayout.setBackgroundColor(Color.MAGENTA);
            count++;
            harText.setText(Integer.toString(count));
        } else if (count == 3) {
            harLayout.setBackgroundColor(Color.YELLOW);
            count++;
            harText.setText(Integer.toString(count));
        } else if (count == 4) {
            harLayout.setBackgroundColor(Color.RED);
            count = 0;
            harText.setText(Integer.toString(count));
        }



        harButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        SharedPreferences value = getSharedPreferences("key",MODE_PRIVATE);
                        SharedPreferences.Editor valuechng = value.edit();
                        valuechng.putInt("count",count);
                        valuechng.apply();
                        if (count == 0) {
                            harLayout.setBackgroundColor(Color.BLUE);
                            count++;
                            harText.setText(Integer.toString(count));
                        } else if (count == 1) {
                            harLayout.setBackgroundColor(Color.CYAN);
                            count++;
                            harText.setText(Integer.toString(count));
                        } else if (count == 2) {
                            harLayout.setBackgroundColor(Color.MAGENTA);
                            count++;
                            harText.setText(Integer.toString(count));
                        } else if (count == 3) {
                            harLayout.setBackgroundColor(Color.YELLOW);
                            count++;
                            harText.setText(Integer.toString(count));
                        } else if (count == 4) {
                            harLayout.setBackgroundColor(Color.RED);
                            count = 0;
                            harText.setText(Integer.toString(count));
                        }


                    }
                }
        );

        resetButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        count = 0;
                        SharedPreferences value = getSharedPreferences("key",MODE_PRIVATE);
                        SharedPreferences.Editor valuechng = value.edit();
                        valuechng.putInt("count",0);
                        valuechng.apply();
                        harLayout.setBackgroundColor(Color.RED);
                        harText.setText(Integer.toString(count));
                    }
                }
        );

    }



}
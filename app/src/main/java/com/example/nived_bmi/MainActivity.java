package com.example.nived_bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        final EditText h = findViewById(R.id.height);
        final EditText w = findViewById(R.id.weight);
        final TextView r = findViewById(R.id.result);
        final Button button = findViewById(R.id.button);
        final Button butreset =findViewById(R.id.reset);

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String s1 = h.getText().toString();
                        String s2 = w.getText().toString();

                        if (TextUtils.isEmpty(s1)) {
                            h.setError("Please Enter The Height");
                            h.requestFocus();
                            return;
                        }
                        if (TextUtils.isEmpty(s2)) {
                            w.setError("Please Enter The Weight");
                            w.requestFocus();
                            return;
                        }
                        float height = Float.parseFloat(s1);
                        float weight = Float.parseFloat(s2);
                        float bmi = calcbmi(height, weight);
                        String result = resultbmi(bmi);
                        r.setText("BMI =" + bmi + "\n" + result);
                        r.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                    }
                }
        );

        butreset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        h.setText("");
                        w.setText("");
                        r.setText("");
                        r.setBackgroundColor(getResources().getColor(android.R.color.white));
                        h.requestFocus();

                    }
                }
        );
    }

    public float calcbmi(float height, float weight) {

        float bmi;
        height/=100;
        bmi=(weight/(height*height));
        return bmi;
    }
    public String resultbmi(float bmi){

        if(bmi<16){
            return "Severely Underweight!!\nYou will have to seriously improve your weight or we might lose you☠️☠️️!!!";
        }
        else if(bmi>=16&&bmi<18.5){
            return "Underweight!!\nYou will have to improve your weight⚠️⚠️!!!";
        }
        else if(bmi<25&&bmi>=18.5){
            return "Normal\nYou are doing great..Yaaayy!!☺☺";
        }
        else if(bmi>=25&&bmi<30){
            return "Overweight!!\nYou must reduce your weight ⚠️⚠️!!!";
        }
        else return "Obese!!!!\nImmediately reduce your weight or die☠️☠️!!";
    }

}

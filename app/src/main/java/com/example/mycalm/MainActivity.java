package com.example.mycalm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnGenerate;
    TextView tv_otvet, tv_main_answer;
    int otvetInt, genOtvetInt;

    LottieAnimationView lotty_sun, lotty_one, lotty_two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lotty_sun = findViewById(R.id.lotty_sun);
        lotty_one = findViewById(R.id.lotty_one);
        lotty_two = findViewById(R.id.lotty_two);
        tv_otvet = findViewById(R.id.tv_otvet);
        tv_main_answer = findViewById(R.id.tv_main_answer);
        btnGenerate = findViewById(R.id.btn_generate);

        lotty_sun.setAnimation(R.raw.sunshine);
        lotty_one.setAnimation(R.raw.animation_fire);
        lotty_two.setAnimation(R.raw.fun_time);

        btnGenerate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random random = new Random();
                genOtvetInt = random.nextInt(100);
                otvetInt = genOtvetInt;
                if ((otvetInt != 0) && (otvetInt > 0)) {
                    tv_otvet.setText(String.valueOf(otvetInt) + "  %");
                    printAnswer();
                    btnGenerate.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(MainActivity.this, "Нажми ещё раз GENERATE", Toast.LENGTH_SHORT).show();
                    btnGenerate.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void printAnswer() {
        if (otvetInt >= 1 && otvetInt <= 48) {
            tv_main_answer.setText("Завтра, может, в чем-то повезeт!");
            lotty_two.setVisibility(View.VISIBLE);
        } else {
            if (otvetInt > 48 && otvetInt <= 65) {
                tv_main_answer.setText("Чел хорош");

                lotty_two.setVisibility(View.VISIBLE);
            } else {
                if (otvetInt > 65 && otvetInt <= 100) {
                    tv_main_answer.setText("Ну ты внатуре кабан");

                    lotty_one.setVisibility(View.VISIBLE);
                }
            }
        }
    }


}
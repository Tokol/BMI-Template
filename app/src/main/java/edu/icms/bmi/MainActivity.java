package edu.icms.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {


TextView weightValueText, ageValueText, increaseWeightButton, decreaseWeightButton, increaseAgeButton, decreaseAgeButton;

TextView calculateBtn;

TextView displayHeight;

SeekBar heightSeekBar;

int heightValue;

int weightValue, ageValue;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    weightValueText = findViewById(R.id.weightText);
    ageValueText = findViewById(R.id.ageText);
    increaseAgeButton = findViewById(R.id.plusWeight);
    decreaseAgeButton = findViewById(R.id.minusWeight);
    increaseWeightButton = findViewById(R.id.plusAge);
    decreaseWeightButton = findViewById(R.id.minusAge);
    calculateBtn = findViewById(R.id.calulateBtn);
    heightSeekBar = findViewById(R.id.seekBar);
    displayHeight = findViewById(R.id.displayHeight);


    heightValue = Integer.valueOf(displayHeight.getText().toString());
    weightValue = Integer.valueOf(weightValueText.getText().toString());
    ageValue = Integer.valueOf(ageValueText.getText().toString());



    heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            String height = String.valueOf(progress);
            displayHeight.setText(height);
            heightValue = progress;

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });


    increaseWeightButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            weightValue++;

            weightValueText.setText(weightValue+"");

        }
    });

    decreaseWeightButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            weightValue--;

            weightValueText.setText(weightValue+"");
        }
    });

decreaseAgeButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ageValue--;
        ageValueText.setText(ageValue+"");
    }
});


increaseAgeButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ageValue++;
        ageValueText.setText(ageValue+"");
    }
});






    calculateBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("WEIGHTVALUE", weightValue+"");
            Log.d("heightValue", heightValue+"");
            double bmi = calculateBMI(weightValue,heightValue);

            Log.d("BMI", bmi+"");
            Intent intent = new Intent(MainActivity.this,ResultActivity.class);

            intent.putExtra("bmiValue", bmi);

          //  intent.putExtra("gender",genderValue);
            // we can send many data from one  activity to another activity.

            startActivity(intent);

        }
    });



    }


   double calculateBMI(int weight, int heightValue){
    double weightDouble= (double) weight;
       double heighttDouble= (double) heightValue;

       Log.d("weightC", weight+"");
       Log.d("heightValueC", heightValue+"");
    double num = weightDouble/ (heighttDouble*heighttDouble);
       Log.d("calucatedBMI", num*10000+"");

    double bmis  =  num*10000.00;


       BigDecimal bd = new BigDecimal(bmis).setScale(2, RoundingMode.HALF_UP);
       double roundedBMI = bd.doubleValue();

       return roundedBMI;

   }


}
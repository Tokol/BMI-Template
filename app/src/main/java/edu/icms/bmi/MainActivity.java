package edu.icms.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

decreaseAgeButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        weightValue--;
        weightValueText.setText(weightValue+"");
    }
});


increaseAgeButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ageValue++;
        ageValueText.setText(ageValue+"");
    }
});


    decreaseAgeButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ageValue--;
            ageValueText.setText(ageValue+"");
        }
    });



    calculateBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int bmi = calculateBMI(weightValue,heightValue);


        }
    });



    }


   int calculateBMI(int weight, int heightValue){
    int num = weight/ (heightValue*heightValue);
    return num*10000;

   }


}
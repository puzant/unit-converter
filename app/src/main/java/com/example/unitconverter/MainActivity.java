package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText tempEdit;
    TextView convertedTemp;
    private String selectedTempOption;
    private String value;
    private double convertedNumber;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convertedTemp = (TextView) findViewById(R.id.valueTxt);
        tempEdit = (EditText) findViewById(R.id.editTempValue);
    }

    public void convertTemp(View view) {
        try {
            value = tempEdit.getText().toString();
            convertedNumber = Double.parseDouble(value);
            if(selectedTempOption == "fromFahrenheitTocelsius")
                result = Math.floor((convertedNumber-32)*5/9);

            else if(selectedTempOption == "fromcelsiusToFahrenheit")
                result = Math.floor((convertedNumber*9/5)+32);

            else if(selectedTempOption == "toKelvin")
                result = Math.floor(convertedNumber + 273.15);

            convertedTemp.setText("Converted Value: " + result);
        } catch(Exception error) {
            Toast.makeText(this, "PLease enter a value", Toast.LENGTH_SHORT).show();
        }
    }

    public void onOptionSelect(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.celsiusOpt:
                if (checked)
                    selectedTempOption = "fromFahrenheitTocelsius";
                    break;
            case R.id.fahrenheitOpt:
                if (checked)
                    selectedTempOption = "fromcelsiusToFahrenheit";
                    break;
            case R.id.kelvinOpt:
                if(checked)
                    selectedTempOption = "toKelvin";
        }

    }

}
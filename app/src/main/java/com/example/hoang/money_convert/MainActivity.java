package com.example.hoang.money_convert;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerDanhSach1,spinnerDanhsach2;
    double [][] Currencies = {
            {1.0, 0.000043, 0.000061, 0.000032, 0.000057, 0.003, 0.000038, 0.000058, 0.0048, 0.048704},
            {23196.22, 1.0, 1.41282, 0.757681, 1.34037, 69.6152, 0.886991, 1.35652, 111.363, 1130.03},
            {16423.27, 0.70781, 1.0, 0.536749, 0.948823, 49.2666, 0.627818, 0.960148, 78.8157, 799.717},
            {30584.48, 1.31699, 1.86101, 1.0, 1.76536, 91.7077, 1.16782, 1.78577, 146.572, 1487.39},
            {17315.10, 0.746153, 1.05449, 0.566457, 1.0, 51.9730, 0.662029, 1.01227, 83.0717, 843.449},
            {333.125, 0.014353, 0.020286, 0.010908, 0.019239, 1.0, 0.012735, 0.019473, 1.59804, 16.228},
            {26149.36, 1.12709, 1.59298, 0.856751, 1.51049, 78.5104, 1.0, 1.52887, 125.458,1274.11},
            {17117.97, 0.7371, 1.04185, 0.559993, 0.987846, 51.3529, 0.654029, 1.0, 82.0626, 833.299},
            {208.424, 0.008982, 0.012694, 0.006826, 0.012037, 0.626074, 0.007969, 0.012186, 1.0, 10.1549},
            {20.5275, 0.000884, 0.00125, 0.000672, 0.001185, 0.061647, 0.000784, 0.0012, 0.098485, 1.0}
    };

    private String country1,country2;
    private EditText amount;
    private Button convert;
    private TextView result;
    private static DecimalFormat df2 = new DecimalFormat(".##");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDanhSach1 = (Spinner)findViewById(R.id.spinner1);
        spinnerDanhsach2 = (Spinner)findViewById(R.id.spinner2);
        amount = (EditText)findViewById(R.id.amount);
        convert = (Button)findViewById(R.id.convert);
        result = (TextView)findViewById(R.id.txtResult);

        final ArrayList<Country> arrayList = new ArrayList<Country>();
        arrayList.add(new Country(R.drawable.vietnam,"Vietnamese Dong"));
        arrayList.add(new Country(R.drawable.united_states,"US Dollar"));
        arrayList.add(new Country(R.drawable.australia,"Australian Dollar"));
        arrayList.add(new Country(R.drawable.england,"British Pound"));
        arrayList.add(new Country(R.drawable.canada,"Canadian Dollar"));
        arrayList.add(new Country(R.drawable.india,"Indian Rupee"));
        arrayList.add(new Country(R.drawable.european_union,"Euro"));
        arrayList.add(new Country(R.drawable.singapore,"Singapore Dollar"));
        arrayList.add(new Country(R.drawable.japan,"Japanese Yen"));
        arrayList.add(new Country(R.drawable.south_korea,"Korean Won"));



        CountryAdapter countryAdapter = new CountryAdapter(this,R.layout.country,arrayList);
        spinnerDanhSach1.setAdapter(countryAdapter);
        spinnerDanhsach2.setAdapter(countryAdapter);

        spinnerDanhSach1.setSelection(0,true);
        spinnerDanhsach2.setSelection(0,true);

        country1 = "Vietnamese Dong";
        country2 = "Vietnamese Dong";

        spinnerDanhSach1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country1 = arrayList.get(position).Name;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerDanhsach2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                country2 = arrayList.get(position).Name;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double old_amount = Double.parseDouble(amount.getText().toString());
                double Currency = Currencies[getIndex(country1)][getIndex(country2)];
                double new_amount = old_amount*Currency;
                String convertResult = String.valueOf(old_amount)+" "+country1+" = "+df2.format(new_amount)+" "+country2;
                result.setText(convertResult);
            }
        });
    }

    private int getIndex(String name){
        switch (name) {
            case "Vietnamese Dong":
                return 0;
            case "US Dollar":
                return 1;
            case "Australian Dollar":
                return 2;
            case "British Pound":
                return 3;
            case "Canadian Dollar":
                return 4;
            case "Indian Rupee":
                return 5;
            case "Euro":
                return 6;
            case "Singapore Dollar":
                return 7;
            case "Japanese Yen":
                return 8;
            default:
                return 9;
        }

    }

}

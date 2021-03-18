package itacademy.kg.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner languageSpinner;
    ArrayAdapter<String> adapter;

    Button buttonPlus, buttonMinus, buttonCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View TotalPrice = findViewById(R.id.textView3);
       String StringPrice = String.valueOf(TotalPrice);
       buttonPlus = (Button) findViewById(R.id.button3);
       buttonMinus = (Button) findViewById(R.id.button2);
       buttonCart = (Button) findViewById(R.id.button);
       buttonPlus.setOnClickListener(this);
       buttonMinus.setOnClickListener(this);
       buttonCart.setOnClickListener(this);
       //spinner
        languageSpinner =(Spinner) findViewById(R.id.spinner);
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Drums");
        languages.add("Guitar");
        languages.add("Kymis");
        languages.add("Pianino");
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, languages);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);
        //Его не признали потому что он стал биткоином,
        // а он стал биткоином потому что его признали
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Quantity

    }

    @Override
    public void onClick(View v) {

        TextView counter = findViewById(R.id.textView5);

        int count = 0;
        switch (v.getId()){
            case R.id.button2:
                counter.setText(String.valueOf(count--));
                break;
            case R.id.button3:

                counter.setText(String.valueOf(count++));
                break;
            case R.id.button:
                //Add cart function
                break;
        }
    }
}
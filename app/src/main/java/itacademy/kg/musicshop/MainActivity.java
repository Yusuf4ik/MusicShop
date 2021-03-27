    package itacademy.kg.musicshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner languageSpinner;
    ArrayAdapter<String> adapter;
    ArrayList<String> images;
    ArrayList<Order> cart;
    HashMap<String, Integer> goods;
    public String selectedItem;
    int product;

    private static int count = 0;
    TextView counter;
    ImageView image;
    private int price;
    TextView TotalPrice;
    EditText userName;
    Button buttonPlus, buttonMinus, buttonCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String StringPrice = String.valueOf(TotalPrice);
        buttonPlus = (Button) findViewById(R.id.button3);
        TotalPrice = findViewById(R.id.textView3);
        counter = findViewById(R.id.textView5);
        image = findViewById(R.id.imageView2);
        userName = findViewById(R.id.editTextTextPersonName);
        buttonMinus = (Button) findViewById(R.id.button2);
        buttonCart = (Button) findViewById(R.id.button);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonCart.setOnClickListener(this);
        //spinner
        ArrayList<String> spinnerData = new ArrayList<>();
        spinnerData.add("Drums");  //drums
        spinnerData.add("Guitar");
        spinnerData.add("Rock");
        spinnerData.add("Keyboard");
        languageSpinner = (Spinner) findViewById(R.id.spinner);


        goods = new HashMap<>();
        goods.put("Drums", 500);
        goods.put("Guitar", 800);
        goods.put("Rock", 10000);
        goods.put("Keyboard", 1000);

        images = new ArrayList<String>();


        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, spinnerData);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);
        //Его не признали потому что он стал биткоином,
        // а он стал биткоином потому что его признали
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                 selectedItem = parent.getSelectedItem().toString();
                count = 1;


                counter.setText(String.valueOf(count));
                if (selectedItem.equals("Guitar")) {
                    image.setImageResource(R.drawable.guitar);
                    price = goods.get(selectedItem);
                    product = price*count;
                    TotalPrice.setText(String.valueOf(product));
                } else if (selectedItem.equals("Drums")) {
                    image.setImageResource(R.drawable.drums);
                    price = goods.get(selectedItem);
                    product = price*count;
                    TotalPrice.setText(String.valueOf(product));


                } else if (selectedItem.equals("Keyboard")) {
                    image.setImageResource(R.drawable.keyboard);
                    price = goods.get(selectedItem);
                    product = price*count;
                    TotalPrice.setText(String.valueOf(product));

                } else if (selectedItem.equals("Rock")) {
                    image.setImageResource(R.drawable.rock);
                    price = goods.get(selectedItem);
                    product = price*count;
                    TotalPrice.setText(String.valueOf(product));

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //Quantity

    }


    @Override
    public void onClick(View v) {




        switch (v.getId()) {
            case R.id.button2:
                count--;
                product = count * price;
                if (count <= 0) {

                    count = 1;
                    product = count * price;


                }

                TotalPrice.setText(String.valueOf(product));

                counter.setText(String.valueOf(count));

                break;
            case R.id.button3:
                count++;
                counter.setText(String.valueOf(count));
                product = count * price;
                TotalPrice.setText(String.valueOf(product));

                break;
            case R.id.button:
                CartFunction();
                break;
        }
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
    public void CartFunction(){
        if (!TextUtils.isEmpty(userName.getText())) {
            Toast.makeText(this, "Ваш заказ добавлен в корзину!", Toast.LENGTH_SHORT).show();

            String clientName = String.valueOf(userName.getText());
            int quantity = Integer.parseInt(counter.getText().toString());
            int price = Integer.parseInt(TotalPrice.getText().toString());
            localDB.localList.add(new Order(clientName, selectedItem, quantity, price));
        }
        else{
            Toast.makeText(MainActivity.this, "Fill in the blanks", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.settings:
                startActivity(new Intent(MainActivity.this, Secondactivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public int getImage() {
        return Integer.parseInt(selectedItem);
    }
}
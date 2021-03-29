package itacademy.kg.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Secondactivity extends AppCompatActivity {


    ListView listView;
    Button button;
    TextView textView;
    MusicAdapter musicAdapter;
    String[] massive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        button = (Button) findViewById(R.id.sendOrder);
        listView = (ListView) findViewById(R.id.listView);
        musicAdapter = new MusicAdapter(Secondactivity.this,
                R.layout.list_item, localDB.localList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"ivan@example.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Test subject");
                intent.putExtra(Intent.EXTRA_TEXT, packOrder(localDB.localList));



                startActivity(intent);
            }
        });
        if (localDB.localList.size() > 0) {

            listView.setVisibility(View.VISIBLE);

            listView.setAdapter(musicAdapter);


        } else if (localDB.localList.size() < 0) {
            listView.setVisibility(View.GONE);
            Toast.makeText(Secondactivity.this, "You haven't added any goods to cart",
                    Toast.LENGTH_SHORT).show();
        } else if (musicAdapter.isEmpty()) {
            listView.setVisibility(View.GONE);
            textView = findViewById(R.id.oop);
            textView.setText("The basket is empty");

        }
    }

    private String packOrder(ArrayList<Order> orderArrayList) {
        String message = "";

        for (Order order : orderArrayList) {
            String quantity = String.valueOf(order.getQuantity());

            message += "Order name: " + order.getGoodsName() +"\n"   + "Order quantity: "
                    + quantity + "\n"+ "Order totalPrice: "+
                    musicAdapter.getTv_price();
        }

        return message;
    }



}
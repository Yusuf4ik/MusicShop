package itacademy.kg.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Secondactivity extends AppCompatActivity  {


    ListView listView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        listView = (ListView) findViewById(R.id.listView);
        MusicAdapter musicAdapter = new MusicAdapter(Secondactivity.this,
                R.layout.list_item, localDB.localList);
        if (localDB.localList.size() > 0){

            listView.setVisibility(View.VISIBLE);

            listView.setAdapter(musicAdapter);


        }else if (localDB.localList.size() < 0){
            listView.setVisibility(View.GONE);
            Toast.makeText(Secondactivity.this, "You haven't added any goods to cart", Toast.LENGTH_SHORT).show();
        }else if (musicAdapter.isEmpty()){
            listView.setVisibility(View.GONE);
            textView = findViewById(R.id.oop);
            textView.setText("The basket is empty");

        }
    }


}
package itacademy.kg.musicshop;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends ArrayAdapter<Order> {
    Context context;
    Button button;
    ImageView tv_image;
    TextView tv_title, tv_clientName, tv_price, tv_quantity;
    String goodPrice;


    int resource;

    public MusicAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Order> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;

    }

    public String getTv_price() {
        return String.valueOf(goodPrice);
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String goodTitle = getItem(position).getGoodsName();
        String clientName = getItem(position).getUserName();
         goodPrice = String.valueOf(getItem(position).getPrice());
        String goodQuantity = String.valueOf(getItem(position).getQuantity());
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.list_item, parent, false);//list_item.xml
        tv_image = convertView.findViewById(R.id.goodImage);
        tv_title = convertView.findViewById(R.id.goodTitle);
        tv_clientName = convertView.findViewById(R.id.clientName);
        tv_price = convertView.findViewById(R.id.goodPrice);
        tv_quantity = convertView.findViewById(R.id.goodQuantity);
        Button button = convertView.findViewById(R.id.deleteButton);
        tv_title.setText("Name: "+ goodTitle);
        tv_price.setText("Price: "+goodPrice);
        tv_quantity.setText("Quantity: " + goodQuantity);
        localDB delete = new localDB();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete.remove(position);
                notifyDataSetChanged();
            }
        });


        tv_clientName.setText(clientName);
        if (goodTitle.equals("Guitar")) {
            tv_image.setImageResource(R.drawable.guitar);

        } else if (goodTitle.equals("Drums")) {
            tv_image.setImageResource(R.drawable.drums);
        } else if (goodTitle.equals("Keyboard")) {
            tv_image.setImageResource(R.drawable.keyboard);
        } else if (goodTitle.equals("Rock")) {
            tv_image.setImageResource(R.drawable.rock);
        }
        return convertView;
    }


}

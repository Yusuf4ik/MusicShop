package itacademy.kg.musicshop;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Order  {

    String userName;
    String goodsName;
     int quantity;
     int price;


    public Order(String userName, String goodsName, int quantity, int price) {
        this.userName = userName;
        this.goodsName = goodsName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}

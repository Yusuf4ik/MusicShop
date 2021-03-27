package itacademy.kg.musicshop;

import java.util.ArrayList;

public class localDB {
   static ArrayList<Order> localList = new ArrayList<>();

   public void remove(int position){
      localList.remove(localList.get(position));
   }

}

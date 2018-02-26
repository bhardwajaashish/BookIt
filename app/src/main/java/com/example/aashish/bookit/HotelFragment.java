package com.example.aashish.bookit;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by aashish on 18/7/17.
 */

public class HotelFragment extends Fragment {

    String details[]={"Hotel Bella Vista\nSec 1, Chandigarh","Hotel Amara\nSec 43, Chandigarh","The Aroma \nSec 22 C, Chandigarh","Hotel Sun Beam \nSec 22 B, Chandigarh","Hotel Park Grand \nSec 43, Chandigarh"};
    Integer images[]={R.drawable.hotel1,R.drawable.hotel2,R.drawable.hotel3,R.drawable.hotel4,R.drawable.hotel5};
    String prices[]={"Rs. 4500","Rs. 3500","Rs.4000","Rs. 4100","Rs. 3000"};
    ImageView image;
    TextView text,textView1;
    int position;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.hotel,container,false);
        image=(ImageView)view.findViewById(R.id.img);
        text=(TextView)view.findViewById(R.id.text);
        textView1=(TextView)view.findViewById(R.id.textview1);

        text.setText(details[position]);
        textView1.setText(prices[position]);
        image.setImageResource(images[position]);
        return view;
    }

    public void setArguments(int i) {

        this.position=i;
    }
}

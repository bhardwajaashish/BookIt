package com.example.aashish.bookit;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aashish on 10/7/17.
 */

public class HomeFragment extends Fragment {

    TextView t1;
    RelativeLayout relative;
    String detais[]={"Hotel Bella Vista\nSec 1, Chandigarh","Hotel Amara\nSec 43, Chandigarh","The Aroma \nSec 22 C, Chandigarh","Hotel Sun Beam \nSec 22 B, Chandigarh","Hotel Park Grand \nSec 43, Chandigarh"};
    Integer images[]={R.drawable.hotel1,R.drawable.hotel2,R.drawable.hotel3,R.drawable.hotel4,R.drawable.hotel5};
    ListView list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        /*return super.onCreateView(inflater, container, savedInstanceState);*/


       View view=inflater.inflate(R.layout.home,container,false);
        /*t1=(TextView)view.findViewById(R.id.t1);
        relative=(RelativeLayout)view.findViewById(R.id.relative);*/

        list=(ListView)view.findViewById(R.id.scroll);

        Window window = getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(),R.color.toolbar));

        CustomListView customListView=new CustomListView(getActivity(),detais,images);

        list.setAdapter(customListView);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HotelFragment hotelf=new HotelFragment();
                hotelf.setArguments(i);
                getFragmentManager().beginTransaction().replace(R.id.container,hotelf).commit();
            }
        });

        /*t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                relative.setVisibility(View.GONE);
            }
        });*/
        return view;

    }
    public class CustomListView extends ArrayAdapter<String>{

        private String[] details;
        private Integer[] images;
        private Activity context;

        public CustomListView(Activity context,String[] details,Integer[] images) {
            super(context, R.layout.home_list_item,details);
            this.context=context;
            this.details=details;
            this.images=images;
        }




        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View listViewItem=inflater.inflate(R.layout.home_list_item,null,true);
            TextView textView=(TextView)listViewItem.findViewById(R.id.textview);
            ImageView imageView=(ImageView)listViewItem.findViewById(R.id.imageView);

            textView.setText(details[position]);
            imageView.setImageResource(images[position]);



            return listViewItem;
        }
    }

}

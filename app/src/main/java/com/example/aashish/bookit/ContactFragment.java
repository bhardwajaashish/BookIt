package com.example.aashish.bookit;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by aashish on 22/11/17.
 */

public class ContactFragment extends Fragment{
    View view;
    TextView textc;
    Button contact1,contact2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.contact,container,false);
        textc=(TextView)view.findViewById(R.id.textc);
        contact1=(Button)view.findViewById(R.id.contact1);
        contact2=(Button)view.findViewById(R.id.contact2);

        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:8950268721"));
                startActivity(i);
            }
        });

        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:9468295595"));
                startActivity(i);
            }
        });

        return view;

        // return super.onCreateView(inflater, container, savedInstanceState);
    }
}



package com.example.aashish.bookit;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by aashish on 8/7/17.
 */

public class ReferFragment extends Fragment {
View view;
    ImageButton refer_button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        /*return super.onCreateView(inflater, container, savedInstanceState);*/
        view=inflater.inflate(R.layout.refer,container,false);
        refer_button=(ImageButton)view.findViewById(R.id.refer_button);
        refer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
        return view;

    }
}

package com.example.aashish.bookit;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by aashish on 10/7/17.
 */

public class ProfileFragment extends Fragment {

    Button logout;
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        /*return super.onCreateView(inflater, container, savedInstanceState);*/
        view=inflater.inflate(R.layout.profile,container,false);

        logout=(Button)view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor ed = prefs.edit();
                ed.clear();
                ed.commit();
                Intent i1 = new Intent(getActivity(),Login.class);
                startActivity(i1);
            }
        });
        return view;

    }
}

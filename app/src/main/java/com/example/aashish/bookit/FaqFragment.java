package com.example.aashish.bookit;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by aashish on 22/11/17.
 */

public class FaqFragment extends Fragment {

    ExpandableListView expandableListView;
    View view;
    TextView text1;


    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.faq,container,false);


        text1=(TextView)view.findViewById(R.id.text1);
        expandableListView=(ExpandableListView)view.findViewById(R.id.exp_listview);
        List<String> Headings= new ArrayList<String>();
        List<String> L1=new ArrayList<String>();
        List<String> L2=new ArrayList<String>();
        List<String> L3=new ArrayList<String>();
        HashMap<String,List<String>> ChildList = new HashMap<String,List<String>>();
        String heading_items[]=getResources().getStringArray(R.array.header_titles);
        String l1[]=getResources().getStringArray(R.array.h1_items);
        String l2[]=getResources().getStringArray(R.array.h2_items);
        String l3[]=getResources().getStringArray(R.array.h3_items);
        for(String title :heading_items)
        {
            Headings.add(title);
        }
        for(String title: l1)
        {
            L1.add(title);
        }

        for(String title: l2)
        {
            L2.add(title);
        }

        for(String title: l3)
        {
            L3.add(title);
        }
        ChildList.put(Headings.get(0),L1);

        ChildList.put(Headings.get(1),L2);

        ChildList.put(Headings.get(2),L3);
        MyAdapter myAdapter=new MyAdapter(getActivity(),Headings,ChildList);
        expandableListView.setAdapter(myAdapter);
        return view;
    }
}

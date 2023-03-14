package com.example.prova.lightlife;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class HomePageNegozianteFragment extends Fragment
{
    public HomePageNegozianteFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getActivity().setTitle("Home");
        View rootView = inflater.inflate(R.layout.home_page_negoziante, container, false);

        ImageButton imgb1 = rootView.findViewById(R.id.numberOne);
        ImageButton imgb2 = rootView.findViewById(R.id.numberTwo);
        ImageButton imgb4 = rootView.findViewById(R.id.numberFour);
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();

        imgb1.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { transaction.replace(R.id.container, new ProblemiFragment()).addToBackStack("tag").commit(); }});
        imgb2.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { transaction.replace(R.id.container, new RimediFragment()).addToBackStack("tag").commit(); } });
        imgb4.setOnClickListener(new View.OnClickListener() { public void onClick(View v) { transaction.replace(R.id.container, new NegozioFragment()).addToBackStack("tag").commit(); } });
        return rootView;
    }
}
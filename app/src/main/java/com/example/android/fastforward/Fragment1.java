package com.example.android.fastforward;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    //LayoutInflater is used to set the layout XML file.
    //container is the parent view of the layout that this fragment will be using.
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Sets the layout to be shown when this item is selected.
        return inflater.inflate(R.layout.layout1, container, false);
    }


    @Override
    //Here, the view parameter is returned from above onCreateView method.
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Sets the title for different fragments and getActivity returns the Activity is currently used.
        getActivity().setTitle("HOME");
    }
}
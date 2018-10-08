package com.arms.arms.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arms.arms.R;
import com.arms.arms.adapter.PictureAdapterRecyclerView;
import com.arms.arms.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar(getResources().getString(R.string.tab_home),false,view);
        RecyclerView picturesRecycler=view.findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView= new PictureAdapterRecyclerView(buildPicutres(), getActivity(), R.layout.cardview_picture);
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPicutres()
    {
        ArrayList<Picture> pictures= new ArrayList<>();
        pictures.add(new Picture("https://imgur.com/y71rBW8.jpg","copen","4 dias","3 Me gusta"));
        pictures.add(new Picture("https://imgur.com/yygxSKL.jpg","gunvolt","2 dias","7 Me gusta"));
        pictures.add(new Picture("https://imgur.com/OE4zT4E.jpg","avian","6 dias","3 Me gusta"));
        pictures.add(new Picture("https://imgur.com/aaZrYhA.jpg","avian","6 dias","3 Me gusta"));
        pictures.add(new Picture("https://imgur.com/JSDAElW.jpg","avian","6 dias","3 Me gusta"));
        pictures.add(new Picture("https://imgur.com/KfI6sCq.jpg","avian","6 dias","3 Me gusta"));
        return  pictures;
    }

    public void showToolbar (String tittle, boolean upButton,View view)
    {
        Toolbar toolbar1= view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar1);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}

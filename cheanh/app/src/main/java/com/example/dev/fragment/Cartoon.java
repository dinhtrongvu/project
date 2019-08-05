package com.example.dev.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dev.adapter.AdaperRecycler;
import com.example.dev.cheanh.R;
import com.example.dev.database.DBPicture;
import com.example.dev.model.ItemRecycler;

import java.util.ArrayList;

public class Cartoon extends Fragment {

    RecyclerView rv;
    ArrayList<ItemRecycler> arr = new ArrayList<>();
    AdaperRecycler adaperRecycler;
    DBPicture dbPicture;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment, container, false);
        dbPicture = new DBPicture(getContext());
        rv = v.findViewById(R.id.rvhumans);
        arr = (ArrayList<ItemRecycler>) dbPicture.getPicture(3);
        adaperRecycler = new AdaperRecycler(arr, getActivity());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rv.setAdapter(adaperRecycler);
        return v;
    }
}

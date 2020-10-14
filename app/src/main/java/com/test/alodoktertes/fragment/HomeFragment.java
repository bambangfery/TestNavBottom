package com.test.alodoktertes.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.alodoktertes.R;
import com.test.alodoktertes.activity.DetailHomeActivity;
import com.test.alodoktertes.adapter.HomeFragmentAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rvList;
    private RecyclerView.LayoutManager layoutManager;
    private HomeFragmentAdapter homeFragmentAdapter;
    private ArrayList<String> listHome;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvList =  view.findViewById(R.id.rvlist);
        rvList.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        rvList.setLayoutManager(layoutManager);


        listHome = new ArrayList<>();
        listHome.add("cat");
        listHome.add("bird");
        listHome.add("dog");
        listHome.add("bear");

        homeFragmentAdapter = new HomeFragmentAdapter(listHome, getContext(), new HomeFragmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String listHome) {
                Intent intent = new Intent(getContext(), DetailHomeActivity.class);
                intent.putExtra("type",listHome);
                startActivity(intent);
            }
        });

        rvList.setAdapter(homeFragmentAdapter);

    }

}
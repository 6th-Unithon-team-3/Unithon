package com.github.unithon.unithon.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public static final String TAG = HomeFragment.class.getName();

    @BindView(R.id.rv_home)
    RecyclerView rvHome;

    private HomeAdapter homeAdapter;

    public HomeFragment() { }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        initView();

        return view;
    }

    private void initView() {
        homeAdapter = new HomeAdapter(getFragmentManager());

        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHome.setAdapter(homeAdapter);

        homeAdapter.setRecommendBookList(new ArrayList<>());
        homeAdapter.setReviewList(new ArrayList<>());
    }

}

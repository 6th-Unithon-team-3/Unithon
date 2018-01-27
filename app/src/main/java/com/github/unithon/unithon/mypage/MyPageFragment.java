package com.github.unithon.unithon.mypage;


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
import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.network.UnithonService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyPageFragment extends Fragment {

    public static final String TAG = MyPageFragment.class.getName();

    @BindView(R.id.rv_review)
    RecyclerView rvReview;

    private final MyPageAdapter myPageAdapter = new MyPageAdapter();

    public MyPageFragment() { }

    public static MyPageFragment newInstance() {
        MyPageFragment fragment = new MyPageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        ButterKnife.bind(this, view);

        initializeView();
        bindReview();

        return view;
    }

    private void initializeView() {
        rvReview.setLayoutManager(new LinearLayoutManager(getContext()));
        rvReview.setAdapter(myPageAdapter);
    }

    private void bindReview() {
        UnithonService.getInstance().getMyPages().enqueue(new Callback<List<MyPage>>() {
            @Override
            public void onResponse(Call<List<MyPage>> call, Response<List<MyPage>> response) {
                if(response.isSuccessful()) {
                    final List<MyPage> myPageList = response.body();
                    myPageAdapter.setMyPageList(myPageList);
                }
            }

            @Override
            public void onFailure(Call<List<MyPage>> call, Throwable t) {

            }
        });
    }
}

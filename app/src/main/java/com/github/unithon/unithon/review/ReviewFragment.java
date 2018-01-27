package com.github.unithon.unithon.review;


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
import com.github.unithon.unithon.model.Review;
import com.github.unithon.unithon.network.UnithonService;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReviewFragment extends Fragment {

    public static final String TAG = ReviewFragment.class.getName();

    @BindView(R.id.rv_review)
    RecyclerView rvReview;

    private final ReviewAdapter reviewAdapter = new ReviewAdapter();

    public ReviewFragment() { }

    public static ReviewFragment newInstance() {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_review, container, false);

        ButterKnife.bind(this, view);

        initializeView();
        bindReview();

        return view;
    }

    private void initializeView() {
        rvReview.setLayoutManager(new LinearLayoutManager(getContext()));
        rvReview.setAdapter(reviewAdapter);
    }

    private void bindReview() {
        UnithonService.getInstance().getReviews().enqueue(new Callback<List<Review>>() {
            @Override
            public void onResponse(Call<List<Review>> call, Response<List<Review>> response) {
                if(response.isSuccessful()) {
                    final List<Review> reviewList = response.body();
                    reviewAdapter.setReviewList(reviewList);
                }
            }

            @Override
            public void onFailure(Call<List<Review>> call, Throwable t) {

            }
        });
    }
}

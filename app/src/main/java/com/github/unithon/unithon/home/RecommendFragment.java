package com.github.unithon.unithon.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.RecommendBook;

public class RecommendFragment extends Fragment {

    private static final String KEY_RECOMMEND_BOOK = "recommend_book";

    @BindView(R.id.iv_recommend_book)
    AppCompatImageView ivRecommendBook;

    private RecommendBook recommendBook;


    public RecommendFragment() {
    }

    public static RecommendFragment newInstance(RecommendBook recommendBook) {
        RecommendFragment fragment = new RecommendFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_RECOMMEND_BOOK, recommendBook);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null) {
            recommendBook = (RecommendBook) getArguments().getSerializable(KEY_RECOMMEND_BOOK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_recommend, container, false);
        ButterKnife.bind(this, view);

        Glide.with(view)
                .load(recommendBook.getImgUrl())
                .into(ivRecommendBook);

        return view;
    }

}

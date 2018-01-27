package com.github.unithon.unithon.home;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.RecommendBook;

public class RecommendFragment extends Fragment {

    private static final String KEY_RECOMMEND_BOOK = "recommend_book";

    private OnFragmentInteractionListener mListener;

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



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {

    }
}

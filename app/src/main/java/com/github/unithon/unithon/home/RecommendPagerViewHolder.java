package com.github.unithon.unithon.home;

import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.RecommendBook;
import java.util.ArrayList;
import java.util.List;
import me.relex.circleindicator.CircleIndicator;

public class RecommendPagerViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.pager_recommend)
    ViewPager pagerRecommend;

    @BindView(R.id.indicator)
    CircleIndicator circleIndicator;

    private List<RecommendBook> recommendBookList = new ArrayList<>();

    private RecommendPagerAdapter recommendPagerAdapter;

    public RecommendPagerViewHolder(FragmentManager fragmentManager, View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        recommendPagerAdapter = new RecommendPagerAdapter(fragmentManager);
        pagerRecommend.setAdapter(recommendPagerAdapter);
        circleIndicator.setViewPager(pagerRecommend);
        recommendPagerAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

    }

    public void bind(List<RecommendBook> recommendBookList) {
        this.recommendBookList = recommendBookList;
        recommendPagerAdapter.setRecommendBookList(recommendBookList);
    }
}

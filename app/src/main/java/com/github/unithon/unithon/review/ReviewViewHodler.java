package com.github.unithon.unithon.review;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.Review;

public class ReviewViewHodler extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_id)
    AppCompatTextView tvId;

    @BindView(R.id.tv_content)
    AppCompatTextView tvContent;

    @BindView(R.id.iv_like)
    AppCompatImageView ivLike;

    private Review review;

    public ReviewViewHodler(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(Review review) {
        this.review = review;

        tvId.setText(review.getId());
        tvContent.setText(review.getReview());

        Glide.with(itemView.getContext())
                .load(review.isLike() ? R.drawable.heart_on : R.drawable.heart_off)
                .into(ivLike);
    }
}

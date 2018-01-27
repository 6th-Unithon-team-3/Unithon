package com.github.unithon.unithon.review;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.Review;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    AppCompatTextView tvName;

    public ReviewViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }


    public void bind(Review review) {
        tvName.setText(review.getLogin());
    }
}

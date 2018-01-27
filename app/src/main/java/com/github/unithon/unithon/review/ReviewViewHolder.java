package com.github.unithon.unithon.review;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.Review;
import com.github.unithon.unithon.util.PollyHelper;

public class ReviewViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    AppCompatTextView tvName;

    private Review review;

    public ReviewViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> PollyHelper.getInstance().playPolly("클릭했어" + review.getLogin()));
    }


    public void bind(Review review) {
        this.review = review;
        tvName.setText(review.getLogin());
    }
}

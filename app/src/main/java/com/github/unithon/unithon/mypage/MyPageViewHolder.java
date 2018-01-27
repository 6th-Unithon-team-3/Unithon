package com.github.unithon.unithon.mypage;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.util.PollyHelper;

public class MyPageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    AppCompatTextView tvName;

    private MyPage myPage;

    public MyPageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(v -> PollyHelper.getInstance().playPolly("클릭했어" + myPage.getLogin()));
    }


    public void bind(MyPage myPage) {
        this.myPage = myPage;
        tvName.setText(myPage.getLogin());
    }
}

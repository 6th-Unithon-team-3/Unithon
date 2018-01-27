package com.github.unithon.unithon.mypage;

import static com.github.unithon.unithon.home.RecommendFragment.KEY_RECOMMEND_BOOK;

import android.content.Intent;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.book.BookActivity;
import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.model.RecommendBook;

public class MyPageViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_name)
    AppCompatTextView tvName;

    @BindView(R.id.tv_author)
    AppCompatTextView tvAuthor;

    @BindView(R.id.tv_content)
    AppCompatTextView tvContent;

    @BindView(R.id.iv_book)
    AppCompatImageView ivBook;

    private MyPage myPage;

    public MyPageViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(MyPage myPage) {
        this.myPage = myPage;
        tvName.setText(myPage.title);
        tvAuthor.setText(myPage.author);
        tvContent.setText(myPage.content);

        Glide.with(itemView.getContext())
                .load(myPage.image)
                .into(ivBook);

        itemView.setOnClickListener(v -> {
            final RecommendBook recommendBook = new RecommendBook();
            recommendBook.setTitle(myPage.title);
            recommendBook.setAuthor(myPage.author);
            recommendBook.setImage(myPage.image);
            recommendBook.setIsbn(myPage.isbn);

            final Intent intent = new Intent(v.getContext(), BookActivity.class);
            intent.putExtra(KEY_RECOMMEND_BOOK, recommendBook);
            v.getContext().startActivity(intent);
        });
    }
}

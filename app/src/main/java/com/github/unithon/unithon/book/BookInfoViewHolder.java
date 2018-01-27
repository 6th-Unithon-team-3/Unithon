package com.github.unithon.unithon.book;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.ButterKnife;
import com.github.unithon.unithon.model.BookInfo;

public class BookInfoViewHolder extends RecyclerView.ViewHolder {

    private BookInfo bookInfo;

    public BookInfoViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }
}

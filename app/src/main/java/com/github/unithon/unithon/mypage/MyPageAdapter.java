package com.github.unithon.unithon.mypage;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.MyPage;
import java.util.ArrayList;
import java.util.List;

public class MyPageAdapter extends RecyclerView.Adapter<MyPageViewHolder> {

    private final List<MyPage> myPageList = new ArrayList<>();

    @Override
    public MyPageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        final View view = layoutInflater.inflate(R.layout.view_mypage, parent, false);
        final MyPageViewHolder myPageViewHolder = new MyPageViewHolder(view);

        return myPageViewHolder;
    }

    @Override
    public void onBindViewHolder(MyPageViewHolder holder, int position) {
        holder.bind(myPageList.get(position));
    }

    @Override
    public int getItemCount() {
        return myPageList.size();
    }

    public void setMyPageList(List<MyPage> myPageList) {
        this.myPageList.clear();
        this.myPageList.addAll(myPageList);
        notifyDataSetChanged();
    }
}

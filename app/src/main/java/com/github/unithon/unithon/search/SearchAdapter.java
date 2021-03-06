package com.github.unithon.unithon.search;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.SearchInfo;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends  RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private List<SearchInfo> mDataset = new ArrayList<>(); //MainActivity에 item class를 정의해 놓았음
    //private final List<MyPage> myPageList = new ArrayList<>();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // 사용될 항목들 선언
        public ImageView mPhoto;
        public TextView mBookname;
        public TextView mWriter;

        public ViewHolder(View v) {
            super(v);

            mBookname = (TextView) v.findViewById(R.id.search_Bookname);
            mWriter = (TextView) v.findViewById(R.id.search_writer);
            //mCode = (TextView) v.findViewById(R.id.search);
        }
    }

    // 생성자 - 넘어 오는 데이터파입에 유의해야 한다.
    public SearchAdapter(ArrayList<SearchInfo> myDataset) {
        mDataset = myDataset;
    }


    //뷰홀더
    // Create new views (invoked by the layout manager)
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_search, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mBookname.setText(mDataset.get(position).getModel_Bookname());
        holder.mWriter.setText(String.valueOf(mDataset.get(position).getModel_Writer())); //int를 가져온다는점 유의
        //holder.mEmail.setText(mDataset.get(position).getEmail());
        //holder.mPhoto.setImageBitmap(mDataset.get(position).getPhoto()); //첨부된 이미지를 연결해줘야 하는데 이건 또 복잡하다. 이건 나중에...

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setSearchList(List<SearchInfo> searchInfolist) {
        this.mDataset.clear();
        this.mDataset.addAll(searchInfolist);
        notifyDataSetChanged();
    }

}

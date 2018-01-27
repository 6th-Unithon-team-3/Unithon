package com.github.unithon.unithon.book;

import static com.github.unithon.unithon.home.RecommendFragment.KEY_RECOMMEND_BOOK;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.github.unithon.unithon.R;
import com.github.unithon.unithon.model.BookInfo;
import com.github.unithon.unithon.model.RecommendBook;
import com.github.unithon.unithon.model.Review;
import com.github.unithon.unithon.network.UnithonService;
import com.github.unithon.unithon.network.model.RecommendResponse;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookActivity extends AppCompatActivity {

    @BindView(R.id.rv_book)
    RecyclerView rvBook;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private BookAdapter bookAdapter = new BookAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);

        initializeToolbar();
        initializeRecyclerView();
        bindData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initializeToolbar() {
        setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
    }

    private void initializeRecyclerView() {
        rvBook.setLayoutManager(new LinearLayoutManager(this));
        rvBook.setAdapter(bookAdapter);
    }

    private void bindData() {

        UnithonService.getInstance().getRecommendResponse().enqueue(new Callback<RecommendResponse>() {
            @Override
            public void onResponse(Call<RecommendResponse> call, Response<RecommendResponse> response) {
                if(response.isSuccessful()) {

                    final RecommendResponse recommendResponse = response.body();


                }
            }

            @Override
            public void onFailure(Call<RecommendResponse> call, Throwable t) {

            }
        });

        bookAdapter.setBookInfo(BookInfo.getDummyBookInfo());
        bookAdapter.setReviewList(Review.getDummyReviewList());
    }
}

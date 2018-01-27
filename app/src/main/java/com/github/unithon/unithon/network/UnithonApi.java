package com.github.unithon.unithon.network;

import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.network.model.BookResponse;
import com.github.unithon.unithon.network.model.MyPageResponse;
import com.github.unithon.unithon.network.model.RecommendResponse;
import com.github.unithon.unithon.network.model.SearchResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UnithonApi {

    @GET("/recommend_book")
    Call<RecommendResponse> getRecommendRespose();

    @GET("/search_book/search/book")
    Call<SearchResponse> getSearchResponse(@Query("query") String isbn);

    @FormUrlEncoded
    @POST("/get_my_review")
    Call<MyPageResponse> getMyPages(@Field("id") String id);

    @FormUrlEncoded
    @POST("/get_book_review")
    Call<BookResponse> getBookResponse(@Field("isbn") String isbn);
}

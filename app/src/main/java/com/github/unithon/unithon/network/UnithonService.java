package com.github.unithon.unithon.network;

import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.network.model.BookResponse;
import com.github.unithon.unithon.network.model.MyPageResponse;
import com.github.unithon.unithon.network.model.RecommendResponse;
import com.github.unithon.unithon.network.model.SearchResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnithonService {

    private static final UnithonService ourInstance = new UnithonService();

    private UnithonApi unithonApi;

    public static UnithonService getInstance() {
        return ourInstance;
    }

    private UnithonService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://13.124.181.246:44443/") // Server url
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        unithonApi = retrofit.create(UnithonApi.class);
    }

    public Call<RecommendResponse> getRecommendResponse() {
        return unithonApi.getRecommendRespose();
    }

    public Call<SearchResponse> getSearchResponse(String isbn) {
        return unithonApi.getSearchResponse(isbn);
    }

    public Call<BookResponse> getBookResponse(String isbn) {
        return unithonApi.getBookResponse(isbn);
    }

    public Call<MyPageResponse> getMyPages(String id) {
        return unithonApi.getMyPages(id);
    }

}

package com.github.unithon.unithon.network;

import com.github.unithon.unithon.model.Review;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UnithonApi {

    @GET("/users")
    Call<List<Review>> getReviews();
}

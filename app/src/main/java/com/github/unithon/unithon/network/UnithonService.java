package com.github.unithon.unithon.network;

import com.github.unithon.unithon.model.Review;
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
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        unithonApi = retrofit.create(UnithonApi.class);
    }

    public Call<List<Review>> getReviews() {
        return unithonApi.getReviews();
    }

}

package com.github.unithon.unithon.network;

import com.github.unithon.unithon.model.MyPage;
import com.github.unithon.unithon.model.SearchInfo;

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
                .baseUrl("https://api.github.com/") // Github url
//                .baseUrl("http://13.124.181.246:44443") // Server url
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        unithonApi = retrofit.create(UnithonApi.class);
    }

    public Call<List<MyPage>> getMyPages() {
        return unithonApi.getMyPages();
    }

    public Call<List<SearchInfo>> getSearchInfo()
    {
        return unithonApi.getSearchInfo();
    }


}

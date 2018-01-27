package com.github.unithon.unithon.network;

import com.github.unithon.unithon.model.MyPage;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UnithonApi {

    @GET("/users")
    Call<List<MyPage>> getMyPages();
}

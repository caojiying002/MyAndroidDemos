package org.jiying.demo.token;

import org.jiying.demo.token.response.NormalResponse;
import org.jiying.demo.token.response.TokenResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("request")
    Call<NormalResponse> normalRequest(@Query("token") String token);

    @GET("get_token")
    Call<TokenResponse> getToken();

    @GET("refresh_token")
    Call<TokenResponse> refreshToken();
}

package org.jiying.demo.token;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClient {

    private static RetrofitApiClient mClient = new RetrofitApiClient();
    public static RetrofitApiClient getInstance() {
        return mClient;
    }

    private RetrofitService mService;

    private String mToken;

    private RetrofitApiClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8888/")
                .build();
        mService = retrofit.create(RetrofitService.class);
    }

    public RetrofitService getService() {
        return mService;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }
}

package org.jiying.demo.token;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.jiying.demo.token.response.NormalResponse;
import org.jiying.demo.token.response.TokenResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RetrofitService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = RetrofitApiClient.getInstance().getService();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_request:
                mService.normalRequest(RetrofitApiClient.getInstance().getToken())
                        .enqueue(new Callback<NormalResponse>() {
                            @Override
                            public void onResponse(Call<NormalResponse> call, Response<NormalResponse> response) {
                                Log.i("Retrofit", "" + response);
                                if (response.body().success) {
                                    Toast.makeText(MainActivity.this, "result = " + response.body().data.result, Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(MainActivity.this, "error_code = " + response.body().error_code, Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<NormalResponse> call, Throwable t) {
                                Log.w("Retrofit", Log.getStackTraceString(t));
                            }
                        });
                break;
            case R.id.button_token:
                mService.getToken()
                        .enqueue(new Callback<TokenResponse>() {
                            @Override
                            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                                Log.i("Retrofit", "" + response);
                                RetrofitApiClient.getInstance().setToken(response.body().data.token);
                            }

                            @Override
                            public void onFailure(Call<TokenResponse> call, Throwable t) {
                                Log.w("Retrofit", Log.getStackTraceString(t));
                            }
                        });
                break;
        }
    }
}

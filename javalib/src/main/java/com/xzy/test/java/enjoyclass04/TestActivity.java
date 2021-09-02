package com.xzy.test.java.enjoyclass04;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.xzy.test.javademo.R;
import com.xzy.test.javademo.enjoyclass04.api.EnjoyWeatherApi;
import com.xzy.test.javademo.enjoyclass04.api.WeatherApi;
import com.xzy.test.javademo.enjoyclass04.retrofit.EnjoyRetrofit;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * 使用注解、反射、动态代理实现类似 Retrofit 的功能
 *
 * @author xzy
 */
public class TestActivity extends AppCompatActivity {

    private WeatherApi weatherApi;
    private static final String TAG = "MainActivity";
    private EnjoyWeatherApi enjoyWeatherApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://restapi.amap.com")
                .build();

        weatherApi = retrofit.create(WeatherApi.class);

        EnjoyRetrofit enjoyRetrofit = new EnjoyRetrofit.Builder().baseUrl("https://restapi.amap.com").build();
        enjoyWeatherApi = enjoyRetrofit.create(EnjoyWeatherApi.class);
    }


    public void get(View view) {
        Call<ResponseBody> call = weatherApi.getWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    try {
                        String string = body.string();
                        Log.i(TAG, "onResponse get: " + string);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        body.close();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void post(View view) {
        Call<ResponseBody> call = weatherApi.postWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody body = response.body();
                try {
                    String string = body.string();
                    Log.i(TAG, "onResponse post: " + string);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    body.close();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void enjoyGet(View view) {
        okhttp3.Call call = enjoyWeatherApi.getWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                Log.i(TAG, "onResponse enjoy get: " + response.body().string());
                response.close();
            }
        });

    }

    public void enjoyPost(View view) {
        okhttp3.Call call = enjoyWeatherApi.postWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b");
        call.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, okhttp3.Response response) throws IOException {
                Log.i(TAG, "onResponse enjoy post: " + response.body().string());
                response.close();
            }
        });
    }
}

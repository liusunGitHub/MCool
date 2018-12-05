package com.lovego.mcool.di.module;

import com.lovego.mcool.di.scope.ApiUrl;
import com.lovego.mcool.model.http.HttpApi;
import com.lovego.mcool.model.http.ProtocolHttp;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lgs on 2018/11/22.
 */
@Module
public class HttpModule {
    @Provides
    @Singleton
    OkHttpClient.Builder providesOkHttpHelper() {
//请求读写超时时间
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS);
    }

    @Provides
    @Singleton
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        return builder
//        .addInterceptor(new MyHttpInterceptor())
                .build();
    }

    @Provides
    @Singleton
    Retrofit.Builder providesRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    @Singleton
    HttpApi provideApi(@ApiUrl Retrofit retrofit) {
        return retrofit.create(HttpApi.class);
    }

    @Provides
    @Singleton
    @ApiUrl
    Retrofit providesApiRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, ProtocolHttp.HTTP_HOST);//这里就是你的网络请求的url
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String host) {
        return builder.client(client)
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())//添加gson自动解析，我们不用关
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}

package com.lovego.mcool.model.http;

import org.reactivestreams.Publisher;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lgs on 2018/11/30.
 */
public class MyRxUtils {
    /**
     * 从其他线程转到主线程.
     *
     * @param scheduler Schedulers.io()等等
     * @param <T>       t
     * @return FlowableTransformer
     */
    public static <T> FlowableTransformer<T, T> toMain(final Scheduler scheduler) {
        return new FlowableTransformer<T, T>() {
            @Override
            public Publisher<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(scheduler)
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> FlowableTransformer<HttpResult<T>, T> handResult() {

        return new FlowableTransformer<HttpResult<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<HttpResult<T>> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread()).flatMap(new Function<HttpResult<T>, Publisher<T>>() {
                            @Override
                            public Publisher<T> apply(HttpResult<T> tHttpResult) throws Exception {

                                if (tHttpResult.getCode() == HttpCode.SUCCESS) {
                                    return /*createData(tHttpResult.data)*/Flowable.just(tHttpResult.getData());
                                } else {
                                    return Flowable.error(new ApiException(tHttpResult.getCode(), tHttpResult.getMsg()));
                                }
                            }
                        });
            }
        };

    }


}

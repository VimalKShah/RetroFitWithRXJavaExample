package com.example.retrofitwithrxjavaexample;

import io.reactivex.Observable;

import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    @GET("{coin}-usd")
    Observable<Crypto> getCoinData(@Path("coin") String coin);
}

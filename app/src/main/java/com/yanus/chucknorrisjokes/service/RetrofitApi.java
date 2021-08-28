package com.yanus.chucknorrisjokes.service;
import com.yanus.chucknorrisjokes.model.JokesModel;
import com.yanus.chucknorrisjokes.utils.Credentials;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {


    @GET(Credentials.RANDOM_JOKE_URL)
    Call<JokesModel> getRandomJoke();

    @GET(Credentials.JOKE_CATEGORY_URL)
    Call<ArrayList<String>> getJokeCategory();

    @GET("/jokes/random")
    Call<JokesModel> getJokeByCategory(@Query("category") String category);


}

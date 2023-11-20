package com.example.dsa_project_android.Manager;
import java.util.List;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Manager {

    String URL = "http://10.0.2.2:8080/dsaApp/";

    //----------------------------------------------------------------------------------------------

    //Posibles acciones realizables
    @GET("/dsaApp/tracks")
    Call<List<Song>> songs();

    @GET("/dsaApp/tracks/{id}")
    Call<List<Song>> songsID(@Path("id") String varId);

    @DELETE("/dsaApp/tracks/{id}")
    Call<Void> responseDelete(@Path("id") String varIdDel);

    @POST("/dsaApp/tracks")
    Call<Song> createSong(@Body Song varSongCreated);

    @PUT("/dsaApp/tracks")
    Call<Void> updateSong(@Body Song varSongCreated);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
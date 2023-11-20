package dsa.upc.edu.dsa_project_android.Manager;

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

    String URL = "http://10.0.2.2:8080/dsaApp/pixelRush/";

    //----------------------------------------------------------------------------------------------

    //Posibles acciones realizables
    @GET("getObjectListFromStore")
    Call<List<StoreObject>> objects();

    @POST("registerNewUser")
    Call<Void> newUser(@Body User newUser);

    @POST("login")
    Call<Boolean> user(@Body String username,@Body String password);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
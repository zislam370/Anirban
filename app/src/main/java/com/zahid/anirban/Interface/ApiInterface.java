package com.zahid.anirban.Interface;

import com.zahid.anirban.Model.ServerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Zahid on 05-Jun-17.
 */

public interface ApiInterface {


    //This method is used for "POST"
//    @FormUrlEncoded
//    @POST("/api.php")
//    Call<ServerResponse> post(
//            @Field("method") String method,
//            @Field("username") String username,
//            @Field("password") String password
//    );

    //This method is used for "GET"
    @GET("GetUserByUserName")
    Call<ServerResponse> get(
            //@Query("method") String method,
            @Query("userName") String username,
            @Query("password") String password,
            @Query("orgCode") String orgcode
    );


}

package com.tqeil.couplesenppai.Model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface retrofit_interface {
    @POST("user/register")
    Call<JSONObject> SignUp(@Body JSONObject body
    );
    @POST("user/login")
    Call<JSONObject> Login(@Body JSONObject body
    );


}

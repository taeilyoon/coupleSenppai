package com.tqeil.couplesenppai.ui.main

import android.app.Activity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.tqeil.couplesenppai.ApplicationClass.Companion.retrofit
import com.tqeil.couplesenppai.Model.retrofit_interface
import com.tqeil.couplesenppai.R
import kotlinx.android.synthetic.main.activity_logina.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import java.util.HashMap
import javax.security.auth.callback.Callback



class LoginaActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logina)
        loginButton.setOnClickListener {
            var id =idEditText.text.toString()
            var pw =passwordEditText.text.toString()

            //TODO:: Dialog


            val body = JSONObject()     //JSON 오브젝트의 body 부분
            body.put("id", id)   //body부분 생성 시작
            body.put("pw", pw);

            val service = retrofit.create(retrofit_interface::class.java)
            val call :Call<JSONObject> = service.Login(body)
            call.enqueue(object : retrofit2.Callback<JSONObject> {
                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                    Log.d("Login", "onResponse: " + response.body()!!.get("success"))
                }

                override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                    Log.d("Login", "onResponse: Fail$call\n$t")

                }

            })



        }

    }


}

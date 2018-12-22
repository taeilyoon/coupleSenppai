package com.tqeil.couplesenppai

import android.app.Application
import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.function.Consumer

class ApplicationClass : Application() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate() {
        super.onCreate()


    }

    companion object {
        var retrofit = Retrofit.Builder()
            .baseUrl("http://207.148.88.110:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

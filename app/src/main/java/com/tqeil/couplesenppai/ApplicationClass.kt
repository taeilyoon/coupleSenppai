package com.tqeil.couplesenppai

import android.app.Application
import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import java.util.function.Consumer

class ApplicationClass : Application() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate() {
        super.onCreate()


    }

    companion object {
//        var retrofit = Retrofit.Builder()
//            .baseUrl("https://")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
    }
}

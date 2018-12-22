package com.tqeil.couplesenppai.Utils

import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import cn.pedant.SweetAlert.SweetAlertDialog


fun AppCompatActivity.Toast(str : String) {
    Toast.makeText(applicationContext, str, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.sweetDialog(str : String, style: Int = SweetAlertDialog.NORMAL_TYPE) {
    SweetAlertDialog(this, style)
            .setTitleText(str)
            .show();
}


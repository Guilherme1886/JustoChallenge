package com.gui.antonio.randomuserapp.network

import com.google.gson.Gson
import com.gui.antonio.randomuserapp.data.model.UserDataModel
import com.gui.antonio.randomuserapp.helper.transformToModel
import okhttp3.*
import java.io.IOException

object NetworkClient {

    val gson = Gson()
    private val client = OkHttpClient()
    private val request = Request.Builder()
        .url("https://randomuser.me/api/")
        .build()

    fun getUsers(callback: (UserDataModel) -> Unit) {
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                try {
                    response.body?.string()?.transformToModel<UserDataModel>()?.let {
                        callback.invoke(it)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call, e: IOException) {}
        })
    }
}
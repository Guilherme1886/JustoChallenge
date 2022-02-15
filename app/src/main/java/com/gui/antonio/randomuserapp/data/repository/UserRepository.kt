package com.gui.antonio.randomuserapp.data.repository

import com.google.gson.Gson
import com.gui.antonio.randomuserapp.data.model.UserDataModel
import com.gui.antonio.randomuserapp.data.model.UserResultsModel
import okhttp3.*
import java.io.IOException


class UserRepository {

    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://randomuser.me/api/")
        .build()

    fun getUsersResult(callback: (UserDataModel) -> Unit) {
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val gson = Gson()
                try {
                    val g = gson.fromJson(response.body?.string(), UserDataModel::class.java)
                    callback.invoke(g)
                    println("results: ${g.results}")
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("exception: $e")
            }
        })
    }
}
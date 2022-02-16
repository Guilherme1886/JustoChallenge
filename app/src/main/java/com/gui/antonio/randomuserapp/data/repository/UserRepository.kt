package com.gui.antonio.randomuserapp.data.repository

import com.gui.antonio.randomuserapp.data.model.UserDataModel
import com.gui.antonio.randomuserapp.network.NetworkClient

class UserRepository {

    fun getUsersResult(callback: (UserDataModel) -> Unit) {
        NetworkClient.run {
            getUsers {
                callback.invoke(it)
            }
        }
    }
}
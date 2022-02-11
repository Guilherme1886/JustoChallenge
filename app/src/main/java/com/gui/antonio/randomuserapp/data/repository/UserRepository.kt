package com.gui.antonio.randomuserapp.data.repository

import com.gui.antonio.randomuserapp.data.model.UserDataModel
import com.gui.antonio.randomuserapp.data.model.UserResultsModel

class UserRepository {

    fun getUsersResult(): UserDataModel {
        val results = mutableListOf<UserResultsModel>()
        repeat(10) {
            results.add(
                UserResultsModel(
                    gender = "Male"
                )
            )
        }
        return UserDataModel(
            results = results
        )
    }

}
package com.gui.antonio.randomuserapp.helper

import com.gui.antonio.randomuserapp.data.model.UserDataModel
import com.gui.antonio.randomuserapp.network.NetworkClient
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel
import java.text.SimpleDateFormat
import kotlin.random.Random

fun UserDataModel.fromDataToUi() = this.results?.map {
    UserUiModel(
        id = Random.nextInt(),
        titleName = it.name?.title,
        firstName = it.name?.first,
        lastName = it.name?.last,
        city = it.location?.city,
        state = it.location?.state,
        country = it.location?.country,
        email = it.email,
        age = it.dob?.age,
        registeredDate = it.registered?.date,
        picture = it.picture?.large,
    )
}?.toMutableList() ?: mutableListOf()

inline fun <reified T> String.transformToModel() = NetworkClient.gson.fromJson(this, T::class.java)

val yyyyMMddFormat = SimpleDateFormat("yyyy-MM-dd")
val ddMMyyyyFormat = SimpleDateFormat("dd-MM-yyyy")

fun String.getDateFormatted(): String? {
    return yyyyMMddFormat.parse(this)?.run {
        yyyyMMddFormat.format(this)
    }
}




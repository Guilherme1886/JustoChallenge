package com.gui.antonio.randomuserapp.data.model

data class UserResultsModel(
    val gender: String? = null,
    val name: UserNameModel? = null,
    val location: UserLocationModel? = null,
    val email: String? = null,
    val login: UserLoginModel? = null,
    val dob: UserAnniversaryModel? = null,
    val registered: UserRegisteredModel? = null,
    val phone: String? = null,
    val cell: String? = null,
    val id: UserIdModel? = null,
    val picture: UserPictureModel? = null,
    val nat: String? = null
)
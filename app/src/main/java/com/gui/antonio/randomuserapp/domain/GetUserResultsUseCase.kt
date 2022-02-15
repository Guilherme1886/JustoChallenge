package com.gui.antonio.randomuserapp.domain

import com.gui.antonio.randomuserapp.data.repository.UserRepository
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel
import kotlin.random.Random

class GetUserResultsUseCase(private val userRepository: UserRepository) {
    operator fun invoke(callback: (MutableList<UserUiModel>) -> Unit) {
        userRepository.getUsersResult {
            val results = it.results?.map {
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
            }?.toMutableList()
            callback.invoke(results ?: mutableListOf())
        }
    }
}
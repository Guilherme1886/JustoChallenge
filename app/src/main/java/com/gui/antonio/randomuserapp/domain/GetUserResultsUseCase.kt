package com.gui.antonio.randomuserapp.domain

import com.gui.antonio.randomuserapp.data.repository.UserRepository
import com.gui.antonio.randomuserapp.helper.fromDataToUi
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel
import kotlin.random.Random

class GetUserResultsUseCase(private val userRepository: UserRepository) {
    operator fun invoke(callback: (MutableList<UserUiModel>) -> Unit) {
        userRepository.getUsersResult {
            val results = it.fromDataToUi()
            callback.invoke(results)
        }
    }
}
package com.gui.antonio.randomuserapp.domain

import com.gui.antonio.randomuserapp.data.repository.UserRepository
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel
import kotlin.random.Random

class GetUserResultsUseCase(private val userRepository: UserRepository) {
    operator fun invoke() = userRepository.getUsersResult().results?.map {
        UserUiModel(
            id = Random.nextInt(),
            gender = it.gender
        )
    }?.toMutableList()
}
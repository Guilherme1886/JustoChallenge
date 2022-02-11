package com.gui.antonio.randomuserapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gui.antonio.randomuserapp.data.repository.UserRepository
import com.gui.antonio.randomuserapp.domain.GetUserResultsUseCase

class UserViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val userRepository = UserRepository()
        val getUserResultsUseCase = GetUserResultsUseCase(userRepository)
        return UserViewModel(getUserResultsUseCase) as T
    }

}

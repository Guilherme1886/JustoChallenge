package com.gui.antonio.randomuserapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gui.antonio.randomuserapp.domain.GetUserResultsUseCase
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel

class UserViewModel(
    private val getUserResultsUseCase: GetUserResultsUseCase
) : ViewModel() {

    private val _userResultsLiveData = MutableLiveData<MutableList<UserUiModel>>()
    var userResultsLiveData: LiveData<MutableList<UserUiModel>> = _userResultsLiveData

    fun getUsers() {
        getUserResultsUseCase {
            _userResultsLiveData.postValue(it)
        }
    }

}
package com.gui.antonio.randomuserapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.gui.antonio.randomuserapp.databinding.ActivityUsersBinding
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel
import com.gui.antonio.randomuserapp.presentation.ui.adapter.UsersAdapter
import com.gui.antonio.randomuserapp.presentation.viewmodel.UserViewModel
import com.gui.antonio.randomuserapp.presentation.viewmodel.UserViewModelFactory

class UsersActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels { UserViewModelFactory() }
    private var binding: ActivityUsersBinding? = null
    private var usersAdapter: UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBinding()
        setContentView(binding?.root)
        setupView()
        setObservers()
        userViewModel.getUsers()
    }

    private fun setupView() {
        setupRecycler()
    }

    private fun setupRecycler() {
        usersAdapter = UsersAdapter()
        binding?.apply {
            usersRecycler.setHasFixedSize(true)
            usersRecycler.adapter = usersAdapter
        }
    }

    private fun setObservers() {
        userViewModel.userResultsLiveData.observe(this, ::showUsers)
    }

    private fun showUsers(it: MutableList<UserUiModel>) {
        usersAdapter?.submitList(it)
    }

    private fun setupBinding() {
        binding = ActivityUsersBinding.inflate(layoutInflater)
    }

}
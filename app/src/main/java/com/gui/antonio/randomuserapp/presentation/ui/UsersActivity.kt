package com.gui.antonio.randomuserapp.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.gui.antonio.randomuserapp.R
import com.gui.antonio.randomuserapp.databinding.ActivityUsersBinding
import com.gui.antonio.randomuserapp.presentation.viewmodel.UserViewModel
import com.gui.antonio.randomuserapp.presentation.viewmodel.UserViewModelFactory

class UsersActivity : AppCompatActivity() {

    private val userViewModel: UserViewModel by viewModels {
        UserViewModelFactory()
    }
    private var binding: ActivityUsersBinding? = null
    private var usersAdapter: UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        userViewModel.getUsers()
        userViewModel.userResultsLiveData.observe(this) {
            usersAdapter = UsersAdapter().apply {
                submitList(it)
            }
            binding?.usersRecycler?.setHasFixedSize(true)
            binding?.usersRecycler?.adapter = usersAdapter
        }
    }

}
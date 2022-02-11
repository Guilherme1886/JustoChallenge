package com.gui.antonio.randomuserapp.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.gui.antonio.randomuserapp.databinding.ItemUserBinding
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel
import com.gui.antonio.randomuserapp.presentation.ui.viewholder.UserViewHolder

class UsersAdapter : ListAdapter<UserUiModel, UserViewHolder>(UserDiffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object UserDiffUtilCallback : DiffUtil.ItemCallback<UserUiModel>() {
        override fun areItemsTheSame(oldItem: UserUiModel, newItem: UserUiModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserUiModel, newItem: UserUiModel): Boolean {
            return oldItem == newItem
        }
    }
}




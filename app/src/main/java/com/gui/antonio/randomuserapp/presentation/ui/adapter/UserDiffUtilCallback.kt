package com.gui.antonio.randomuserapp.presentation.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel

class UserDiffUtilCallback : DiffUtil.ItemCallback<UserUiModel>() {
    override fun areItemsTheSame(oldItem: UserUiModel, newItem: UserUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserUiModel, newItem: UserUiModel): Boolean {
        return oldItem == newItem
    }
}
package com.gui.antonio.randomuserapp.presentation.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.gui.antonio.randomuserapp.databinding.ItemUserBinding
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserUiModel) {
        binding.textView.text =
            "I am title, first, last from city, state, country. My email is email, i have age and i am have my register since date"
    }

}

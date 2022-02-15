package com.gui.antonio.randomuserapp.presentation.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gui.antonio.randomuserapp.databinding.ItemUserBinding
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserUiModel) {
        with(item) {
            Glide.with(itemView).load(picture).into(binding.imageView)
            binding.textView.text =
                "I am $titleName, $firstName, $lastName from $city, $state, " +
                        "$country. My email is $email, i have $age and i am have my register since $registeredDate"
        }
    }
}

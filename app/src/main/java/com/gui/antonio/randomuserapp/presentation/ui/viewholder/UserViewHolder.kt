package com.gui.antonio.randomuserapp.presentation.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gui.antonio.randomuserapp.R
import com.gui.antonio.randomuserapp.databinding.ItemUserBinding
import com.gui.antonio.randomuserapp.helper.getDateFormatted
import com.gui.antonio.randomuserapp.presentation.model.UserUiModel
import java.text.SimpleDateFormat

class UserViewHolder(private val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: UserUiModel) {
        with(item) {
            binding.apply {
                Glide.with(itemView).load(picture).into(imageView)
                textView.text = itemView.context.getString(
                    R.string.info_about_user,
                    titleName,
                    firstName,
                    lastName,
                    city,
                    state,
                    country,
                    email,
                    age,
                    registeredDate?.getDateFormatted()
                )
            }
        }
    }
}

package com.bitcode.a17_02_25_mvvm_demousingretrofit.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitcode.a17_02_25_mvvm_demousingretrofit.R
import com.bitcode.a17_02_25_mvvm_demousingretrofit.databinding.UserViewBinding
import com.bitcode.a17_02_25_mvvm_demousingretrofit.models.User

class UsersAdapter(private val users : ArrayList<User>) :
    RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val userViewBinding : UserViewBinding
        init {
            userViewBinding = UserViewBinding.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.user_view,null)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val eachUser = users[position]
        holder.userViewBinding.user = eachUser
    }

    override fun getItemCount(): Int {
       return users.size
    }
}
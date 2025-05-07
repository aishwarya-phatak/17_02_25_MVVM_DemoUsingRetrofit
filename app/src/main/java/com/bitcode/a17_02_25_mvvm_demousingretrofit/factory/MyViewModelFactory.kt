package com.bitcode.a17_02_25_mvvm_demousingretrofit.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bitcode.a17_02_25_mvvm_demousingretrofit.repository.UsersRepository
import com.bitcode.a17_02_25_mvvm_demousingretrofit.viewmodels.UserViewModel

class MyViewModelFactory(private val usersRepository: UsersRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(usersRepository) as T
    }
}
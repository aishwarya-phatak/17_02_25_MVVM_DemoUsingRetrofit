package com.bitcode.a17_02_25_mvvm_demousingretrofit.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitcode.a17_02_25_mvvm_demousingretrofit.models.User
import com.bitcode.a17_02_25_mvvm_demousingretrofit.repository.UsersRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(private val usersRepository: UsersRepository) : ViewModel(){
    val usersUpdateAvailableLiveData = MutableLiveData<Boolean>()
    var users = ArrayList<User>()
    var pageNumber = 0

    fun fetchUsers(){
        CoroutineScope(Dispatchers.IO).launch {
            var users = usersRepository.fetchAllUsers(++pageNumber)

            withContext(Dispatchers.Main){
                this@UserViewModel.users.addAll(users)
                usersUpdateAvailableLiveData.postValue(true)
            }
        }
    }
}
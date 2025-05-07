package com.bitcode.a17_02_25_mvvm_demousingretrofit.repository

import com.bitcode.a17_02_25_mvvm_demousingretrofit.models.User
import com.bitcode.a17_02_25_mvvm_demousingretrofit.network.UserApiService

class UsersRepository(private val userApiService: UserApiService) {
    suspend fun fetchAllUsers(pageNumber : Int) : ArrayList<User>{
        return userApiService.getAllUsers(pageNumber).users
    }
}
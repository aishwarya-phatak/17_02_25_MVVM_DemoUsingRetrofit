package com.bitcode.a17_02_25_mvvm_demousingretrofit.network

import com.bitcode.a17_02_25_mvvm_demousingretrofit.models.UserResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface UserApiService {

    @GET("users")
    suspend fun getAllUsers(@Query("page") pageNumber : Int) : UserResponse

    companion object {
        private var userApiService : UserApiService? = null

        fun getInstance() : UserApiService{

            if (userApiService == null){
                var retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                userApiService = retrofit.create(UserApiService::class.java)
            }
            return userApiService!!
        }
    }
}
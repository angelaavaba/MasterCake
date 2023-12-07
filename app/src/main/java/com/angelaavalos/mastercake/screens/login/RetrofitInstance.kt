package com.angelaavalos.mastercake.screens.login

import com.angelaavalos.mastercake.screens.home.models.Category
import com.angelaavalos.mastercake.screens.home.network.CategoryService
import com.angelaavalos.mastercake.screens.home.network.ProductService
import com.angelaavalos.mastercake.screens.login.network.LoginService
import com.angelaavalos.mastercake.screens.register.network.RegisterService
import com.angelaavalos.mastercake.screens.user.network.UserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {
    private const val BASE_URL = "https://kind-lime-meerkat-gear.cyclic.app/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginService: LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }

    val registerService: RegisterService by lazy {
        retrofit.create(RegisterService::class.java)
    }

    val productService: ProductService by lazy {
        retrofit.create(ProductService::class.java)
    }

    val categoryService: CategoryService by lazy {
        retrofit.create(CategoryService::class.java)
    }

    val userService: UserService by lazy {
        retrofit.create(UserService::class.java)
    }

}
package com.gulsahozaltun.armutproject.retrofit

import com.gulsahozaltun.armutproject.entity.*
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST


interface DaoInterface {
    @GET("home")
    fun allServices(): Call<AllServicesAnswer>

    @GET("home")
    fun popularServices(): Call<PopularAnswer>

    @GET("home")
    fun postsServices(): Call<PostsAnswer>

    @POST("service")
    fun getDetail(@Field("id")id:Int):Call<List<DetailEntity>>
}
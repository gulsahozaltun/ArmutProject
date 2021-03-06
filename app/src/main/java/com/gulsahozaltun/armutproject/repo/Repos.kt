package com.gulsahozaltun.armutproject.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.AsyncListUtil
import com.gulsahozaltun.armutproject.entity.*
import com.gulsahozaltun.armutproject.retrofit.ApiUtils
import com.gulsahozaltun.armutproject.retrofit.DaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repos {
    private val daoInterface: DaoInterface
    private val Alllist: MutableLiveData<List<AllServices>>
    private val popularListe: MutableLiveData<List<Popular>>
    private val postsListe: MutableLiveData<List<Posts>>
    private val detailList: MutableLiveData<List<DetailEntity>>

    init {
        daoInterface = ApiUtils.getAllServives()
        Alllist = MutableLiveData()
        popularListe = MutableLiveData()
        postsListe = MutableLiveData()
        detailList = MutableLiveData()
    }

    fun bringServices(): MutableLiveData<List<AllServices>> {
        return Alllist
    }

    fun bringPopular(): MutableLiveData<List<Popular>> {
        return popularListe
    }

    fun bringPosts(): MutableLiveData<List<Posts>> {
        return postsListe
    }

    fun bringDetails(): MutableLiveData<List<DetailEntity>> {
        return detailList
    }

    fun getAllServices() {
        daoInterface.allServices().enqueue(object : retrofit2.Callback<AllServicesAnswer> {
            override fun onResponse(
                call: Call<AllServicesAnswer>?,
                response: Response<AllServicesAnswer>
            ) {
                val list: List<AllServices> = response.body().all_services
                Alllist.value = list
                Log.e("calisiyormu in Repo", "we will see!!!!")

            }

            override fun onFailure(call: Call<AllServicesAnswer>?, t: Throwable?) {
                Log.e("Error", "failed")
            }
        })
    }

    fun getPopularServices() {
        daoInterface.popularServices().enqueue(object : retrofit2.Callback<PopularAnswer> {
            override fun onResponse(
                call: Call<PopularAnswer>?,
                response: Response<PopularAnswer>?
            ) {
                val popularList: List<Popular> = response!!.body().popular
                popularListe.value = popularList
            }

            override fun onFailure(call: Call<PopularAnswer>?, t: Throwable?) {
                TODO("Not yet implemented")
            }
        })
    }

    fun getPostst() {
        daoInterface.postsServices().enqueue(object : retrofit2.Callback<PostsAnswer> {
            override fun onResponse(call: Call<PostsAnswer>?, response: Response<PostsAnswer>?) {
                val postsList: List<Posts> = response!!.body().posts
                postsListe.value = postsList
            }

            override fun onFailure(call: Call<PostsAnswer>?, t: Throwable?) {
                TODO("Not yet implemented")
            }

        })
    }

    fun getService(id: Int, getDataCallback: GetDataCallback){
        daoInterface.getService(id).enqueue(object : Callback<ServiceDetail> {
            override fun onResponse(call: Call<ServiceDetail>?, response: Response<ServiceDetail>) {
                if (response.isSuccessful) {
                    getDataCallback.onGetServiceDetail(response.body())
                } else {
                    getDataCallback.onError()
                }
            }

            override fun onFailure(call: Call<ServiceDetail>?, t: Throwable?) {
                Log.e("failure", t.toString())
            }
        })
    }
}



interface GetDataCallback {
    fun onGetServiceDetail(serviceDetail: ServiceDetail?)
    fun onError()
}
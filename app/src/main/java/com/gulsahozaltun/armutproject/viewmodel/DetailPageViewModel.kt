package com.gulsahozaltun.armutproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.armutproject.entity.AllServices
import com.gulsahozaltun.armutproject.entity.DetailEntity
import com.gulsahozaltun.armutproject.entity.Popular
import com.gulsahozaltun.armutproject.entity.Posts
import com.gulsahozaltun.armutproject.repo.Repos

class DetailPageViewModel:ViewModel(){
    private val repo= Repos()
    //val allServicesList: MutableLiveData<List<DetailEntity>>

  /*  init {
        allServicesList=repo.bringDetails()

    }*/
    fun loadDetail(){

    }
}
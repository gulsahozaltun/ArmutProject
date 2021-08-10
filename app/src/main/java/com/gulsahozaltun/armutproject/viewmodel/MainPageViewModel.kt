package com.gulsahozaltun.armutproject.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsahozaltun.armutproject.entity.AllServices
import com.gulsahozaltun.armutproject.entity.Popular
import com.gulsahozaltun.armutproject.entity.Posts
import com.gulsahozaltun.armutproject.repo.Repos

class MainPageViewModel:ViewModel() {
    private val repo=Repos()
    val allServicesList:MutableLiveData<List<AllServices>>
    val popularServicesList:MutableLiveData<List<Popular>>
    val postServiceList:MutableLiveData<List<Posts>>
    init {
        loadServices()
        loadPopular()
        loadPosts()
        allServicesList=repo.bringServices()
        popularServicesList=repo.bringPopular()
        postServiceList=repo.bringPosts()
    }
    fun loadServices(){
        repo.getAllServices()
    }
    fun loadPopular(){
        repo.getPopularServices()
    }

    fun loadPosts(){
        repo.getPostst()
    }





}
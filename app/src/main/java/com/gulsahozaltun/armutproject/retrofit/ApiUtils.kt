package com.gulsahozaltun.armutproject.retrofit

import android.util.Log
import com.gulsahozaltun.armutproject.retrofit.RetrofitClient.Companion.getClient

class ApiUtils {
    companion object{
        //bu url ile Dao daki url birlesip calisacak
        val BASE_URL:String="https://my-json-server.typicode.com/engincancan/case/"

        fun getAllServives(): DaoInterface {
            return getClient(BASE_URL).create(DaoInterface::class.java)
            Log.e("calisiyormu","we will see!!!!")
        }

    }
}
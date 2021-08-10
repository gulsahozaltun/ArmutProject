package com.gulsahozaltun.armutproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Posts(
    @SerializedName("link")
    @Expose var link:String,
    @SerializedName("title")
    @Expose var title:String,
    @SerializedName("category")
    @Expose var category:String,
    @SerializedName("image_url")
    @Expose var image_url:String
):Serializable {

}


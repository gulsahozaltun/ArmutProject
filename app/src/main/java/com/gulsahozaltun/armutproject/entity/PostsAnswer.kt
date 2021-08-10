package com.gulsahozaltun.armutproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostsAnswer(
    @SerializedName("posts")
    @Expose var posts:List<Posts>
) {
}
package com.gulsahozaltun.armutproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PopularAnswer(
    @SerializedName("popular")
    @Expose var popular:List<Popular>
) {
}
package com.gulsahozaltun.armutproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AllServicesAnswer(
    @SerializedName("all_services")
    @Expose var all_services:List<AllServices>

) {
}
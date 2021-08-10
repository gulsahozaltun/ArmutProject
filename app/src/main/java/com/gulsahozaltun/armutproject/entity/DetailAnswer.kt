package com.gulsahozaltun.armutproject.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DetailAnswer(
    @SerializedName("service")
    @Expose var service:List<DetailEntity>
) {}
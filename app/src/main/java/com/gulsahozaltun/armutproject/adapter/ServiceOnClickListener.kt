package com.gulsahozaltun.armutproject.adapter

import android.app.Service
import com.gulsahozaltun.armutproject.entity.AllServices
import com.gulsahozaltun.armutproject.entity.DetailEntity



interface ServiceOnClickListener {
        fun toServiceDetails(service : AllServices)
    }

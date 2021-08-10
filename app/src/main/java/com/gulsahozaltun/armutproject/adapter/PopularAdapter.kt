package com.gulsahozaltun.armutproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.armutproject.R
import com.gulsahozaltun.armutproject.databinding.PopularCardBinding
import com.gulsahozaltun.armutproject.entity.Popular
import com.gulsahozaltun.armutproject.viewmodel.MainPageViewModel
import com.squareup.picasso.Picasso

class PopularAdapter(var mContext: Context,
                     var popularList:List<Popular>,
                     var viewModel: MainPageViewModel): RecyclerView.Adapter<PopularAdapter.CardTasarimHolder>() {
    inner class CardTasarimHolder(popularCardBinding: PopularCardBinding):RecyclerView.ViewHolder(popularCardBinding.root){
        var cardTasarim: PopularCardBinding
        init {
            this.cardTasarim=popularCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val tasarim=PopularCardBinding.inflate(layoutInflater,parent,false)
        return CardTasarimHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val obj=popularList.get(position)
        val view=holder.cardTasarim
        view.popularObj=obj
        val url=obj.image_url
        Picasso.get().load(url).into(view.categoryImage)
    }

    override fun getItemCount(): Int {
        return popularList.size
    }
}
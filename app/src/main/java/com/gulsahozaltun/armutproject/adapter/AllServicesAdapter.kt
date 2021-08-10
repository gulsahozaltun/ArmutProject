package com.gulsahozaltun.armutproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.armutproject.R
import com.gulsahozaltun.armutproject.R.drawable
import com.gulsahozaltun.armutproject.databinding.AllServicesCardBinding
import com.gulsahozaltun.armutproject.entity.AllServices
import com.gulsahozaltun.armutproject.entity.ServıcesImage
import com.gulsahozaltun.armutproject.fragment.MainPageFragmentDirections
import com.gulsahozaltun.armutproject.viewmodel.MainPageViewModel
import com.squareup.picasso.Picasso

class AllServicesAdapter(var mContext:Context,
                         var servicesList:List<AllServices>,
                         var viewModel: MainPageViewModel,
                         var imageList:List<ServıcesImage>):RecyclerView.Adapter<AllServicesAdapter.CardTasarimHolder>() {

    inner class CardTasarimHolder(allServicesBinding:AllServicesCardBinding):RecyclerView.ViewHolder(allServicesBinding.root){
        var cardTasarim:AllServicesCardBinding
        init {
            this.cardTasarim=allServicesBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimHolder {
        val layoutInflater=LayoutInflater.from(mContext)
        val tasarim=AllServicesCardBinding.inflate(layoutInflater,parent,false)
        return CardTasarimHolder(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val obj=servicesList.get(position)
        val view=holder.cardTasarim
        val image_name=imageList.get(position)
        view.serviceObj=obj

        view.cardAllServices.setOnClickListener{
            val gecis=MainPageFragmentDirections.maintoDetail(obj)
            Navigation.findNavController(it).navigate(gecis)

        }

        holder.cardTasarim.imageView.setImageResource(mContext.resources.getIdentifier(image_name.resim_adi,"drawable",mContext.packageName))

    }

    override fun getItemCount(): Int {
        return servicesList.size
    }
}


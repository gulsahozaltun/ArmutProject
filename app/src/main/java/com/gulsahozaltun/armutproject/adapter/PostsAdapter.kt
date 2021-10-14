package com.gulsahozaltun.armutproject.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.armutproject.MainActivity
import com.gulsahozaltun.armutproject.databinding.BlogCardBinding
import com.gulsahozaltun.armutproject.entity.Posts
import com.gulsahozaltun.armutproject.viewmodel.MainPageViewModel
import com.squareup.picasso.Picasso
import okhttp3.internal.Internal.instance

class PostsAdapter (var mContext: Context,
                        var postsList:List<Posts>,
    ): RecyclerView.Adapter<PostsAdapter.CardTasarimHolder>(){

        inner class CardTasarimHolder(blogBinding: BlogCardBinding):RecyclerView.ViewHolder(blogBinding.root){
            var cardTasarim: BlogCardBinding
            init {
                this.cardTasarim=blogBinding
            }
        }


        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): PostsAdapter.CardTasarimHolder {
            val layoutInflater= LayoutInflater.from(mContext)
            val tasarim=BlogCardBinding.inflate(layoutInflater,parent,false)
            return CardTasarimHolder(tasarim)
        }

    override fun onBindViewHolder(holder: CardTasarimHolder, position: Int) {
        val obj=postsList.get(position)
        val view=holder.cardTasarim
        view.postObj=obj

        val url=obj.image_url
        Picasso.get().load(url).into(view.imageView2)

        view.cardPost.setOnClickListener{
        val ad=AlertDialog.Builder(mContext)
            ad.setMessage(obj.category + " blog yazısına gidilsin mi ?")
            ad.setPositiveButton("Evet"){dialogInterface, i ->
                val urlIntent = Intent(Intent.ACTION_VIEW)
                urlIntent.data = Uri.parse(obj.link)
                mContext.startActivity(urlIntent)
            }
            ad.setNegativeButton("Hayır"){dialogInterface, i ->

            }
            ad.create().show()

        }
    }

        override fun getItemCount(): Int {
            return postsList.size
        }


}


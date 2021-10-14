package com.gulsahozaltun.armutproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.gulsahozaltun.armutproject.R
import com.gulsahozaltun.armutproject.databinding.FragmentDetailPageBinding
import com.gulsahozaltun.armutproject.repo.Repos
import com.squareup.picasso.Picasso


class DetailPageFragment : Fragment() {
    private lateinit var tasarim:FragmentDetailPageBinding
    private lateinit var repo:Repos
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_detail_page, container, false)


        return tasarim.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repo= Repos()
        val bundle:DetailPageFragmentArgs by navArgs()
        tasarim.detailObj=bundle.allServicesArg
        val url=bundle.allServicesArg.image_url
        Picasso.get().load(url).into(tasarim.imageView3)

    }


}
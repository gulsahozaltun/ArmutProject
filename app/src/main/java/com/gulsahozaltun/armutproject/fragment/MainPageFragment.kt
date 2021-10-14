package com.gulsahozaltun.armutproject.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.gulsahozaltun.armutproject.R
import com.gulsahozaltun.armutproject.adapter.AllServicesAdapter
import com.gulsahozaltun.armutproject.adapter.PopularAdapter
import com.gulsahozaltun.armutproject.adapter.PostsAdapter
import com.gulsahozaltun.armutproject.adapter.ServiceOnClickListener
import com.gulsahozaltun.armutproject.databinding.FragmentMainPageBinding
import com.gulsahozaltun.armutproject.entity.AllServices
import com.gulsahozaltun.armutproject.entity.ServiceDetail
import com.gulsahozaltun.armutproject.entity.ServıcesImage
import com.gulsahozaltun.armutproject.repo.GetDataCallback
import com.gulsahozaltun.armutproject.viewmodel.MainPageViewModel


class MainPageFragment : Fragment() {
    private lateinit var tasarim:FragmentMainPageBinding
    private lateinit var adapter: AllServicesAdapter
    private lateinit var viewModel:MainPageViewModel
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var postAdapter:PostsAdapter
    private lateinit var imagesList:ArrayList<ServıcesImage>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim=DataBindingUtil.inflate(inflater,R.layout.fragment_main_page, container, false)
        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tempViewModel: MainPageViewModel by viewModels()
        viewModel = tempViewModel

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val getDataCallback = object : GetDataCallback {
            override fun onGetServiceDetail(serviceDetail: ServiceDetail?) {
                when(serviceDetail) {
                    null -> Toast.makeText(view.context, "Couldn't access this service", Toast.LENGTH_SHORT).show()
                    else -> {
                        val nav = MainPageFragmentDirections.maintoDetail(serviceDetail)
                        Navigation.findNavController(view).navigate(nav)
                    }
                }
            }
            override fun onError() {
                Toast.makeText(view.context, "Couldn't access this service", Toast.LENGTH_SHORT).show()
            }

        }

        val serviceOnClickListener = object : ServiceOnClickListener {
            override fun toServiceDetails(service: AllServices) {
                viewModel.getService(service.id,getDataCallback)

            }
        }

        viewModel.allServicesList.observe(viewLifecycleOwner,{list->

            adapter= AllServicesAdapter(requireContext(),list,imagesList,serviceOnClickListener)
            tasarim.adapter=adapter

        })
        viewModel.popularServicesList.observe(viewLifecycleOwner,{
                poplist->
            popularAdapter= PopularAdapter(requireContext(),poplist)
            tasarim.adapterPopular=popularAdapter
        })

        viewModel.postServiceList.observe(viewLifecycleOwner,{
                postList ->
            postAdapter= PostsAdapter(requireContext(),postList)
            tasarim.postsAdapter=postAdapter
        })
        val c1=ServıcesImage("a1")
        val c2=ServıcesImage("a2")
        val c3=ServıcesImage("a3")
        val c4=ServıcesImage("a4")
        val c5=ServıcesImage("a5")
        val c6=ServıcesImage("ic_saglik")
        val c7=ServıcesImage("a7")
        val c8=ServıcesImage("a8")

        imagesList= ArrayList()
        imagesList.add(c1)
        imagesList.add(c2)
        imagesList.add(c3)
        imagesList.add(c4)
        imagesList.add(c5)
        imagesList.add(c6)
        imagesList.add(c7)
        imagesList.add(c8)

    }





}
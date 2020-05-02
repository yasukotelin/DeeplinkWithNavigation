package com.github.yasukotelin.deeplinkwithnavigation.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.yasukotelin.deeplinkwithnavigation.databinding.FragmentHomeBinding
import com.github.yasukotelin.deeplinkwithnavigation.util.EventObserver

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var dataBinding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by lazy {
        ViewModelProviders.of(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            this.viewModel = homeViewModel
            this.lifecycleOwner = this@HomeFragment
        }
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        homeViewModel.also {
            it.navigateToDetailAction.observe(viewLifecycleOwner, EventObserver {
                findNavController().navigate(HomeFragmentDirections.actionMainToDetail())
            })
            it.navigateToNoticeAction.observe(viewLifecycleOwner, EventObserver {
                findNavController().navigate(HomeFragmentDirections.actionMainToNotice())
            })
        }
    }

}

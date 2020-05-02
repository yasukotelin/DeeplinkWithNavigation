package com.github.yasukotelin.deeplinkwithnavigation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.yasukotelin.deeplinkwithnavigation.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private lateinit var dataBinding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by lazy {
        ViewModelProviders.of(this).get(DetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentDetailBinding.inflate(inflater, container, false).apply {
            this.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
            this.lifecycleOwner = this@DetailFragment
        }
        return dataBinding.root
    }
}

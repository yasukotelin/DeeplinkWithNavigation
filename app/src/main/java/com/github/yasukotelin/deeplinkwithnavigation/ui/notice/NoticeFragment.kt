package com.github.yasukotelin.deeplinkwithnavigation.ui.notice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.yasukotelin.deeplinkwithnavigation.databinding.FragmentNoticeBinding

class NoticeFragment : Fragment() {

    companion object {
        fun newInstance() = NoticeFragment()
    }

    private lateinit var dataBinding: FragmentNoticeBinding
    private val noticeViewModel: NoticeViewModel by lazy {
        ViewModelProviders.of(this).get(NoticeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentNoticeBinding.inflate(inflater, container, false).apply {
            this.toolbar.setNavigationOnClickListener { findNavController().popBackStack() }
            this.lifecycleOwner = this@NoticeFragment
        }
        return dataBinding.root
    }
}

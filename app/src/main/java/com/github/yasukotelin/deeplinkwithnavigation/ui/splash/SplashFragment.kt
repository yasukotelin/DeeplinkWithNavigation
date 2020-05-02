package com.github.yasukotelin.deeplinkwithnavigation.ui.splash

import android.animation.Animator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.yasukotelin.deeplinkwithnavigation.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    companion object {
        fun newInstance() = SplashFragment()
    }

    private lateinit var dataBinding: FragmentSplashBinding
    private val splashViewModel: SplashViewModel by lazy {
        ViewModelProviders.of(this).get(SplashViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentSplashBinding.inflate(inflater, container, false).apply {
            this.animationView.addAnimatorListener(animatorListener)
            this.lifecycleOwner = this@SplashFragment
        }
        return dataBinding.root
    }

    private val animatorListener = object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animation: Animator?) {
        }

        override fun onAnimationEnd(animation: Animator?) {
            findNavController().navigate(SplashFragmentDirections.actionSplashToHome())
        }

        override fun onAnimationCancel(animation: Animator?) {
        }

        override fun onAnimationStart(animation: Animator?) {
        }
    }
}

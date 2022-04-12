package com.binar.networkingsample2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.binar.networkingsample2.databinding.FragmentDetailBinding
import com.binar.networkingsample2.databinding.FragmentListBinding


class DetailFragmen : Fragment() {

    private var fragmentDetailBinding : FragmentDetailBinding?=null
    val args : DetailFragmenArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentDetailBinding = FragmentDetailBinding.inflate(inflater,container,false)
        return fragmentDetailBinding!!.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentDetailBinding?.tvDetailName?.text = args.carName
        fragmentDetailBinding?.tvDetailPrice?.text = args.carPrice.toString()
    }
    override fun onDestroy() {
        super.onDestroy()
        fragmentDetailBinding = null
    }

}
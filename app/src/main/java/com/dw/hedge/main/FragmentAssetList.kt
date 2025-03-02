package com.dw.hedge.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.dw.hedge.databinding.FragmentAssetListBinding
import com.dw.hedge.insert.InsertActivity
import com.dw.hedge.viewmodel.AssetViewModel


class FragmentAssetList : Fragment() {

    private val assetViewModel: AssetViewModel by viewModels()
    private var _binding: FragmentAssetListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAssetListBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        binding.btInsert.setOnClickListener {

            val intent = Intent(requireContext(), InsertActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }


}
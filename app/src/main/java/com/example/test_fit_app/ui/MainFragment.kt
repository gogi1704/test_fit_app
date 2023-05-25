package com.example.test_fit_app.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.test_fit_app.databinding.FragmentMainBinding
import com.example.test_fit_app.ui.adapters.LessonsAdapter
import com.example.test_fit_app.viewModel.LessonsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: LessonsViewModel by activityViewModels()
    private val adapter = LessonsAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        with(binding){
            recycler.adapter = adapter
        }

        viewModel.lessonsLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }












        return binding.root
    }


}
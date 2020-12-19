package com.example.android.gdgfinder.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.android.gdgfinder.databinding.HomeFragmentBinding
import com.example.android.gdgfinder.home.HomeFragmentDirections.actionHomeFragmentToGdgListFragment as toGdgListFragment

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private val navController: NavController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = HomeFragmentBinding.inflate(inflater, container, false)
        .apply {
            this.viewModel = this@HomeFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigateToSearch.observe(viewLifecycleOwner) { navigate ->
            if (navigate) {
                navController.navigate(toGdgListFragment())
                viewModel.onNavigatedToSearch()
            }
        }
    }
}

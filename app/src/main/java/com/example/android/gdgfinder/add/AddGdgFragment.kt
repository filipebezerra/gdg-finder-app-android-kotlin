package com.example.android.gdgfinder.add

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.android.gdgfinder.R
import com.example.android.gdgfinder.databinding.AddGdgFragmentBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class AddGdgFragment : Fragment() {

    private val viewModel: AddGdgViewModel by lazy {
        ViewModelProvider(this).get(AddGdgViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = AddGdgFragmentBinding.inflate(inflater)

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.showSnackBarEvent.observe(viewLifecycleOwner, {
            if (it == true) {
                MaterialAlertDialogBuilder(requireContext())
                    .setMessage(R.string.application_submitted)
                    .setPositiveButton(R.string.i_got_it, null)
                    .show()
                viewModel.doneShowingSnackbar()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }

}

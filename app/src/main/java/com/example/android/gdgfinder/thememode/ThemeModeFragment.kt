package com.example.android.gdgfinder.thememode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import com.example.android.gdgfinder.databinding.ThemeModeFragmentBinding
import com.example.android.gdgfinder.databinding.ThemeModeFragmentBinding.*
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ThemeModeFragment : BottomSheetDialogFragment() {
    private val viewModel: ThemeModeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflate(inflater, container, false)
        .apply {
            viewModel = this@ThemeModeFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewModel) {
            themeModeSelected.observe(viewLifecycleOwner) {
                AppCompatDelegate.setDefaultNightMode(it)
                dismiss()
            }
        }
    }
}
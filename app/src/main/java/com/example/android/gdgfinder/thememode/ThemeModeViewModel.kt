package com.example.android.gdgfinder.thememode

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ThemeModeViewModel : ViewModel() {
    private val _themeModeSelected = MutableLiveData<Int>()
    val themeModeSelected: LiveData<Int>
        get() = _themeModeSelected

    fun onChooseDayMode() {
        _themeModeSelected.value = AppCompatDelegate.MODE_NIGHT_NO
    }

    fun onChooseNightMode() {
        _themeModeSelected.value = AppCompatDelegate.MODE_NIGHT_YES
    }
}
package com.example.prak8.viewmodel

import androidx.lifecycle.ViewModel
import com.example.prak8.model.Siswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SiswaViewModel : ViewModel() {

    private val _statusUI = MutableStateFlow(Siswa())
    val statusUI: StateFlow<Siswa> = _statusUI

    fun setSiswa(siswa: Siswa) {
        _statusUI.value = siswa
    }
}

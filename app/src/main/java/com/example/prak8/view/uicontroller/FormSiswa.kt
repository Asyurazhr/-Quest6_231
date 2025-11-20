package com.example.prak8.view.uicontroller

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.prak8.R
import com.example.prak8.model.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (Siswa) -> Unit
) {
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtGender by rememberSaveable { mutableStateOf("") }
    var txtAlamat by rememberSaveable { mutableStateOf("") }

    val dataSiswa = Siswa(
        nama = txtNama,
        gender = txtGender,
        alamat = txtAlamat
    )


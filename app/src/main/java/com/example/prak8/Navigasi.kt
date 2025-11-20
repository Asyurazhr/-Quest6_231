package com.example.prak8

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.prak8.view.uicontroller.FormSiswa
import com.example.prak8.view.uicontroller.TampilSiswa
import com.example.prak8.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

// list id string jenis kelamin
val JenisK = listOf(
    R.string.laki,
    R.string.wanita
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
) {
    val navController: NavHostController = rememberNavController()
    val uiState by viewModel.statusUI.collectAsState()

    Scaffold(modifier = modifier) { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.Formulir.name) {
                val konteks = LocalContext.current
                FormSiswa(
                    pilihanJK = JenisK.map { id -> konteks.resources.getString(id) },
                    onSubmitButtonClicked = {
                        viewModel.setSiswa(it)
                        navController.navigate(route = Navigasi.Detail.name)
                    }
                )
            }

            composable(route = Navigasi.Detail.name) {
                TampilSiswa(
                    statusUISiswa = uiState,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}

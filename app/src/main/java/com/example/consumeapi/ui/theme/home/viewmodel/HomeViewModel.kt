package com.example.consumeapi.ui.theme.home.viewmodel

import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.consumeapi.model.Kontak
import com.example.consumeapi.repository.KontakRepository
import kotlinx.coroutines.launch
import okio.IOException

sealed class KontakUIState{
    data class Success(val kontak: List <Kontak>): KontakUIState()
    object Error : KontakUIState()
    object Loading : KontakUIState()
}

class HomeViewModel (private val kontakRepository: KontakRepository) : ViewModel(){
    var kontakUIState: KontakUIState by mutableStateOf(KontakUIState.Loading)
        private set

    init {
        getKontak()
    }

    fun getKontak() {
        viewModelScope.launch {
            kontakUIState = KontakUIState.Loading
            kontakUIState = try {
                KontakUIState.Success(kontakRepository.getKontak())
            } catch (e:IOException){
                KontakUIState.Error
            } catch (e:retrofit2.HttpException) {
                KontakUIState.Error
            }
        }
    }
}
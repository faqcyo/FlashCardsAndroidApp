package com.example.flashcards.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.flashcards.ui.events.HomeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {
    init {

    }

    fun onEvent(event: HomeEvent) {
        when(event) {
            HomeEvent.OnFlashCardCreateButtonClicked -> {

            }
            HomeEvent.OnFolderCreateButtonClicked -> {

            }
        }
    }
}
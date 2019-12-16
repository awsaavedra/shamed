package com.example.shamed.ui.main

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PlayerRepository

    val player : LiveData<Player>

    init {
        val playerDao = PlayerRoomDatabase.getDatabase(application).playerDao()
        repository = PlayerRepository(playerDao)
        player =  repository.player
    }

    fun save(player: Player) = viewModelScope.launch{
        repository.insert(player)
    }
}

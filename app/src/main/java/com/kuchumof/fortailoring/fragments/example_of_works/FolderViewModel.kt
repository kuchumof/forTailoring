package com.kuchumof.fortailoring.fragments.example_of_works

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.kuchumof.fortailoring.db.AppDatabase
import com.kuchumof.fortailoring.model.FolderItemModel
import com.kuchumof.fortailoring.constant.SeasonEnum.*
import com.kuchumof.fortailoring.repository.FolderRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FolderViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getAppDatabase(application)
    private val repository = FolderRepository(db.folderDao())

    /*private val listFolderItemModels = listOf(
        FolderItemModel(1, "Штаны", SUMMER),
        FolderItemModel(2, "Платья", SUMMER),
        FolderItemModel(3, "Блузки", SUMMER),
        FolderItemModel(4, "Футболки", SUMMER),
        FolderItemModel(5, "Юбки", SUMMER),

        FolderItemModel(1, "Штаны", WINTER),
        FolderItemModel(2, "Костюмы", WINTER),
        FolderItemModel(3, "Худи", WINTER)

    )*/

    //Обёртка для автоматического отслеживания изменения в данных в списке
    /**@param listFolderItemModels.filter - фильтрация элемента в списке*/
    private val _foldersSummer = MutableStateFlow<List<FolderItemModel>>(
        emptyList()
    )
    val foldersSummer: StateFlow<List<FolderItemModel>> = _foldersSummer.asStateFlow()

    //Обёртка для автоматического отслеживания изменения в данных в списке
    /**@param listFolderItemModels.filter - фильтрация элемента в списке*/
    private val _foldersWinter = MutableStateFlow<List<FolderItemModel>>(
        emptyList()
    )
    val foldersWinter: StateFlow<List<FolderItemModel>> = _foldersWinter.asStateFlow()

    init {

        viewModelScope.launch {

            /*db.folderDao().insertAll(
                listOf(
                    FolderItemModel(1, "Штаны", SUMMER),
                    FolderItemModel(2, "Платья", SUMMER),
                    FolderItemModel(3, "Блузки", SUMMER),
                    FolderItemModel(4, "Футболки", SUMMER),
                    FolderItemModel(5, "Юбки", SUMMER),

                    FolderItemModel(6, "Штаны", WINTER),
                    FolderItemModel(7, "Костюмы", WINTER),
                    FolderItemModel(8, "Худи", WINTER)
                )
            )*/
            repository.getAllSummer().collect { newItems ->
                _foldersSummer.update { newItems }
            }
        }
            viewModelScope.launch {
                repository.getAllWinter().collect { newItems ->
                _foldersWinter.update { newItems }
            }
        }
    }

    /*fun addFolder() {
        _uiState.update { currentState ->
            currentState.copy(
                firstDieValue = Random.nextInt(from = 1, until = 7),
                secondDieValue = Random.nextInt(from = 1, until = 7),
                numberOfRolls = currentState.numberOfRolls + 1,
            )
        }
    }*/
}
